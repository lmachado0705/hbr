package com.hbr.baseconhecimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hbr.baseconhecimento.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}

	public List<Categoria> todos() {
		TypedQuery<Categoria> query = manager.createQuery("from Categoria", Categoria.class);
		return query.getResultList();
	}

	public void adicionar(Categoria categoria) {
		this.manager.persist(categoria);
	}

	public Categoria guardar(Categoria categoria) {
		return this.manager.merge(categoria);
	}

	public void remover(Categoria categoria) {
		this.manager.remove(categoria);
	}

	public List<String> descricoesQueContem(String descricao) {
		TypedQuery<String> query = manager.createQuery(
				"select distinct modalidade from Categoria " + "where upper(modalidade) like upper(:descricao)",
				String.class);
		query.setParameter("modalidade", "%" + descricao + "%");
		return query.getResultList();
	}
}
