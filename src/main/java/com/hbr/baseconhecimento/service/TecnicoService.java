package com.hbr.baseconhecimento.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hbr.baseconhecimento.model.Tecnico;
import com.hbr.baseconhecimento.repository.TecnicoRepository;
import com.hbr.baseconhecimento.util.Transactional;

public class TecnicoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TecnicoRepository repositorio;

	@Transactional
	public void salvar(Tecnico tecnico) throws NegocioException {

		this.repositorio.guardar(tecnico);
	}

	@Transactional
	public void excluir(Tecnico tecnico) throws NegocioException {
		tecnico = this.repositorio.porId(tecnico.getId());
		this.repositorio.remover(tecnico);
	}

}
