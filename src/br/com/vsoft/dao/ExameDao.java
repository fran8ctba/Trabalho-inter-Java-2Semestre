package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Exame;
import br.com.vsoft.util.ExceptionUtil;

public class ExameDao {
	    private String comandoCreate   = "INSERT INTO EXAME "
	                    + "(ID, DATA, DESCRICAO, ID_TIPOEXAME, ID_HISTCLINICO) "
	                    + "VALUES (EXAME_SEQ.NEXTVAL, ?, ?, ?, ?)";
	    private String comandoRecovery = "SELECT ID, DATA, DESCRICAO, ID_TIPOEXAME,ID_HISTCLINICO "
	                    + "FROM EXAME "
	                    + "WHERE ID = ?";
	    private String comandoUpdate = "UPDATE EXAME "
	                    + "SET DESCRICAO = ?,"
	                    + "DATA = ? "
	                    + "ID_TIPOEXAME = ?, "	                   
	                    + "ID_HISTCLINICO = ?, "
	                    + "WHERE ID = ?";
	    private String comandoDelete   = "DELETE FROM EXAME "
	                    + "WHERE ID = ?";
	    private String comandoSearch   = "SELECT ID, DATA, DESCRICAO, ID_TIPOEXAME, ID_HISTCLINICO "
	                    + "FROM EXAME";
		private String comandoPesquisaPorHistorico   = "SELECT * "
				+ "FROM EXAME " 
				+ "WHERE ID_HISTCLINICO IN (SELECT ID_HISTCLINICO " 
		        				+ "FROM ANIMAL " 
		        				+ "WHERE ID = ?)";
		
	    public Exame create(Exame pExame)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

	            // Preencher o comando
	            int i = 1;
	    	    tComandoJdbc.setTimestamp(i++, new Timestamp(pExame.getData().getTime()));
	    		 tComandoJdbc.setString(i++, pExame.getDescricao());
	            tComandoJdbc.setInt(i++, pExame.getIdTipoExame());
	            tComandoJdbc.setInt(i++, pExame.getIdHistClinico());
	 		   
	            
	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Exame tExame = pExame;

	                // Recuperando o código gerado pelo banco de dados
	                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
	                tRsChave.next();

	                // Assinalar a chave primária gerada no objeto
	                pExame.setId(tRsChave.getInt(1));

	                // Liberar os recursos
	                tRsChave.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tExame;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Exame");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Exame recovery(int pId)
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
	                Exame tExame = recuperarExame(tResultSet);

	                // Liberar os recursos
	                tResultSet.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tExame;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Exame");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Exame update(Exame pExame)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setTimestamp(i++, new Timestamp(pExame.getData().getTime()));
			    tComandoJdbc.setString(i++, pExame.getDescricao());	            
	            tComandoJdbc.setInt(i++, pExame.getIdTipoExame());
				tComandoJdbc.setInt(i++, pExame.getIdHistClinico());
				tComandoJdbc.setInt(i++, pExame.getId());

	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Exame tExame = pExame;

	                // Liberar os recursos
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tExame;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Exame");
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
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Exame");
	        }

	        // Retorna falso indicando algum erro de processamento
	        return false;
	    }
	    

	    public List<Exame> pesquisaPorHistorico(int pId)
	    {
	        List<Exame> tLista = new ArrayList<>();

	        try
	        {
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
	            while (tResultSet.next())
	            {
	            	Exame tExame = recuperarExame(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tExame);
	            }

	            // Liberar os recursos
	            tResultSet.close();
	            tComandoJdbc.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa dos Animais");
	        }

	        // Retornando a lista de objetos
	        return tLista;
	    }    
	    


	    public List<Exame> search()
	    {
	        List<Exame> tLista = new ArrayList<>();

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
	                Exame tExame = recuperarExame(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tExame);
	            }

	            // Liberar os recursos
	            tResultSet.close();
	            tComandoJdbc.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Exame");
	        }

	        // Retornando a lista de objetos
	        return tLista;
	    }

	    private Exame recuperarExame(ResultSet tResultSet) throws SQLException
	    {
	        Exame tExame = new Exame();
	        // Recuperando os dados do resultSet
	        tExame.setId(tResultSet.getInt("ID"));
	    	tExame.setData(new java.util.Date(tResultSet.getTimestamp("DATA").getTime()));		
		    tExame.setDescricao(tResultSet.getString("DESCRICAO"));
	        tExame.setIdTipoExame(tResultSet.getInt("ID_TIPOEXAME"));
	        tExame.setIdHistClinico(tResultSet.getInt("ID_HISTCLINICO"));
			  return tExame;
	    }
	}

