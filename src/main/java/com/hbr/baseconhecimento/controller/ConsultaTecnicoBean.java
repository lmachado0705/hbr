package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.Tecnico;
import com.hbr.baseconhecimento.service.NegocioException;
import com.hbr.baseconhecimento.service.TecnicoService;

@Named
@ViewScoped
public class ConsultaTecnicoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TecnicoService tecnicoService;

	private List<Tecnico> tecnicos;

	private Tecnico tecnicoSelecionado;

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.tecnicoService.excluir(this.tecnicoSelecionado);
			this.consultar();

			context.addMessage(null, new FacesMessage("Técnico excluído com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() throws NegocioException {
		this.tecnicos = tecnicoService.todos();
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}

	public Tecnico getTecnicoSelecionado() {
		return tecnicoSelecionado;
	}

	public void setTecnicoSelecionado(Tecnico tecnicoSelecionado) {
		this.tecnicoSelecionado = tecnicoSelecionado;
	}

}
