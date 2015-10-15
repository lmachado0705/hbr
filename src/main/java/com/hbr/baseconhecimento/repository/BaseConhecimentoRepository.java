package com.hbr.baseconhecimento.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.hbr.baseconhecimento.model.BaseConhecimento;

public class BaseConhecimentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public BaseConhecimentoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public BaseConhecimento porId(Long id) {
		return manager.find(BaseConhecimento.class, id);
	}

	public List<BaseConhecimento> todos() {
		TypedQuery<BaseConhecimento> query = manager.createQuery("from BaseConhecimento", BaseConhecimento.class);
		return query.getResultList();
	}

	public void adicionar(BaseConhecimento baseConhecimento) {
		this.manager.persist(baseConhecimento);
	}

	public BaseConhecimento guardar(BaseConhecimento baseConhecimento) {
		return this.manager.merge(baseConhecimento);
	}

	public void remover(BaseConhecimento baseConhecimento) {
		this.manager.remove(baseConhecimento);
	}

	public List<BaseConhecimento> retornaBase(String nome) {
		
				Query query = manager.createQuery(
				"select id,projeto,categoria,tecnico,data,problemaEncontrado,resolucao from BaseConhecimento "
				+ "where problemaEncontrado like upper(:nome)",BaseConhecimento.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
		
	}
}
