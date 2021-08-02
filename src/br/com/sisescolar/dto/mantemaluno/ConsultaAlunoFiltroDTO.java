/**
 * 
 */
package br.com.sisescolar.dto.mantemaluno;

import java.io.Serializable;

/**
 * @author Família
 *
 */
public class ConsultaAlunoFiltroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5558523536685867258L;

	private String cpf;
	private String nome;

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
}
