package br.com.desafio.endPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.bo.PessoaBO;
import br.com.desafio.dao.PessoaDAO;

@RestController
public class PessoaEndPoint {

	@Autowired
	PessoaDAO pessoaDAO;

	@RequestMapping(value = "/pessoas/", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaBO>> listAllUsers() {
		List<PessoaBO> pessoas = pessoaDAO.findAll();
		if (pessoas.isEmpty()) {
			return new ResponseEntity<List<PessoaBO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PessoaBO>>(pessoas, HttpStatus.OK);
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaBO> getPessoa(@PathVariable("id") long id) {
		System.out.println("Buscando pessoa com id " + id);
		PessoaBO pessoa = pessoaDAO.findById(id);
		if (pessoa == null) {
			System.out.println("Pessoa com id " + id + " não encontrada");
			return new ResponseEntity<PessoaBO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PessoaBO>(pessoa, HttpStatus.OK);
	}

	@RequestMapping(value = "/pessoa/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPessoa(@RequestBody PessoaBO pessoa, UriComponentsBuilder ucBuilder) {
		System.out.println("Criando pessoa " + pessoa.getNome());

		if (pessoaDAO.pessoaExiste(pessoa)) {
			System.out.println("Uma pessoa com o nome " + pessoa.getNome() + " já existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		pessoaDAO.savePessoa(pessoa);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<PessoaBO> updatePessoa(@PathVariable("id") long id, @RequestBody PessoaBO pessoa) {
		System.out.println("Updating User " + id);

		PessoaBO estaPessoa = pessoaDAO.findById(id);

		if (estaPessoa==null) {
			System.out.println("Pessoa com id " + id + " não encontrado");
			return new ResponseEntity<PessoaBO>(HttpStatus.NOT_FOUND);
		}

		estaPessoa.setCpf(pessoa.getCpf());
		estaPessoa.setDataNascimento(pessoa.getDataNascimento());
		estaPessoa.setNome(pessoa.getNome());
		estaPessoa.setSexo(pessoa.getSexo());

		pessoaDAO.updatePessoa(estaPessoa);
		return new ResponseEntity<PessoaBO>(estaPessoa, HttpStatus.OK);
	}

	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PessoaBO> deletePessoa(@PathVariable("id") long id) {
		System.out.println("Buscando e deletando pessoa com o id " + id);

		PessoaBO pessoa = pessoaDAO.findById(id);
		if (pessoa == null) {
			System.out.println("Não foi possivel deletar. Pessoa com id " + id + " não encontrado");
			return new ResponseEntity<PessoaBO>(HttpStatus.NOT_FOUND);
		}

		pessoaDAO.deletePessoaById(id);
		return new ResponseEntity<PessoaBO>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/pessoa/", method = RequestMethod.DELETE)
	public ResponseEntity<PessoaBO> deleteAllPessoas() {
		System.out.println("Deletando todas as pessoas");

		pessoaDAO.deleteAll();
		return new ResponseEntity<PessoaBO>(HttpStatus.NO_CONTENT);
	}


}
