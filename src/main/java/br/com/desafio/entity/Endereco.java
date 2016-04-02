package br.com.desafio.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tb_endereco database table.
 *
 */
@Entity
@Table(name = "tb_endereco")
@NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 2061693001925411597L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String bairro;

	private int cep;

	private String cidade;

	private String complemento;

	private String endereco;

	private String estado;

	private int numero;

	// bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa tbPessoa;

	public Endereco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return this.cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa getTbPessoa() {
		return this.tbPessoa;
	}

	public void setTbPessoa(Pessoa tbPessoa) {
		this.tbPessoa = tbPessoa;
	}

}