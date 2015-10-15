package com.hbr.baseconhecimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hbr.baseconhecimento.model.Projeto;

public class ProjetoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public ProjetoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Projeto porId(Long id) {
		return manager.find(Projeto.class, id);
	}

	public List<Projeto> todos() {
		TypedQuery<Projeto> query = manager.createQuery("from Projeto", Projeto.class);
		return query.getResultList();
	}

	public void adicionar(Projeto projeto) {
		this.manager.persist(projeto);
	}

	public Projeto guardar(Projeto projeto) {
		return this.manager.merge(projeto);
	}

	public void remover(Projeto projeto) {
		this.manager.remove(projeto);
	}

}
