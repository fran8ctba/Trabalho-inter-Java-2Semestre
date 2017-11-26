package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Estado;
import br.com.vsoft.util.ExceptionUtil;

public class EstadoDao {
	
    private String comandoCreate   = "INSERT INTO ESTADO "
            + "(ID, NOME)"
            + "VALUES (ESTADO_SEQ.NEXTVAL, ?)";
    private String comandoRecovery = "SELECT ID, NOME "
            + "FROM ESTADO "
            + "WHERE ID = ?";
    private String comandoUpdate   = "UPDATE ESTADO "
            + "SET NOME = ?"
            + "WHERE ID = ?";
    private String comandoDelete   = "DELETE FROM ESTADO "
            + "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, NOME "
            + "FROM ESTADO";
    
    public Estado create(Estado pEstado)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEstado.getNome());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Estado tEstado = pEstado;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pEstado.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEstado;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Estado");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Estado recovery(int pId)
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
                Estado tEstado = recuperarEstado(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEstado;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Estado update(Estado pEstado)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEstado.getNome());
            tComandoJdbc.setInt(i++, pEstado.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Estado tEstado = pEstado;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEstado;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Tipo de Exame");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Estado> search()
    {
        List<Estado> tLista = new ArrayList<>();

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
                Estado tEstado = recuperarEstado(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tEstado);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retornando a lista de objetos
        return tLista;
    }

    private Estado recuperarEstado(ResultSet tResultSet) throws SQLException
    {
        Estado tEstado = new Estado();

        // Recuperando os dados do resultSet
        tEstado.setId(tResultSet.getInt("ID"));
        tEstado.setNome(tResultSet.getString("NOME"));
        return tEstado;
    }
}

