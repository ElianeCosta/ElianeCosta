package br.com.sisescolar.dto.mantemEndereco;

import java.io.Serializable;

public class ConsultaEnderecoFiltroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6669569742823909960L;
	
	private String IdAluno;
	private String IdCidade;
	private String NomeCidade;

	/**
	 * @return the idaluno
	 */
	public String getIdAluno() {
		return IdAluno;
	}

	/**
	 * @param idaluno the idaluno to set
	 */
	public void setIdAluno(String setIdAluno) {
		this.IdAluno = IdAluno;
	}

	/**
	 * @return the idCidade
	 */
	public String getIdCidade() {
		return IdCidade;
	}

	/**
	 * @param idCidade the idCidade to set
	 */
	public void setIdCidade(String idCidade) {
		this.IdCidade = idCidade;
	}

	/**
	 * @return the nomeCIdade
	 */
	public String getNomeCidade() {
		return NomeCidade;
	}

	/**
	 * @param nomeCIdade the nomeCIdade to set
	 */
	public void setNomeCidade(String NomeCidade) {
		this.NomeCidade = NomeCidade;
	}

	

	

}
