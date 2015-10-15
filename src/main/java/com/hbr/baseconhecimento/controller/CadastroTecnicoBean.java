package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import com.hbr.baseconhecimento.model.Categoria;
import com.hbr.baseconhecimento.model.Tecnico;
import com.hbr.baseconhecimento.service.CategoriaService;
import com.hbr.baseconhecimento.service.NegocioException;
import com.hbr.baseconhecimento.service.TecnicoService;

@Named
@ViewScoped
public class CadastroTecnicoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Inject
	private TecnicoService tecnicoService;

	@Inject
	private CategoriaService categoriaService;
	
	private Tecnico tecnico;
	
	private List<Categoria> todasCategorias;

	public void prepararCadastro() throws NegocioException {
		this.todasCategorias = this.categoriaService.todos();
		if (this.tecnico == null) {
			this.tecnico = new Tecnico();
		}
	}

	public List<String> pesquisarDescricoes(String descricao) throws NegocioException {
		return this.categoriaService.descricoesQueContem(descricao);
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.tecnicoService.salvar(this.tecnico);
			
			this.tecnico = new Tecnico();
			context.addMessage(null, new FacesMessage("Técnico salvo com sucesso!"));
		} catch (NegocioException e) {
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Categoria> getTodasCategorias() {
		return todasCategorias;
	}

	public void setTodasCategorias(List<Categoria> todasCategorias) {
		this.todasCategorias = todasCategorias;
	}
	
	

}
