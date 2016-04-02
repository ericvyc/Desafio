package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.dao.PessoaDAO;
import br.com.desafio.entity.Pessoa;

public class PessoaDAOImpl implements PessoaDAO, Serializable {

	private static final long serialVersionUID = -6368358918731707106L;

	@Override
	public Pessoa findById(long id) {
		return null;
	}

	@Override
	public Pessoa findByName(String name) {
		return null;
	}

	@Override
	public void savePessoa(Pessoa pessoa) {

	}

	@Override
	public void updatePessoa(Pessoa pessoa) {

	}

	@Override
	public void deletePessoaById(long id) {

	}

	@Override
	public List<Pessoa> findAll() {
		return null;
	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean pessoaExiste(Pessoa pessoa) {
		return false;
	}

}
