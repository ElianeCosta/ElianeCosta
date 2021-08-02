package br.com.sisescolar.dto.mantemEndereco;

import java.io.Serializable;

public class ConsultaRetornoEnderecoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5928112714034862015L;
	private String idAluno;
	private Integer idCidade;
	private String nomeCidade;
	private String complemento;
	private String rua;
	private Integer cep;

	/**
	 * @return the idaluno
	 */
	public String getIdAluno() {
		return idAluno;
	}

	/**
	 * @param idaluno the idaluno to set
	 * @param IdAluno
	 */
	public void setIdAluno(String IdAluno) {
		this.idAluno = IdAluno;
	}

	/**
	 * @return the idCidade
	 */
	public Integer getIdCidade() {
		return idCidade;
	}

	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	/**
	 * @return the nomeCIdade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	/**
	 * @param nomeCIdade the nomeCIdade to set
	 */
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}

	public void setcep(String rua) {
		this.rua = rua;
	}

	public Integer getcep() {
		return cep;
	}

	public void setRua(Integer cep) {
		this.cep = cep;
	}

}
