package br.com.desafio.bo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_estado database table.
 * 
 */
@Entity
@Table(name="tb_estado")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	private String sigla;

	//bi-directional many-to-one association to Cidade
	@OneToMany(mappedBy="tbEstado")
	private List<Cidade> tbCidades;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="tbEstado")
	private List<Endereco> tbEnderecos;

	public Estado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getTbCidades() {
		return this.tbCidades;
	}

	public void setTbCidades(List<Cidade> tbCidades) {
		this.tbCidades = tbCidades;
	}

	public Cidade addTbCidade(Cidade tbCidade) {
		getTbCidades().add(tbCidade);
		tbCidade.setTbEstado(this);

		return tbCidade;
	}

	public Cidade removeTbCidade(Cidade tbCidade) {
		getTbCidades().remove(tbCidade);
		tbCidade.setTbEstado(null);

		return tbCidade;
	}

	public List<Endereco> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<Endereco> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}

	public Endereco addTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().add(tbEndereco);
		tbEndereco.setTbEstado(this);

		return tbEndereco;
	}

	public Endereco removeTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().remove(tbEndereco);
		tbEndereco.setTbEstado(null);

		return tbEndereco;
	}

}