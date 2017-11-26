package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Sexo;
import br.com.vsoft.util.ExceptionUtil;

public class SexoDao {
	
    private String comandoCreate   = "INSERT INTO SEXO "
            + "(ID, DESCRICAO)"
            + "VALUES (SEXO_SEQ.NEXTVAL, ?)";
    private String comandoRecovery = "SELECT ID, DESCRICAO "
            + "FROM SEXO "
            + "WHERE ID = ?";
    private String comandoUpdate   = "UPDATE SEXO "
            + "SET DESCRICAO = ?"
            + "WHERE ID = ?";
    private String comandoDelete   = "DELETE FROM SEXO "
            + "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, DESCRICAO "
            + "FROM SEXO";
    
    public Sexo create(Sexo pSexo)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pSexo.getDescricao());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Sexo tSexo = pSexo;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pSexo.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tSexo;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Sexo");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Sexo recovery(int pId)
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
                Sexo tSexo = recuperarSexo(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tSexo;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Tipo de Exame");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Sexo update(Sexo pSexo)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pSexo.getDescricao());
            tComandoJdbc.setInt(i++, pSexo.getId());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Sexo tSexo = pSexo;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tSexo;
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

    public List<Sexo> search()
    {
        List<Sexo> tLista = new ArrayList<>();

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
                Sexo tSexo = recuperarSexo(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tSexo);
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

    private Sexo recuperarSexo(ResultSet tResultSet) throws SQLException
    {
        Sexo tSexo = new Sexo();

        // Recuperando os dados do resultSet
        tSexo.setId(tResultSet.getInt("ID"));
        tSexo.setDescricao(tResultSet.getString("DESCRICAO"));
        return tSexo;
    }
}

