package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Porte;
import br.com.vsoft.util.ExceptionUtil;

public class PorteDao {
	
    private String comandoCreate   = "INSERT INTO PORTE "
            + "(ID, DESCRICAO)"
            + "VALUES (PORTE_SEQ.NEXTVAL, ?)";
    private String comandoRecovery = "SELECT ID, DESCRICAO "
            + "FROM PORTE "
            + "WHERE ID = ?";
    private String comandoUpdate   = "UPDATE PORTE "
            + "SET DESCRICAO = ?"
            + "WHERE ID = ?";
    private String comandoDelete   = "DELETE FROM PORTE "
            + "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, DESCRICAO "
            + "FROM PORTE";
    
    public Porte create(Porte pPorte)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pPorte.getDescricao());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Porte tPorte = pPorte;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pPorte.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tPorte;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Porte");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Porte recovery(int pId)
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
                Porte tPorte = recuperarPorte(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tPorte;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Porte update(Porte pPorte)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pPorte.getDescricao());
            tComandoJdbc.setInt(i++, pPorte.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Porte tPorte = pPorte;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tPorte;
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

    public List<Porte> search()
    {
        List<Porte> tLista = new ArrayList<>();

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
                Porte tPorte = recuperarPorte(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tPorte);
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

    private Porte recuperarPorte(ResultSet tResultSet) throws SQLException
    {
        Porte tPorte = new Porte();

        // Recuperando os dados do resultSet
        tPorte.setId(tResultSet.getInt("ID"));
        tPorte.setDescricao(tResultSet.getString("DESCRICAO"));
        return tPorte;
    }
}

