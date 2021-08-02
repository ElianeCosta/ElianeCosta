/**
 * 
 */
package br.com.sisescolar.dto.mantemaluno;

import java.io.Serializable;

/**
 * @author Família
 *
 */
public class ConsultaAlunoRetornoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7472886800705256123L;

	private Long idAluno;
	private String cpf;
	private String nome;
	private String sexo;

	/**
	 * @return the idAluno
	 */
	public Long getIdAluno() {
		return idAluno;
	}

	/**
	 * @param idAluno the idAluno to set
	 */
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
