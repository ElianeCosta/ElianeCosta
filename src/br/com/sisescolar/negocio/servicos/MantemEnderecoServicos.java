package br.com.sisescolar.negocio.servicos;

import java.util.List;

import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;

public interface MantemEnderecoServicos {

	List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtro)
			throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */

	ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */

	void excluirEndereco(Long IdAluno) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */
	void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws SisEscolarNegocioException;

	/**
	 * 
	 * @param idAluno
	 * 
	 * @throws SisEscolarNegocioException
	 */
	 List<ObtemDadosCidadeDTO> preencherCombox()throws SisEscolarNegocioException; 
	 /**
		 * 
		 * @param idAluno
		 * 
		 * @throws SisEscolarNegocioException
		 */
	void incluirCidade(ObtemDadosCidadeDTO itemSelecionado) throws SisEscolarNegocioException ;

}