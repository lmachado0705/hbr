package com.hbr.baseconhecimento.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.hbr.baseconhecimento.model.BaseConhecimento;
import com.hbr.baseconhecimento.repository.BaseConhecimentoRepository;
import com.hbr.baseconhecimento.util.Transactional;

public class BaseConhecimentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private BaseConhecimentoRepository repositorio;

	@Transactional
	public void salvar(BaseConhecimento base) throws NegocioException {
		if (base.getData() == null) {
			throw new NegocioException("Data não pode ser em branco.");
		}

		this.repositorio.guardar(base);
	}

	@Transactional
	public void excluir(BaseConhecimento base) throws NegocioException {
		base = this.repositorio.porId(base.getId());
		this.repositorio.remover(base);
	}
	
	@Transactional
	public List<BaseConhecimento> todos() throws NegocioException {
		return repositorio.todos();
	}
	@Transactional
	public List<BaseConhecimento> retornaBase(String nome) throws NegocioException {
		return repositorio.retornaBase(nome);
	}
	
	@Transactional
	public List<BaseConhecimento> buscarPorCategoria(String categoria) throws NegocioException {
		return repositorio.buscarPorCategoria(categoria);
	}

}
