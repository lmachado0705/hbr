package com.hbr.baseconhecimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.hbr.baseconhecimento.model.Tecnico;

public class TecnicoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public TecnicoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Tecnico porId(Long id) {
		return manager.find(Tecnico.class, id);
	}

	public List<Tecnico> todos() {
		TypedQuery<Tecnico> query = manager.createQuery("from Tecnico", Tecnico.class);
		return query.getResultList();
	}

	public void adicionar(Tecnico tecnico) {
		this.manager.persist(tecnico);
	}

	public Tecnico guardar(Tecnico tecnico) {
		return this.manager.merge(tecnico);
	}

	public void remover(Tecnico tecnico) {
		this.manager.remove(tecnico);
	}
}
