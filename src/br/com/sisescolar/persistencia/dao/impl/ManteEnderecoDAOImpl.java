package br.com.sisescolar.persistencia.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoFiltroDTO;
import br.com.sisescolar.dto.mantemEndereco.ConsultaEnderecoRetornoDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosCidadeDTO;
import br.com.sisescolar.dto.mantemEndereco.ObtemDadosEnderecoDTO;
import br.com.sisescolar.dto.mantemaluno.ObtemDadosAlunoRetornoDTO;
import br.com.sisescolar.persistencia.SisEscolarBaseDaoImpl;
import br.com.sisescolar.persistencia.dao.MantemEnderecoDao;

public class ManteEnderecoDAOImpl extends SisEscolarBaseDaoImpl implements MantemEnderecoDao {

	/** Campos de tabelas **/
	private static final String ID_ALUNO = "IdAluno";
	private static final String ID_CIDADE = "IdCidade";
	private static final String NOMECIDADE = "NomeCidade";
	private static final String COMPLEMENTO = "Complemento";
	private static final String RUA = "rua";
	private static final String CEP = "cep";


	public List<ConsultaEnderecoRetornoDTO> consultarEndereco(ConsultaEnderecoFiltroDTO filtro) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		ResultSet resultSet = null;

		try {

			List<ConsultaEnderecoRetornoDTO> itensRetornoEndereco = new ArrayList<ConsultaEnderecoRetornoDTO>(0);

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT\r\n" 
			        + "  *\r\n"
					+ "FROM\r\n"
					+ "  alunosisescolar.endereco a\r\n"
					+ "  INNER JOIN alunosisescolar.cidade b\r\n"
					+ "  ON a.idcidade = b.idcidade\r\n" + "WHERE\r\n"
					+ "  1 = 1");

			if (StringUtils.isNotBlank(filtro.getNomeCidade())) {

				sql.append(" AND NomeCidade = ");
				sql.append(filtro.getNomeCidade());
			}

			ps = conexao.prepareStatement(sql.toString());

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				ConsultaEnderecoRetornoDTO itemRetornoEndereco = new ConsultaEnderecoRetornoDTO();
				itemRetornoEndereco.setIdAluno(resultSet.getLong(ID_ALUNO));
				itemRetornoEndereco.setIdCidade(resultSet.getInt(ID_CIDADE));
				itemRetornoEndereco.setNomeCidade(resultSet.getString(NOMECIDADE));
				itemRetornoEndereco.setComplemento(resultSet.getString(COMPLEMENTO));
				itemRetornoEndereco.setRua(resultSet.getString(RUA));
				itemRetornoEndereco.setCep(resultSet.getLong(CEP));

