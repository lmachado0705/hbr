package com.hbr.baseconhecimento.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.Projeto;
import com.hbr.baseconhecimento.service.NegocioException;
import com.hbr.baseconhecimento.service.ProjetoService;

@Named
@ViewScoped
public class CadastroProjetoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjetoService projetoService;

	private Projeto projeto;

	public void prepararCadastro() {

		if (this.projeto == null) {
			this.projeto = new Projeto();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.projetoService.salvar(this.projeto);

			this.projeto = new Projeto();
			context.addMessage(null, new FacesMessage("Projeto salvo com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
}
