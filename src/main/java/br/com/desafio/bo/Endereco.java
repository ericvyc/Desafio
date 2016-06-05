package br.com.desafio.bo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name="tb_endereco")
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String complemento;

	private String logradouro;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="id_cidade")
	private Cidade tbCidade;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado tbEstado;

	public Endereco() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cidade getTbCidade() {
		return this.tbCidade;
	}

	public void setTbCidade(Cidade tbCidade) {
		this.tbCidade = tbCidade;
	}

	public Estado getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(Estado tbEstado) {
		this.tbEstado = tbEstado;
	}

}