package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.bo.PessoaBO;
import br.com.desafio.dao.PessoaDAO;

@Service("pessoaService")
@Transactional
public class PessoaDAOImpl implements PessoaDAO, Serializable {

	private static final long serialVersionUID = -6368358918731707106L;

	private static final AtomicLong contador = new AtomicLong();

	private static List<PessoaBO> pessoas = new ArrayList<PessoaBO>();

	static {
		pessoas = popular();
	}

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
		pessoa.setId(contador.incrementAndGet());
		pessoas.add(pessoa);
	}

	@Override
	public void updatePessoa(PessoaBO pessoa) {

	}

	@Override
	public void deletePessoaById(long id) {

	}

	@Override
	public List<PessoaBO> findAll() {
		return pessoas;
	}

	@Override
	public void deleteAll() {

	}

	@Override
	public boolean pessoaExiste(PessoaBO pessoa) {
		return false;
	}

	private static List<PessoaBO> popular() {
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Eric", "12-08-1995", 'M', "01816298603"));
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Vilar", "11-09-1995", 'M', "01816298603"));
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Yankous", "10-10-1995", 'M', "01816298603"));
		return pessoas;
	}

}
