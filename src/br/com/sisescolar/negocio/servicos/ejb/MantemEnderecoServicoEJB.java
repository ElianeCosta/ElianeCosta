package br.com.sisescolar.negocio.servicos.ejb;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO;
import br.com.sisescolar.entidades.mantemaluno.Endereco;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;
import br.com.sisescolar.negocio.servicos.MantemEnderecoServicos;
import br.com.sisescolar.persistencia.dao.MantemEnderecoDao;
import br.com.sisescolar.persistencia.dao.impl.SisEscolarDaoFactory;

public class MantemEnderecoServicoEJB extends SisEscolarBaseServicoEJB implements MantemEnderecoServicos {
	/** Mensagems Negociais. **/
	private static final String MSG001 = "%s é um campo de preenchimento obrigatório!";

	/**
	 *
	 */
	public List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtro)
			throws SisEscolarNegocioException {

		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		return dao.consultarEndereco(filtro);
	}

	/**
	 *
	 */

	public ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno) throws SisEscolarNegocioException {

		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		return dao.obterDadosEndereco(idAluno);
	}

	/**
	 *
	 */
	public void excluirEndereco(Long idAluno) throws SisEscolarNegocioException {

		//MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		//dao.excluirEndereco(IdAluno);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emSisEscolar");
		
		EntityManager manager = factory.createEntityManager();
		
		Endereco endereco = manager.find(Endereco.class, idAluno);

	    manager.getTransaction().begin();
	    manager.remove(endereco);
	    manager.getTransaction().commit();
	}

	/**
	 *
	 */

	public void incluirEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws SisEscolarNegocioException {

		//MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		//dao.incluirEndereco(itemParaSalva);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emSisEscolar");
		
		EntityManager manager = factory.createEntityManager();
		
		Endereco endereco = new Endereco();
		endereco.setIdAluno(itemParaSalva.getIdAluno());
		endereco.setIdCidade(itemParaSalva.getIdCidade());
		endereco.setComplemento(itemParaSalva.getComplemento());
		endereco.setRua(itemParaSalva.getRua());
		endereco.setCep(itemParaSalva.getCep());

	    manager.getTransaction().begin();
	    manager.persist(endereco);
	    manager.getTransaction().commit();
	}

	/**
	 *
	 */
	public void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva) throws SisEscolarNegocioException {

		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		dao.alterarEndereco(itemParaSalva);

	}

	/**
	 *
	 */
	public List<ObtemDadosCidadeDTO> preencherCombox() throws SisEscolarNegocioException {

		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		return dao.preencherCombox();

	}

	/**
	 * @return
	 * @return
	 *
	 */
	@Override
	public void incluirCidade(ObtemDadosCidadeDTO itemSelecionado) throws SisEscolarNegocioException {

		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		dao.incluirCidade(itemSelecionado);
	}
	/**
	 * @return
	 * @return
	 *
	 */
	public void alterarCidade(ObtemDadosCidadeDTO itemSelecionado) throws SisEscolarNegocioException {
		
		MantemEnderecoDao dao = SisEscolarDaoFactory.getInstance().criarMantemEnderecoDao();

		dao.alterarCidade(itemSelecionado);
	}
}

