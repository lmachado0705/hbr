package com.hbr.baseconhecimento.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.hbr.baseconhecimento.model.Categoria;
import com.hbr.baseconhecimento.repository.CategoriaRepository;
import com.hbr.baseconhecimento.util.Transactional;

public class CategoriaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository repositorio;

	@Transactional
	public void salvar(Categoria categoria) throws NegocioException {

		this.repositorio.guardar(categoria);
	}

	@Transactional
	public void excluir(Categoria categoria) throws NegocioException {
		categoria = this.repositorio.porId(categoria.getId());
		this.repositorio.remover(categoria);
	}

	@Transactional
	public List<Categoria> todos() throws NegocioException {
		return this.repositorio.todos();
	}
	
	@Transactional
	public List<String> descricoesQueContem(String descricao) throws NegocioException {
		return this.repositorio.descricoesQueContem(descricao);
	}

		
	
		

}
