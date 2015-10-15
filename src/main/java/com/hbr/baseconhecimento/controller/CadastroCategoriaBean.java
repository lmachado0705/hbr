package com.hbr.baseconhecimento.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.Categoria;
import com.hbr.baseconhecimento.service.CategoriaService;
import com.hbr.baseconhecimento.service.NegocioException;

@Named
@javax.faces.view.ViewScoped
public class CadastroCategoriaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService cadastro;

	private Categoria categoria;

	public void prepararCadastro() {

		if (this.categoria == null) {
			this.categoria = new Categoria();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.cadastro.salvar(this.categoria);

			this.categoria = new Categoria();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
