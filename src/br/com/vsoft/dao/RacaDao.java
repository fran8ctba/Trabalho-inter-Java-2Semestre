package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Raca;
import br.com.vsoft.util.ExceptionUtil;

public class RacaDao {
	    private String comandoCreate   = "INSERT INTO RACA "
	                    + "(ID, DESCRICAO, ID_ESPECIE) "
	                    + "VALUES (RACA_SEQ.NEXTVAL, ?, ?)";
	    private String comandoRecovery = "SELECT ID, DESCRICAO, ID_ESPECIE "
	                    + "FROM RACA "
	                    + "WHERE ID = ?";
	    private String comandoUpdate = "UPDATE RACA "
	                    + "SET DESCRICAO = ?, "
	                    + "ID_ESPECIE = ? "	                   
	                    + "WHERE ID = ?";
	    private String comandoDelete   = "DELETE FROM RACA "
	                    + "WHERE ID = ?";
	    private String comandoSearch   = "SELECT ID, DESCRICAO, ID_ESPECIE "
	                    + "FROM RACA";

	    public Raca create(Raca pRaca)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setString(i++, pRaca.getDescricao());
	            tComandoJdbc.setInt(i++, pRaca.getIdEspecie());
	
	            
	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Raca tRaca = pRaca;

	                // Recuperando o código gerado pelo banco de dados
	                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
	                tRsChave.next();

	                // Assinalar a chave primária gerada no objeto
	                pRaca.setId(tRsChave.getInt(1));

	                // Liberar os recursos
	                tRsChave.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tRaca;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Raca");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Raca recovery(int pId)
	    {
	        try
	        {
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
	            if (tResultSet.next())
	            {
	                // Criando o objeto
	                Raca tRaca = recuperarRaca(tResultSet);

	                // Liberar os recursos
	                tResultSet.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tRaca;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Raca");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Raca update(Raca pRaca)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setString(i++, pRaca.getDescricao());	            
	            tComandoJdbc.setInt(i++, pRaca.getIdEspecie());
	            tComandoJdbc.setInt(i++, pRaca.getId());

	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Raca tRaca = pRaca;

	                // Liberar os recursos
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tRaca;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Raca");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public boolean delete(int pId)
	    {
	        try
	        {
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
	            if (tQtd == 1)
	            {
	                // Liberar os recursos
	                tComandoJdbc.close();

	                // Retornando o indicativo de sucesso
	                return true;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Raca");
	        }

	        // Retorna falso indicando algum erro de processamento
	        return false;
	    }

	    public List<Raca> search()
	    {
	        List<Raca> tLista = new ArrayList<>();

	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearch);

	            // Executar o comando
	            ResultSet tResultSet = tComandoJdbc.executeQuery();

	            // Processar o resultado
	            while (tResultSet.next())
	            {
	                Raca tRaca = recuperarRaca(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tRaca);
	            }

	            // Liberar os recursos
	            tResultSet.close();
	            tComandoJdbc.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Raca");
	        }

	        // Retornando a lista de objetos
	        return tLista;
	    }

	    private Raca recuperarRaca(ResultSet tResultSet) throws SQLException
	    {
	        Raca tRaca = new Raca();
	        // Recuperando os dados do resultSet
	        tRaca.setId(tResultSet.getInt("ID"));
	        tRaca.setDescricao(tResultSet.getString("DESCRICAO"));
	        tRaca.setIdEspecie(tResultSet.getInt("ID_ESPECIE"));
	        return tRaca;
	    }
	}

