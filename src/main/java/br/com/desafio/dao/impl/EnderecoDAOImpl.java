package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.bo.EnderecoBO;
import br.com.desafio.dao.EnderecoDAO;

public class EnderecoDAOImpl implements EnderecoDAO, Serializable {

	private static final long serialVersionUID = -4841405610089828021L;

	@Override
	public EnderecoBO findById(long id) {
		return null;
	}

	@Override
	public EnderecoBO findByName(String name) {
		return null;
	}

	@Override
	public void saveEndereco(EnderecoBO endereco) {

	}

	@Override
	public void updateEndereco(EnderecoBO endereco) {

	}

	@Override
	public void deleteEnderecoById(long id) {

	}

	@Override
	public List<EnderecoBO> findAll() {
		return null;
	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean enderecoExiste(EnderecoBO endereco) {
		return false;
	}

}
