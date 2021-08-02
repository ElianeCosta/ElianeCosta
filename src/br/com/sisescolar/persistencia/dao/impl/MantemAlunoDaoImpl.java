package br.com.sisescolar.persistencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang.StringUtils;

import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoFiltroDTO;
import br.com.sisescolar.dto.mantemaluno.ConsultaAlunoRetornoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.persistencia.SisEscolarBaseDaoImpl;
import br.com.sisescolar.persistencia.dao.MantemAlunoDao;

public class MantemAlunoDaoImpl extends SisEscolarBaseDaoImpl implements MantemAlunoDao {

	/** Campos de tabelas **/
	private static final String ID_ALUNO = "IdAluno";
	private static final String CPF = "cpf";
	private static final String NOME = "Nome";
	private static final String SEXO = "sexo";
	private static final String IDADE = "Idade";

	/**
	 *
	 *
	 */
	public List<ConsultaAlunoRetornoDTO> consultarAlunos(ConsultaAlunoFiltroDTO filtro) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		ResultSet resultSet = null;

		try {

			List<ConsultaAlunoRetornoDTO> itensRetorno = new ArrayList<ConsultaAlunoRetornoDTO>(0);

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM alunosisescolar.aluno WHERE 1 = 1");

			if (StringUtils.isNotBlank(filtro.getCpf())) {

				sql.append(" AND cpf = ");
				sql.append(filtro.getCpf());
			}

			if (StringUtils.isNotBlank(filtro.getNome())) {

				sql.append(" AND Nome LIKE ");
				sql.append("'%");
				sql.append(filtro.getNome());
				sql.append("%'");
			}

			ps = conexao.prepareStatement(sql.toString());

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				ConsultaAlunoRetornoDTO itemRetorno = new ConsultaAlunoRetornoDTO();
				itemRetorno.setIdAluno(resultSet.getLong(ID_ALUNO));
				itemRetorno.setCpf(resultSet.getString(CPF));
				itemRetorno.setNome(resultSet.getString(NOME));
				itemRetorno.setSexo(resultSet.getString(SEXO));

				itensRetorno.add(itemRetorno);
			}

			return itensRetorno;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao consultar alunos!");
		} finally {
			this.fecharResultSet(resultSet);

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 *
*/
	public ObtemDadosAlunoRetornoDTO obterDadosAluno(Long idAluno) {
		// criar conexao
		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		ResultSet resultSet = null;

		try {

			ObtemDadosAlunoRetornoDTO itemRetorno = null;

			String sql = "SELECT * FROM alunosisescolar.aluno WHERE IdAluno = ?";

			ps = conexao.prepareStatement(sql.toString());
			ps.setLong(1, idAluno);

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				itemRetorno = new ObtemDadosAlunoRetornoDTO();
				itemRetorno.setIdAluno(resultSet.getLong(ID_ALUNO));
				itemRetorno.setCpf(resultSet.getString(CPF));
				itemRetorno.setNome(resultSet.getString(NOME));
				itemRetorno.setSexo(resultSet.getString(SEXO));
				itemRetorno.setIdadeAluno(resultSet.getInt(IDADE));
			}

			return itemRetorno;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao consultar dados alunos!");
		} finally {
			this.fecharResultSet(resultSet);

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 *
*/
	public void excluirAluno(Long idAluno) {

		Connection conexao = ConnectionFactory.createConnection();
		PreparedStatement ps = null;

		try {

			String sql = "DELETE FROM alunosisescolar.aluno WHERE idAluno = ?";

			ps = conexao.prepareStatement(sql.toString());
			ps.setLong(1, idAluno);

			ps.executeUpdate();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao excluir alunos!");
		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	public void alterarAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) {

		// criar conexao
		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		try {

			String sql = "Update alunosisescolar.aluno SET Cpf = ?, Nome = ?, Sexo = ?, Idade = ? WHERE IdAluno = ?";

			ps = conexao.prepareStatement(sql.toString());
			// se refere aos campos a serem atualizados
			ps.setString(1, itemParaSalva.getCpf());
			ps.setString(2, itemParaSalva.getNome());
			ps.setString(3, itemParaSalva.getSexo());
			ps.setLong(4, itemParaSalva.getIdadeAluno());
			ps.setLong(5, itemParaSalva.getIdAluno());

			ps.executeUpdate();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao atualizar dados do alunos!");
		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 *
	 */
	public void incluirAluno(ObtemDadosAlunoRetornoDTO itemParaSalva) {
		Connection conexao = ConnectionFactory.createConnection();
		PreparedStatement ps = null;

		try {

			String sql = "INSERT INTO alunosisescolar.aluno(cpf, Nome, sexo, Idade) VALUES (?,?,?,?)";

			ps = conexao.prepareStatement(sql.toString());

			// se refere aos campos a serem atualizados.

			ps.setString(1, itemParaSalva.getCpf());
			ps.setString(2, itemParaSalva.getNome());
			ps.setString(3, itemParaSalva.getSexo());
			ps.setLong(4, itemParaSalva.getIdadeAluno());

			ps.executeUpdate();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao inserir  dados do alunos!");
		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

}
	