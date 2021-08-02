package br.com.sisescolar.persistencia.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/**
	 * 
	 * @return
	 */
	public static Connection createConnection() {

		try {

			carregaDriver();

			String url = "jdbc:mysql://localhost:3306/alunosisescolar";
			String user = "root";
			String password = "";

			Connection conexao = DriverManager.getConnection(url, user, password);

			return conexao;
		} catch (SQLException e) {

			throw new RuntimeException("Erro ao conectar com o banco de dados!");
		}
	}

	private static void carregaDriver() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			throw new RuntimeException("Driver do banco de dados não encontrado!");
		}
	}
}
