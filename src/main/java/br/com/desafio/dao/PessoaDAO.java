package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.bo.PessoaBO;

public interface PessoaDAO {

	PessoaBO findById(long id);

	PessoaBO findByName(String name);

	void savePessoa(PessoaBO pessoa);

	void updatePessoa(PessoaBO pessoa);

	void deletePessoaById(long id);

	List<PessoaBO> findAll();

	void deleteAll();

	public boolean pessoaExiste(PessoaBO pessoa);

}
