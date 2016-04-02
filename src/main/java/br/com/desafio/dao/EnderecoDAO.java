package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.entity.Endereco;

public interface EnderecoDAO {

	Endereco findById(long id);

	Endereco findByName(String name);

	void saveEndereco(Endereco endereco);

	void updateEndereco(Endereco endereco);

	void deleteEnderecoById(long id);

	List<Endereco> findAll();

	void deleteAll();

	public boolean enderecoExiste(Endereco endereco);

}
