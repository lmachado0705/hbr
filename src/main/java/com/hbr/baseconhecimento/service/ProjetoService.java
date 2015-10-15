package com.hbr.baseconhecimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hbr.baseconhecimento.model.Projeto;
import com.hbr.baseconhecimento.repository.ProjetoRepository;
import com.hbr.baseconhecimento.util.Transactional;

public class ProjetoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProjetoRepository repositorio;

	@Transactional
	public void salvar(Projeto projeto) throws NegocioException {

		this.repositorio.guardar(projeto);
	}

	@Transactional
	public void excluir(Projeto projeto) throws NegocioException {
		projeto = this.repositorio.porId(projeto.getId());
		this.repositorio.remover(projeto);
	}

}
