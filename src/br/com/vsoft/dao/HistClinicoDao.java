package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.util.ExceptionUtil;

public class HistClinicoDao {
	private String comandoCreate = "INSERT INTO HISTCLINICO " + "(ID)" + "VALUES (HISTCLINICO_SEQ.NEXTVAL )";
	private String comandoRecovery = "SELECT ID " + "FROM HISTCLINICO " + "WHERE ID = ?";
	 private String comandoUpdate = "UPDATE RACA "
             + "SET DESCRICAO = ?, "
             + "ID_ESPECIE = ? "	                   
             + "WHERE ID = ?";
	 private String comandoDelete = "DELETE FROM HISTCLINICO " + "WHERE ID = ?";
	private String comandoSearch = "SELECT ID " + "FROM HISTCLINICO";

	public HistClinico create(HistClinico pHistClinico) {
		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

			// Executar o comando
			int tQtd = tComandoJdbc.executeUpdate();

			// Processar o resultado
			if (tQtd == 1) {
				// Copiando o parametro
				HistClinico tHistClinico = pHistClinico;

				// Recuperando o código gerado pelo banco de dados
				ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
				tRsChave.next();

				// Assinalar a chave primária gerada no objeto
				pHistClinico.setId(tRsChave.getInt(1));

				// Liberar os recursos
				tRsChave.close();
				tComandoJdbc.close();

				// Retornando o objeto inserido
				return tHistClinico;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Historico Clinico");
		}

		// Retorna null indicando algum erro de processamento
		return null;
	}

	public HistClinico recovery(int pId) {
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
				HistClinico tHistClinico = recuperarHistClinico(tResultSet);

				// Liberar os recursos
				tResultSet.close();
				tComandoJdbc.close();

				// Retornando o objeto inserido
				return tHistClinico;
			}
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do HistClinico");
		}

		// Retorna null indicando algum erro de processamento
		return null;
	}

	
	public HistClinico update(HistClinico pHistClinico)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setInt(i++, pHistClinico.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                HistClinico tHistClinico = pHistClinico;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tHistClinico;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
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
			ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do HistClinico");
		}

		// Retorna falso indicando algum erro de processamento
		return false;
	}

	public List<HistClinico> search() {
		List<HistClinico> tLista = new ArrayList<>();

		try {
			// Obter a conexão
			Connection tConexao = Conexao.getConexao();

			// Criar o comando
			PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

			// Executar o comando
			ResultSet tResultSet = tComandoJdbc.executeQuery();

			// Processar o resultado
			while (tResultSet.next()) {
				HistClinico tHistClinico = recuperarHistClinico(tResultSet);

				// Adicionar o o bjeto na lista
				tLista.add(tHistClinico);
			}

			// Liberar os recursos
			tResultSet.close();
			tComandoJdbc.close();
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do HistClinico");
		}

		// Retornando a lista de objetos
		return tLista;
	}

	private HistClinico recuperarHistClinico(ResultSet tResultSet) throws SQLException {
		HistClinico tHistClinico = new HistClinico();
		// ID, DATA_HistClinico, VALOR, ENDERECO, ID_PACIENTE, ID_HistClinico
		// Recuperando os dados do resultSet
		tHistClinico.setId(tResultSet.getInt("ID"));
		return tHistClinico;
	}
}