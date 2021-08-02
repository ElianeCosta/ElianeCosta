/**
 * 
 */
package br.com.sisescolar.negocio.servicos.ejb;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.infraestrutura.exception.SisEscolarNegocioException;
import br.com.sisescolar.negocio.servicos.MantemAlunoServico;
import br.com.sisescolar.persistencia.dao.MantemAlunoDao;
import br.com.sisescolar.persistencia.dao.impl.SisEscolarDaoFactory;

/**
 * @author Família
 *
 */
// Acabei mechendo sem querer talvez de erro
public class MantemAlunoServicoEJB extends SisEscolarBaseServicoEJB implements MantemAlunoServico {

	/** Mensagems Negociais. **/
	private static final String MSG001 = "%s é um campo de preenchimento obrigatório!";

	/**
	 *
	 */
	public List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro)
			throws SisEscolarNegocioException {

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		return dao.consultarAlunos(filtro);
	}

	/**
	 *
	 */
	public void excluirAluno(Long idAluno) throws SisEscolarNegocioException {

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		dao.excluirAluno(idAluno);
	}

	/**
	 *
	 */

	public ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno) {

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		return dao.obterDadosAluno(idAluno);
	}

	/**
	 *
	 */
	public void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {
		
		this.validarFormulario(itemParaSalva);

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		dao.incluirAluno(itemParaSalva);
	}

	/**
	 * @throws SisEscolarNegocioException 
	 *
	 */
	public void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {

		this.validarFormulario(itemParaSalva);

		MantemAlunoDao dao = SisEscolarDaoFactory.getInstance().criarMantemAlunoDao();

		dao.alterarAluno(itemParaSalva);
	}
	
	private void validarFormulario(ObtemDadosAlunoRetornoDTO itemParaSalva) throws SisEscolarNegocioException {

		if (StringUtils.isBlank(itemParaSalva.getCpf())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "CPF"));
		}

		if (StringUtils.isBlank(itemParaSalva.getNome())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Nome"));
		}

		if (StringUtils.isBlank(itemParaSalva.getSexo())) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Sexo"));
		}

		if (itemParaSalva.getIdadeAluno() == null) {

			throw new SisEscolarNegocioException(String.format(MSG001, "Idade"));
		}
	}	

}
