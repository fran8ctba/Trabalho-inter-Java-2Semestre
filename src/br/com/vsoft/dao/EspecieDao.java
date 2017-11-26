package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Especie;
import br.com.vsoft.util.ExceptionUtil;

public class EspecieDao {
	
    private String comandoCreate   = "INSERT INTO ESPECIE "
            + "(ID, DESCRICAO)"
            + "VALUES (ESPECIE_SEQ.NEXTVAL, ?)";
    private String comandoRecovery = "SELECT ID, DESCRICAO "
            + "FROM ESPECIE "
            + "WHERE ID = ?";
    private String comandoUpdate   = "UPDATE ESPECIE "
            + "SET DESCRICAO = ?"
            + "WHERE ID = ?";
    private String comandoDelete   = "DELETE FROM ESPECIE "
            + "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, DESCRICAO "
            + "FROM ESPECIE";
    
    public Especie create(Especie pEspecie)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEspecie.getDescricao());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Especie tEspecie = pEspecie;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pEspecie.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEspecie;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Especie recovery(int pId)
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
                Especie tEspecie = recuperarEspecie(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEspecie;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Especie update(Especie pEspecie)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pEspecie.getDescricao());
            tComandoJdbc.setInt(i++, pEspecie.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Especie tEspecie = pEspecie;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tEspecie;
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

    public List<Especie> search()
    {
        List<Especie> tLista = new ArrayList<>();

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
                Especie tEspecie = recuperarEspecie(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tEspecie);
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

    private Especie recuperarEspecie(ResultSet tResultSet) throws SQLException
    {
        Especie tEspecie = new Especie();

        // Recuperando os dados do resultSet
        tEspecie.setId(tResultSet.getInt("ID"));
        tEspecie.setDescricao(tResultSet.getString("DESCRICAO"));
        return tEspecie;
    }
}

