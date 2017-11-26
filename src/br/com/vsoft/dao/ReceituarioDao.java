package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Receituario;
import br.com.vsoft.util.ExceptionUtil;

public class ReceituarioDao {
	private String comandoCreate = "INSERT INTO RECEITUARIO "
			+ "(ID, DATA, UNMEDIDA, PESO, RECEITATEXTO,ID_HISTCLINICO)"
			+ "VALUES (RECEITUARIO_SEQ.NEXTVAL, ?, ?, ?, ?,?)";
	private String comandoRecovery = "SELECT ID, DATA, UNMEDIDA, PESO,RECEITATEXTO,ID_HISTCLINICO "
			+ "FROM RECEITUARIO " + "WHERE ID = ?";
	private String comandoUpdate = "UPDATE RECEITUARIO " + "SET DATA = ?, " + "UNMEDIDA = ?, " + "PESO = ?, "
			+ "RECEITATEXTO = ?, " + "ID_HISTCLINICO = ? " + "WHERE ID = ? ";
	private String comandoDelete = "DELETE FROM RECEITUARIO " + "WHERE ID = ? ";
	private String comandoSearch = "SELECT ID, DATA, UNMEDIDA, PESO,RECEITATEXTO,ID_HISTCLINICO " + "FROM RECEITUARIO ";
	private String comandoPesquisaPorHistorico = "SELECT * " + "FROM RECEITUARIO "
			+ "WHERE ID_HISTCLINICO IN (SELECT ID_HISTCLINICO " + "FROM ANIMAL " + "WHERE ID = ?)";

	public Receituario create(Receituario pReceituario) {
		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

			// Preencher o comando
			int i = 1;
			tComandoJdbc.setTimestamp(i++, new Timestamp(pReceituario.getData().getTime()));
			tComandoJdbc.setString(i++, pReceituario.getUnMedida());
			tComandoJdbc.setBigDecimal(i++, pReceituario.getPeso());
			tComandoJdbc.setInt(i++, pReceituario.getIdHistClinico());
			tComandoJdbc.setString(i++, pReceituario.getReceitaTexto());

			// Executar o comando
			int tQtd = tComandoJdbc.executeUpdate();

			// Processar o resultado
			if (tQtd == 1) {
				// Copiando o parametro
				Receituario tReceituario = pReceituario;

				// Recuperando o código gerado pelo banco de dados
				ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
				tRsChave.next();

				// Assinalar a chave primária gerada no objeto
				pReceituario.setId(tRsChave.getInt(1));

				// Liberar os recursos
				tRsChave.close();
				tComandoJdbc.close();

				// Retornando o objeto inserido
				return tReceituario;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Receituario");
		}

		// Retorna null indicando algum erro de processamento
		return null;
	}

	public Receituario recovery(int pId) {
		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecovery);

			// Preencher o comando
			int i = 1;
			tComandoJdbc.setInt(i++, pId);

			// Executar o comando
			ResultSet tResultSet = tComandoJdbc.executeQuery();

			// Processar o resultado
			if (tResultSet.next()) {
				// Criando o objeto
				Receituario tReceituario = recuperarReceituario(tResultSet);

				// Liberar os recursos
				tResultSet.close();
				tComandoJdbc.close();

				// Retornando o objeto inserido
				return tReceituario;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Receituario");
		}

		// Retorna null indicando algum erro de processamento
		return null;
	}

	public Receituario update(Receituario pReceituario) {
		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

			// Preencher o comando
			int i = 1;
			tComandoJdbc.setTimestamp(i++, new Timestamp(pReceituario.getData().getTime()));
			tComandoJdbc.setString(i++, pReceituario.getUnMedida());
			tComandoJdbc.setBigDecimal(i++, pReceituario.getPeso());
			tComandoJdbc.setString(i++, pReceituario.getReceitaTexto());
			tComandoJdbc.setInt(i++, pReceituario.getIdHistClinico());
			tComandoJdbc.setInt(i++, pReceituario.getId());

			// Executar o comando
			int tQtd = tComandoJdbc.executeUpdate();

			// Processar o resultado
			if (tQtd == 1) {
				// Copiando o parametro
				Receituario tReceituario = pReceituario;

				// Liberar os recursos
				tComandoJdbc.close();

				// Retornando o objeto inserido
				return tReceituario;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Receituario");
		}

		// Retorna null indicando algum erro de processamento
		return null;
	}

	public boolean delete(int pId) {
		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoDelete);

			// Preencher o comando
			int i = 1;
			tComandoJdbc.setInt(i++, pId);

			// Executar o comando
			int tQtd = tComandoJdbc.executeUpdate();

			// Processar o resultado
			if (tQtd == 1) {
				// Liberar os recursos
				tComandoJdbc.close();

				// Retornando o indicativo de sucesso
				return true;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Receituario");
		}

		// Retorna falso indicando algum erro de processamento
		return false;
	}

	public List<Receituario> pesquisaPorHistorico(int pId) {
		List<Receituario> tLista = new ArrayList<>();

		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoPesquisaPorHistorico);

			// Preencher o comando
			int i = 1;
			tComandoJdbc.setInt(i++, pId);

			// Executar o comando
			ResultSet tResultSet = tComandoJdbc.executeQuery();

			// Processar o resultado
			while (tResultSet.next()) {
				Receituario tReceituario = recuperarReceituario(tResultSet);

				// Adicionar o o bjeto na lista
				tLista.add(tReceituario);
			}

			// Liberar os recursos
			tResultSet.close();
			tComandoJdbc.close();
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa dos Animais");
		}

		// Retornando a lista de objetos
		return tLista;
	}

	public List<Receituario> search() {
		List<Receituario> tLista = new ArrayList<>();

		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

			// Executar o comando
			ResultSet tResultSet = tComandoJdbc.executeQuery();

			// Processar o resultado
			while (tResultSet.next()) {
				Receituario tReceituario = recuperarReceituario(tResultSet);

				// Adicionar o o bjeto na lista
				tLista.add(tReceituario);
			}

			// Liberar os recursos
			tResultSet.close();
			tComandoJdbc.close();
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Receituario");
		}

		// Retornando a lista de objetos
		return tLista;
	}

	private Receituario recuperarReceituario(ResultSet tResultSet) throws SQLException {
		Receituario tReceituario = new Receituario();

		// Recuperando os dados do resultSet
		tReceituario.setId(tResultSet.getInt("ID"));
		tReceituario.setData(new java.util.Date(tResultSet.getTimestamp("DATA").getTime()));
		tReceituario.setUnMedida(tResultSet.getString("UNMEDIDA"));
		tReceituario.setPeso(tResultSet.getBigDecimal("PESO"));
		tReceituario.setReceitaTexto(tResultSet.getString("RECEITATEXTO"));
		tReceituario.setIdHistClinico(tResultSet.getInt("ID_HISTCLINICO"));
		return tReceituario;
	}
}
