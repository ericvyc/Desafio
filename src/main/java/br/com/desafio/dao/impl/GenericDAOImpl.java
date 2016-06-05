package br.com.desafio.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.desafio.dao.GenericDAO;

public class GenericDAOImpl implements GenericDAO {

	private static final long serialVersionUID = -2345026837326553851L;

	@Override
	public EntityManager getEntityManager() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("desafio");
		
		EntityManager entityManager = factory.createEntityManager();
		
		return entityManager;
	}

	@Override
	public void openTransaction() {
		getEntityManager().getTransaction().begin();
	}

	@Override
	public void finishTransaction() {
		getEntityManager().close();
	}

	@Override
	public void commitTransaction() {
		getEntityManager().getTransaction().commit();
	}

	@Override
	public void rollbackTransaction() {
		getEntityManager().getTransaction().rollback();
	}

}
