package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.BaseConhecimento;
import com.hbr.baseconhecimento.model.Categoria;
import com.hbr.baseconhecimento.model.Projeto;
import com.hbr.baseconhecimento.model.Tecnico;
import com.hbr.baseconhecimento.service.BaseConhecimentoService;
import com.hbr.baseconhecimento.service.CategoriaService;
import com.hbr.baseconhecimento.service.NegocioException;
import com.hbr.baseconhecimento.service.ProjetoService;
import com.hbr.baseconhecimento.service.TecnicoService;

@Named
@ViewScoped
public class CadastroBaseConhecimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Inject
	private BaseConhecimentoService baseConhecimentoService;

	@Inject
	private CategoriaService categoriaService;
	
	@Inject
	private TecnicoService tecnicoService;
	
	@Inject
	private ProjetoService projetoService;
	
	private BaseConhecimento baseConhecimento;
	
	private List<Categoria> todasCategorias;
	private List<Projeto> todosProjetos;
	private List<Tecnico> todosTecnicos;

	public void prepararCadastro() throws NegocioException {
		this.todasCategorias = this.categoriaService.todos();
		this.todosProjetos = this.projetoService.todos();
		this.todosTecnicos = this.tecnicoService.todos();
		
		if (this.baseConhecimento == null) {
			this.baseConhecimento = new BaseConhecimento();
		}
	}

	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			this.baseConhecimentoService.salvar(this.baseConhecimento);
			
			this.baseConhecimento = new BaseConhecimento();
			context.addMessage(null, new FacesMessage("Conhecimento salvo com sucesso!"));
		} catch (NegocioException e) {
			
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}
	
	public BaseConhecimento getBaseConhecimento() {
		return baseConhecimento;
	}

	public void setBaseConhecimento(BaseConhecimento baseConhecimento) {
		this.baseConhecimento = baseConhecimento;
	}

	public List<Categoria> getTodasCategorias() {
		return todasCategorias;
	}

	public void setTodasCategorias(List<Categoria> todasCategorias) {
		this.todasCategorias = todasCategorias;
	}

	public List<Projeto> getTodosProjetos() {
		return todosProjetos;
	}

	public void setTodosProjetos(List<Projeto> todosProjetos) {
		this.todosProjetos = todosProjetos;
	}

	public List<Tecnico> getTodosTecnicos() {
		return todosTecnicos;
	}

	public void setTodosTecnicos(List<Tecnico> todosTecnicos) {
		this.todosTecnicos = todosTecnicos;
	}
	

}
