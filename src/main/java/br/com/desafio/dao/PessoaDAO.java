package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.entity.Pessoa;

public interface PessoaDAO {

	Pessoa findById(long id);

	Pessoa findByName(String name);

	void savePessoa(Pessoa pessoa);

	void updatePessoa(Pessoa pessoa);

	void deletePessoaById(long id);

	List<Pessoa> findAll();

	void deleteAll();

	public boolean pessoaExiste(Pessoa pessoa);

}
