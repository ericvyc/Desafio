package br.com.desafio.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

public interface GenericDAO extends Serializable {

	public EntityManager getEntityManager();
	
	public void openTransaction();
	
	public void finishTransaction();
	
	public void commitTransaction();
	
	public void rollbackTransaction();
	
}
