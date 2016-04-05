package br.com.desafio.endPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(value = "/pessoa/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody PessoaBO pessoa, UriComponentsBuilder ucBuilder) {
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

}
