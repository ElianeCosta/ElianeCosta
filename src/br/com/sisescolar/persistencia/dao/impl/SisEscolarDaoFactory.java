/**
* 
*/
package br.com.sisescolar.persistencia.dao.impl;

import br.com.sisescolar.persistencia.dao.MantemAlunoDao;
import br.com.sisescolar.persistencia.dao.MantemEnderecoDao;

/**
 * @author Família
 *
 */
public final class SisEscolarDaoFactory {

	/** Instancia do DAOFactory. */
	private static SisEscolarDaoFactory factory = new SisEscolarDaoFactory();

	/**
	 * Retorna a fabrica de DAO's a ser utilizada.
	 * 
	 * @return a fabrica de DAO's a ser utilizada.
	 */
	public static SisEscolarDaoFactory getInstance() {
		return factory;
	}

	/**
	 * Construtor privado no-args da classe.
	 */
	private SisEscolarDaoFactory() {

	}

	/**
	 * Cria a MantemAlunoDao.
	 * 
	 * @return MantemAlunoDao
	 */
	public MantemAlunoDao criarMantemAlunoDao() {
		return new MantemAlunoDaoImpl();
	}

	/**
	 * Cria a MantemAlunoDao.
	 * 
	 * @return MantemAlunoDao
	 */
	public MantemEnderecoDao criarMantemEnderecoDao() {
		return new ManteEnderecoDAOImpl();
	}

}
