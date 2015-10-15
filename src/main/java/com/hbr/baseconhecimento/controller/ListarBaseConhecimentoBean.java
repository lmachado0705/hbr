package com.hbr.baseconhecimento.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hbr.baseconhecimento.model.BaseConhecimento;
import com.hbr.baseconhecimento.service.BaseConhecimentoService;
import com.hbr.baseconhecimento.service.NegocioException;

@Named
@ViewScoped
public class ListarBaseConhecimentoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private BaseConhecimentoService baseConhecimentoService;

	private String nome;
	
	private List<BaseConhecimento> bases;

	private BaseConhecimento baseSelecionado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<BaseConhecimento> getBases() {
		return bases;
	}

	public void setBases(List<BaseConhecimento> bases) {
		this.bases = bases;
	}
	
	public List<BaseConhecimento> buscarBases() throws NegocioException{
		return baseConhecimentoService.retornaBase(nome);
	}

}
