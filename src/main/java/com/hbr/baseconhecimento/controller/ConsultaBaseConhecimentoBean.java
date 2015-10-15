package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.BaseConhecimento;
import com.hbr.baseconhecimento.service.BaseConhecimentoService;
import com.hbr.baseconhecimento.service.NegocioException;

@Named
@ViewScoped
public class ConsultaBaseConhecimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BaseConhecimentoService baseConhecimentoService;
	

	private List<BaseConhecimento> bases;

	private BaseConhecimento baseSelecionado;

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.baseConhecimentoService.excluir(this.baseSelecionado);
			this.consultar();

			context.addMessage(null, new FacesMessage("Base excluída com sucesso!"));
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public void consultar() throws NegocioException {
		this.bases = baseConhecimentoService.todos();
	}

	public List<BaseConhecimento> getBases() {
		return bases;
	}

	public void setBases(List<BaseConhecimento> bases) {
		this.bases = bases;
	}

	public BaseConhecimento getBaseSelecionado() {
		return baseSelecionado;
	}

	public void setBaseSelecionado(BaseConhecimento baseSelecionado) {
		this.baseSelecionado = baseSelecionado;
	}


}
