package br.com.desafio.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
		for(PessoaBO pessoa : pessoas){
			if(pessoa.getId() == id){
				return pessoa;
			}
		}
		return null;
	}

	@Override
	public PessoaBO findByName(String name) {
		for(PessoaBO pessoa : pessoas){
			if(pessoa.getNome() == name){
				return pessoa;
			}
		}
		return null;
	}

	@Override
	public void savePessoa(PessoaBO pessoa) {
		pessoa.setId(contador.incrementAndGet());
		pessoas.add(pessoa);
	}

	@Override
	public void updatePessoa(PessoaBO pessoa) {
		int index = pessoas.indexOf(pessoa);
		pessoas.set(index, pessoa);
	}

	@Override
	public void deletePessoaById(long id) {
		for (Iterator<PessoaBO> iterator = pessoas.iterator(); iterator.hasNext(); ) {
			PessoaBO pessoa = iterator.next();
			if (pessoa.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public List<PessoaBO> findAll() {
		return pessoas;
	}

	@Override
	public void deleteAll() {
		pessoas.clear();
	}

	@Override
	public boolean pessoaExiste(PessoaBO pessoa) {
		return findByName(pessoa.getNome())!=null;
	}

	private static List<PessoaBO> popular() {
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Eric", "12-08-1995", 'M', "01816298603"));
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Vilar", "11-09-1995", 'M', "01816298603"));
		pessoas.add(new PessoaBO(contador.incrementAndGet(), "Yankous", "10-10-1995", 'M', "01816298603"));
		return pessoas;
	}

}
