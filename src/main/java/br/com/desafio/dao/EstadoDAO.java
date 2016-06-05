package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.bo.Estado;

public interface EstadoDAO {

	Estado findById(long id);

	Estado findByName(String name);

	void saveEstado(Estado estado);

	void updateEstado(Estado estado);

	void deleteEstadoById(long id);

	List<Estado> findAll();

	void deleteAll();

	public boolean estadoExiste(Estado estado);
	
}
