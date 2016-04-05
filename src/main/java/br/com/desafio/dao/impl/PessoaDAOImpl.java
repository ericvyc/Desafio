package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.bo.PessoaBO;
import br.com.desafio.dao.PessoaDAO;

public class PessoaDAOImpl implements PessoaDAO, Serializable {

	private static final long serialVersionUID = -6368358918731707106L;

	@Override
	public PessoaBO findById(long id) {
		return null;
	}

	@Override
	public PessoaBO findByName(String name) {
		return null;
	}

	@Override
	public void savePessoa(PessoaBO pessoa) {

	}

	@Override
	public void updatePessoa(PessoaBO pessoa) {

	}

	@Override
	public void deletePessoaById(long id) {

	}

	@Override
	public List<PessoaBO> findAll() {
		return null;
	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean pessoaExiste(PessoaBO pessoa) {
		return false;
	}

}
