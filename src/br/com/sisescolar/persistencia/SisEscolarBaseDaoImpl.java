package br.com.sisescolar.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sisescolar.persistencia.dao.SisEscolarBaseDao;

public abstract class SisEscolarBaseDaoImpl implements SisEscolarBaseDao {
	
	/**	Campos de tabelas **/
	
	/**
	 * 
	 * @param resultSet
	 */
	protected void fecharResultSet(ResultSet resultSet) {

		try {

			resultSet.close();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao fechar o resultSet!");
		}
	}
	
	/**
	 * 
	 * @param fecharPreparedStatement
	 */
	protected void fecharPreparedStatement(PreparedStatement ps) {

		try {

			ps.close();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao fechar o fecharPreparedStatement!");
		}
	}	
}
