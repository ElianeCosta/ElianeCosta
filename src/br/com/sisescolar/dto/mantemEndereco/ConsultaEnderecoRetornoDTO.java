package br.com.sisescolar.dto.mantemEndereco;

import java.io.Serializable;

public class ConsultaEnderecoRetornoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5928112714034862015L;

	private Long idAluno;
	private Integer idCidade;
	private String nomeCidade;
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
	 * @param IdAluno
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
	 * @param l the idCidade to set
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

	/**
	 * @param nomeCIdade the nomeCIdade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

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
	}

	public Long getCep() {

		return cep;
	}

	public void setCep(Long cep) {

		this.cep = cep;

	}

}
