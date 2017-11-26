package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Cidade;
import br.com.vsoft.util.ExceptionUtil;

public class CidadeDao {
	    private String comandoCreate   = "INSERT INTO CIDADE "
	                    			   + "(ID, NOME, ID_ESTADO) "
	                    			   + "VALUES (CIDADE_SEQ.NEXTVAL, ?, ?)";
	    private String comandoRecovery = "SELECT ID, NOME, ID_ESTADO "
	                    			   + "FROM CIDADE "
	                    			   + "WHERE ID = ?";
	    private String comandoUpdate = "UPDATE CIDADE "
	    							 + "SET NOME = ?, "
	    							 + "ID_ESTADO = ? "	                   
	    							 + "WHERE ID = ?";
	    private String comandoDelete   = "DELETE FROM CIDADE "
	                    			   + "WHERE ID = ?";
	    private String comandoSearch   = "SELECT ID, NOME, ID_ESTADO "
	                    			   + "FROM CIDADE";

	    public Cidade create(Cidade pCidade)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setString(i++, pCidade.getNome());
	            tComandoJdbc.setInt(i++, pCidade.getIdEstado());
	
	            
	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Cidade tCidade = pCidade;

	                // Recuperando o código gerado pelo banco de dados
	                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
	                tRsChave.next();

	                // Assinalar a chave primária gerada no objeto
	                pCidade.setId(tRsChave.getInt(1));

	                // Liberar os recursos
	                tRsChave.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tCidade;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação da Cidade");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Cidade recovery(int pId)
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
	                Cidade tCidade = recuperarCidade(tResultSet);

	                // Liberar os recursos
	                tResultSet.close();
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tCidade;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Cidade");
	        }

	        // Retorna null indicando algum erro de processamento
	        return null;
	    }

	    public Cidade update(Cidade pCidade)
	    {
	        try
	        {
	            // Obter a conexão
	            Connection tConexao = Conexao.getConexao();

	            // Criar o comando
	            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

	            // Preencher o comando
	            int i = 1;
	            tComandoJdbc.setString(i++, pCidade.getNome());	            
	            tComandoJdbc.setInt(i++, pCidade.getIdEstado());
	            tComandoJdbc.setInt(i++, pCidade.getId());

	            // Executar o comando
	            int tQtd = tComandoJdbc.executeUpdate();

	            // Processar o resultado
	            if (tQtd == 1)
	            {
	                // Copiando o parametro
	                Cidade tCidade = pCidade;

	                // Liberar os recursos
	                tComandoJdbc.close();

	                // Retornando o objeto inserido
	                return tCidade;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Cidade");
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
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Cidade");
	        }

	        // Retorna falso indicando algum erro de processamento
	        return false;
	    }

	    public List<Cidade> search()
	    {
	        List<Cidade> tLista = new ArrayList<>();

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
	                Cidade tCidade = recuperarCidade(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tCidade);
	            }

	            // Liberar os recursos
	            tResultSet.close();
	            tComandoJdbc.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Cidade");
	        }

	        // Retornando a lista de objetos
	        return tLista;
	    }

	    private Cidade recuperarCidade(ResultSet tResultSet) throws SQLException
	    {
	        Cidade tCidade = new Cidade();
	        // Recuperando os dados do resultSet
	        tCidade.setId(tResultSet.getInt("ID"));
	        tCidade.setNome(tResultSet.getString("NOME"));
	        tCidade.setIdEstado(tResultSet.getInt("ID_ESTADO"));
	        return tCidade;
	    }
	}

