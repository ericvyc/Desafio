package br.com.desafio.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.bo.Estado;
import br.com.desafio.dao.EstadoDAO;

@Service("estadoService")
@Transactional
public class EstadoDAOImpl extends GenericDAOImpl implements EstadoDAO {

	private static final long serialVersionUID = 2675489617709284989L;
	
	@Override
	public Estado findById(long id) {
		
		EntityManager em = getEntityManager();
		em.find(Estado.class, 1L);
		
		return null;
	}

	@Override
	public Estado findByName(String name) {
		return null;
	}

	@Override
	public void saveEstado(Estado estado) {
		
	}

	@Override
	public void updateEstado(Estado estado) {
		
	}

	@Override
	public void deleteEstadoById(long id) {
		
	}

	@Override
	public List<Estado> findAll() {
		
		openTransaction();
		
		getEntityManager().createQuery("Select e from " + Estado.class + " e").getResultList();
		
		commitTransaction();
		finishTransaction();
		
		return null;
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public boolean estadoExiste(Estado estado) {
		return false;
	}

}