				itensRetornoEndereco.add(itemRetornoEndereco);
			}

			return itensRetornoEndereco;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao consultar  endereco");
		} finally {
			this.fecharResultSet(resultSet);

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 */
	@Override
	public ObtemDadosEnderecoDTO obterDadosEndereco(Long idAluno) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		ResultSet resultSet = null;

		try {
			ObtemDadosEnderecoDTO itemRetorno = null;

			String sql = "SELECT * FROM alunosisescolar.endereco WHERE idAluno = ?";

			ps = conexao.prepareStatement(sql.toString());
			ps.setLong(1, idAluno);

			resultSet = ps.executeQuery();

			if (resultSet.next()) {

				itemRetorno = new ObtemDadosEnderecoDTO();
				itemRetorno.setIdAluno(resultSet.getLong(ID_ALUNO));
				itemRetorno.setIdCidade(resultSet.getInt(ID_CIDADE));
				// itemRetorno.setNomeCidade(resultSet.getString(NOMECIDADE));
				itemRetorno.setComplemento(resultSet.getString(COMPLEMENTO));
				itemRetorno.setRua(resultSet.getString(RUA));
				itemRetorno.setCep(resultSet.getLong(CEP));
			}

			return itemRetorno;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao consultar enderecodo do aluno!");
		} finally {
			this.fecharResultSet(resultSet);

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
*/
	public void excluirEndereco(Long IdAluno) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;
		try {

			String sql = "DELETE FROM alunosisescolar.endereco WHERE  IdAluno = ?";

			ps = conexao.prepareStatement(sql.toString());
			ps.setLong(1, IdAluno);

			ps.executeUpdate();
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao excluir alunos!");
		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 
*/
	public void incluirEndereco(ObtemDadosEnderecoDTO itemParaSalva) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		try {

			String sql = "INSERT INTO alunosisescolar.endereco( Complemento, rua,cep,IdCidade) VALUES (?,?,?,?)";

			ps = conexao.prepareStatement(sql.toString());

			// se refere aos campos a serem atualizados.
			// ps.setString(1, itemParaSalva.getNomeCidade());
			ps.setString(1, itemParaSalva.getComplemento());
			ps.setString(2, itemParaSalva.getRua());
			ps.setLong(3, itemParaSalva.getCep());
			ps.setInt(4, itemParaSalva.getIdCidade());

			ps.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao inserir endereco!");

		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 */
	public void alterarEndereco(ObtemDadosEnderecoDTO itemParaSalva) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		try {

			String sql = "Update alunosisescolar.endereco SET Complemento = ?, rua = ?, cep = ?, IDCidade = ? WHERE IdAluno = ?";

			ps = conexao.prepareStatement(sql.toString());

			// se refere aos campos a serem atualizados.

			ps.setString(1, itemParaSalva.getComplemento());
			ps.setString(2, itemParaSalva.getRua());
			ps.setLong(3, itemParaSalva.getCep());
			ps.setInt(4, itemParaSalva.getIdCidade());
			ps.setLong(5, itemParaSalva.getIdAluno());

			ps.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao alterar  endereco!");

		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	 *
	 */
	public List<ObtemDadosCidadeDTO> preencherCombox() {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		ResultSet resultSet = null;

		try {

			List<ObtemDadosCidadeDTO> itensRetornoEndereco = new ArrayList<ObtemDadosCidadeDTO>(0);

			String sql = "SELECT * FROM alunosisescolar.cidade ORDER BY NomeCidade";

			ps = conexao.prepareStatement(sql.toString());

			resultSet = ps.executeQuery();

			while (resultSet.next()) {

				ObtemDadosCidadeDTO itemRetornoEndereco = new ObtemDadosCidadeDTO();

				itemRetornoEndereco.setIdCidade(resultSet.getInt(ID_CIDADE));
				itemRetornoEndereco.setNomeCidade(resultSet.getString(NOMECIDADE));

				itensRetornoEndereco.add(itemRetornoEndereco);

			}
			return itensRetornoEndereco;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao preencher combox");

		} finally {

			this.fecharResultSet(resultSet);

			this.fecharPreparedStatement(ps);
		}
	}

	@Override

	/**
	*
	*/
	public void incluirCidade(ObtemDadosCidadeDTO itemSelecionado) {

		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		try {

			String sql = "INSERT INTO alunosisescolar.cidade (NomeCidade) VALUES (?)";

			ps = conexao.prepareStatement(sql.toString());

			ps.setString(1, itemSelecionado.getNomeCidade());

			ps.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao inserir combox!");

		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

	/**
	*
	*/
	@Override
	public void alterarCidade(ObtemDadosCidadeDTO itemSelecionado) {
		
		Connection conexao = ConnectionFactory.createConnection();

		PreparedStatement ps = null;

		try {

			String sql = "Update alunosisescolar.cidade SET NomeCidade = ? WHERE IdCidade = ? ";

			ps = conexao.prepareStatement(sql.toString());
		    ps.setString(1, itemSelecionado.getNomeCidade());
			ps.setLong(2, itemSelecionado.getIdCidade());
		

			ps.executeUpdate();

		} catch (SQLException e) {

			throw new RuntimeException("Erro ao alterar combox!");

		} finally {

			this.fecharPreparedStatement(ps);
		}
	}

}
	