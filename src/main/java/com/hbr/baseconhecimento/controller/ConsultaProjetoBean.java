package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

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
public class ConsultaProjetoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjetoService projetoService;
	

	private List<Projeto> projetos;

	private Projeto projetoSelecionado;

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.projetoService.excluir(this.projetoSelecionado);
			this.consultar();

			context.addMessage(null, new FacesMessage("Projeto excluído com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() throws NegocioException {
		this.projetos = projetoService.todos();
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}
	

}
