package br.com.desafio.dao;

import java.util.List;

import br.com.desafio.bo.EnderecoBO;

public interface EnderecoDAO {

	EnderecoBO findById(long id);

	EnderecoBO findByName(String name);

	void saveEndereco(EnderecoBO endereco);

	void updateEndereco(EnderecoBO endereco);

	void deleteEnderecoById(long id);

	List<EnderecoBO> findAll();

	void deleteAll();

	public boolean enderecoExiste(EnderecoBO endereco);

}
