package br.com.desafio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the tb_pessoa database table.
 *
 */
@Entity
@Table(name = "tb_pessoa")
@NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int cpf;

	@Column(name = "DT_NASC")
	private String dtNasc;

	private String sexo;

	// bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy = "tbPessoa")
	private List<Endereco> tbEnderecos;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return this.cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return this.dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Endereco> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<Endereco> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}

	public Endereco addTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().add(tbEndereco);
		tbEndereco.setTbPessoa(this);

		return tbEndereco;
	}

	public Endereco removeTbEndereco(Endereco tbEndereco) {
		getTbEnderecos().remove(tbEndereco);
		tbEndereco.setTbPessoa(null);

		return tbEndereco;
	}

}