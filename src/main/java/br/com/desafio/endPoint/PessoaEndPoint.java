package br.com.desafio.endPoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
