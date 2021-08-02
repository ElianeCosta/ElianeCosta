/**
 * 
 */
package br.com.sisescolar.negocio.servicos;

import java.util.List;


import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;

import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;

/**
 * @author Família
 *
 */
public interface MantemAlunoServico extends SisEscolarBaseServico {

	/**
	 * 
	 * @param filtro
	 * 
	 * @return
	 * 
	 * @throws SisEscolarNegocioException
	 */
	List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */
	void excluirAluno(Long idAluno) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */

	ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno);

	/**
	 * 
	 * @param ObtemDadosAlunoRetornoDTO itemParaSalva
	 * 
	 * @throws SisEscolarNegocioException
	 */
	void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param ObtemDadosAlunoRetornoDTO itemParaSalva
	 * 
	 * @throws SisEscolarNegocioException
	 */
	void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalvar) throws SisEscolarNegocioException;
	/**
	 * 
	 * @param ConsultaRetornoEnderecoDTO itemParaSalva
	 * 
	 * @throws SisEscolarNegocioException
	 * 
	 * 
	 */
}
