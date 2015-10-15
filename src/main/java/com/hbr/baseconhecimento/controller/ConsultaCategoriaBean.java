package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.Categoria;
import com.hbr.baseconhecimento.repository.CategoriaRepository;
import com.hbr.baseconhecimento.service.CategoriaService;
import com.hbr.baseconhecimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaCategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService categoriaService;
	

	private List<Categoria> categorias;

	private Categoria categoriaSelecionada;

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.categoriaService.excluir(this.categoriaSelecionada);
			this.consultar();

			context.addMessage(null, new FacesMessage("Categoria excluída com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() throws NegocioException {
		this.categorias = categoriaService.todos();
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

}
