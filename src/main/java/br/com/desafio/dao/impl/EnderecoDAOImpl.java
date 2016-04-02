package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.dao.EnderecoDAO;
import br.com.desafio.entity.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO, Serializable {

	private static final long serialVersionUID = -4841405610089828021L;

	@Override
	public Endereco findById(long id) {
		return null;
	}

	@Override
	public Endereco findByName(String name) {
		return null;
	}

	@Override
	public void saveEndereco(Endereco endereco) {

	}

	@Override
	public void updateEndereco(Endereco endereco) {

	}

	@Override
	public void deleteEnderecoById(long id) {

	}

	@Override
	public List<Endereco> findAll() {
		return null;
	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean enderecoExiste(Endereco endereco) {
		return false;
	}

}
