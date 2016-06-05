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

import br.com.desafio.bo.Estado;
import br.com.desafio.dao.EstadoDAO;

@RestController
public class EnderecoResource {
	

	@Autowired
	EstadoDAO estadoDAO;

	@RequestMapping(value = "/estados/", method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> listarPessoas() {
		List<Estado> pessoas = estadoDAO.findAll();
		if (pessoas.isEmpty()) {
			return new ResponseEntity<List<Estado>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Estado>>(pessoas, HttpStatus.OK);
	}

	@RequestMapping(value = "/estado/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estado> getEstado(@PathVariable("id") long id) {
		System.out.println("Buscando estado com id " + id);
		Estado Estado = estadoDAO.findById(id);
		if (Estado == null) {
			System.out.println("Estado com id " + id + " não encontrado");
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Estado>(Estado, HttpStatus.OK);
	}

	@RequestMapping(value = "/estado/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPessoa(@RequestBody Estado estado, UriComponentsBuilder ucBuilder) {
		System.out.println("Criando pessoa " + estado.getNome());

		if (estadoDAO.estadoExiste(estado)) {
			System.out.println("Um estado com o nome " + estado.getNome() + " já existe");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		estadoDAO.saveEstado(estado);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/estado/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Estado> updateEstado(@PathVariable("id") long id, @RequestBody Estado estado) {
		System.out.println("Updating estado " + id);

		Estado esteEstado = estadoDAO.findById(id);

		if (esteEstado==null) {
			System.out.println("Estado com id " + id + " não encontrado");
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}

		esteEstado.setId(estado.getId());
		esteEstado.setNome(estado.getNome());
		esteEstado.setSigla(estado.getSigla());

		estadoDAO.updateEstado(esteEstado);
		return new ResponseEntity<Estado>(esteEstado, HttpStatus.OK);
	}

	@RequestMapping(value = "/estado/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Estado> deleteEstado(@PathVariable("id") long id) {
		System.out.println("Buscando e deletando estado com o id " + id);

		Estado estado = estadoDAO.findById(id);
		if (estado == null) {
			System.out.println("Não foi possivel deletar. Estado com id " + id + " não encontrado");
			return new ResponseEntity<Estado>(HttpStatus.NOT_FOUND);
		}

		estadoDAO.deleteEstadoById(id);
		return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/estado/", method = RequestMethod.DELETE)
	public ResponseEntity<Estado> deleteAllEstados() {
		System.out.println("Deletando todos os estados");

		estadoDAO.deleteAll();
		return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
	}



}
