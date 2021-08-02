package br.com.sisescolar.persistencia.dao;

import java.util.List;

import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO;

public interface MantemEnderecoDao extends SisEscolarBaseDao {

	List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtro);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	void excluirEndereco(Long IdAluno);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	void incluirEndereco(ObtemDadosEnderecoDTO itemParaSalva);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	public void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	List<ObtemDadosCidadeDTO> preencherCombox();

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */

	void incluirCidade(ObtemDadosCidadeDTO itemSelecionado);

	/**
	 * 
	 * 
	 * @param filtro
	 * @return
	 */
	void alterarCidade(ObtemDadosCidadeDTO itemSelecionado);

}
