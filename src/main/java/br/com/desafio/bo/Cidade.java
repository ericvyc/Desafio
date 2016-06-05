package br.com.desafio.bo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_cidade database table.
 * 
 */
@Entity
@Table(name="tb_cidade")
@NamedQuery(name="Cidade.findAll", query="SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado tbEstado;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="tbCidade")
	private List<Endereco> tbEnderecos;

	public Cidade() {
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

	public Estado getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(Estado tbEstado) {
		this.tbEstado = tbEstado;
	}

	public List<Endereco> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<Endereco> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}

	public Endereco addTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().add(tbEndereco);
		tbEndereco.setTbCidade(this);

		return tbEndereco;
	}

	public Endereco removeTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().remove(tbEndereco);
		tbEndereco.setTbCidade(null);

		return tbEndereco;
	}

}