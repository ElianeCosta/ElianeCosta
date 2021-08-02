package br.com.sisescolar.dto.mantemaluno;

import java.io.Serializable;

public class ObtemDadosAlunoRetornoDTO extends ConsultaAlunoRetornoDTO implements Serializable {

	private static final long serialVersionUID = 2836582797725558363L;
	
	private Integer idadeAluno;

	/**
	 * @return the idadeAluno
	 */
	public Integer getIdadeAluno() {
		return idadeAluno;
	}

	/**
	 * @param idadeAluno the idadeAluno to set
	 */
	public void setIdadeAluno(Integer idadeAluno) {
		this.idadeAluno = idadeAluno;
	}

	
	}

	
	

