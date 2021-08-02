package br.com.sisescolar.dto.mantemEndereco;

import java.io.Serializable;

public class ObtemDadosEnderecoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7913740110096826257L;

	private Long idAluno;
	private Integer idCidade;
	// private String nomeCidade;
	private String complemento;
	private String rua;
	private Long cep;

	/**
	 * @return the idaluno
	 */
	public Long getIdAluno() {
		return idAluno;
	}

	/**
	 * @param idaluno the idaluno to set
	 */
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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
	 * @return the nomeCidade
	 */
	/*
	 * public String getNomeCidade() { return nomeCidade; }
	 */

	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	/*
	 * public void setNomeCidade(String nomeCidade) { this.nomeCidade = nomeCidade;
	 * }
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

	public void setRua(String rua) {
		this.rua = rua;

		/**
		 * @return the nomeCIdade
		 */

	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;

		/**
		 * @return the nomeCIdade
		 */

	}

}

/**
 * @return the nomeCIdade
 */
