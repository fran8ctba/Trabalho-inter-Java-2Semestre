package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Dono;
import br.com.vsoft.util.ExceptionUtil;


public class DonoDao
{
    private String comandoCreate   = "INSERT INTO DONO "
                    + "(ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE)"
                    + "VALUES (DONO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private String comandoRecovery = "SELECT ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE "
                    				+ "FROM DONO "
                    				+ "WHERE ID = ?";
    private String comandoRecoveryByCpf = "SELECT ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE "
                    + "FROM DONO "
                    + "WHERE CPF = ?";
    private String comandoUpdate   = "UPDATE DONO "
                    + "SET NOME= ?, " 
                    + "SEXO = ?, " 
                    + "DATA_NASCIMENTO = ?, "  
                    + "RG	= ?, " 
                    + "CPF = ?, "  
                    + "TELEFONE = ?, "  
                    + "CELULAR = ?, "  
                    + "EMAIL = ?, "  
                    + "SENHA = ?, "
                    + "OBSERVACAO = ?, "  
                    + "ENDERECO = ?, "  
                    + "BAIRRO = ?, "  
                    + "CEP = ?, "  
                    + "ID_CIDADE = ? "
                    + "WHERE ID = ?";
    private String comandoDelete   = "DELETE FROM DONO "
                    + "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE "
                    + "FROM DONO";
    private String comandoSearchByNome = "SELECT ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE "
            + "FROM DONO "
            + "WHERE UPPER(NOME) LIKE UPPER(?)";

    public Dono create(Dono pDono)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pDono.getNome());
            tComandoJdbc.setString(i++, pDono.getSexo());
            tComandoJdbc.setDate(i++, Date.valueOf(pDono.getDataNascimento()));
            tComandoJdbc.setLong(i++, pDono.getRg());
            tComandoJdbc.setLong(i++, pDono.getCpf());            
            tComandoJdbc.setLong(i++, pDono.getTelefone());
            tComandoJdbc.setLong(i++, pDono.getCelular());
            tComandoJdbc.setString(i++, pDono.getEmail());
            tComandoJdbc.setString(i++, pDono.getSenha());
            tComandoJdbc.setString(i++, pDono.getObservacao());
            tComandoJdbc.setString(i++, pDono.getEndereco());
            tComandoJdbc.setString(i++, pDono.getBairro());
            tComandoJdbc.setLong(i++, pDono.getCep());
            tComandoJdbc.setInt(i++, pDono.getIdCidade());

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Dono tDono = pDono;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pDono.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tDono;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Dono");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Dono recovery(int pId)
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
                Dono tDono = recuperarDono(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tDono;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Dono");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Dono recoveryByCpf(long pCpf)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoRecoveryByCpf);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setLong(i++, pCpf);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            if (tResultSet.next())
            {
                // Criando o objeto
                Dono tDono = recuperarDono(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tDono;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Dono");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Dono update(Dono pDono)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pDono.getNome());
            tComandoJdbc.setString(i++, pDono.getSexo());
            tComandoJdbc.setDate(i++, Date.valueOf(pDono.getDataNascimento()));
            tComandoJdbc.setLong(i++, pDono.getRg());
            tComandoJdbc.setLong(i++, pDono.getCpf());            
            tComandoJdbc.setLong(i++, pDono.getTelefone());
            tComandoJdbc.setLong(i++, pDono.getCelular());
            tComandoJdbc.setString(i++, pDono.getEmail());
            tComandoJdbc.setString(i++, pDono.getSenha());
            tComandoJdbc.setString(i++, pDono.getObservacao());
            tComandoJdbc.setString(i++, pDono.getEndereco());
            tComandoJdbc.setString(i++, pDono.getBairro());
            tComandoJdbc.setLong(i++, pDono.getCep());
            tComandoJdbc.setInt(i++, pDono.getIdCidade());
            tComandoJdbc.setInt(i++, pDono.getId());
             

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Dono tDono = pDono;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tDono;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Dono");
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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Dono");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }

    public List<Dono> search()
    {
        List<Dono> tLista = new ArrayList<>();

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
                Dono tDono = recuperarDono(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tDono);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa dos Donos");
        }

        // Retornando a lista de objetos
        return tLista;
    }
    
    
    public List<Dono> searchByNome(String pNome)
    {
        if (pNome == null || pNome.isEmpty())
            return search();

        List<Dono> tLista = new ArrayList<>();

        try
        {
            // Preparando o nome para pesquisa
            String tNome = "%" + pNome + "%";

            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoSearchByNome);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, tNome);

            // Executar o comando
            ResultSet tResultSet = tComandoJdbc.executeQuery();

            // Processar o resultado
            while (tResultSet.next())
            {
                Dono tDono = recuperarDono(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tDono);
            }

            // Liberar os recursos
            tResultSet.close();
            tComandoJdbc.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na pesquisa dos donos");
        }

        // Retornando a lista de objetos
        return tLista;
    }


    private Dono recuperarDono(ResultSet tResultSet) throws SQLException
    {
        Dono tDono = new Dono();

        // Recuperando os dados do resultSet
        tDono.setId(tResultSet.getInt("ID"));
        tDono.setEmail(tResultSet.getString("EMAIL"));
        tDono.setSenha(tResultSet.getString("SENHA"));
        tDono.setNome(tResultSet.getString("NOME"));
        tDono.setSexo(tResultSet.getString("SEXO"));
        tDono.setRg(tResultSet.getLong("RG"));
        tDono.setCpf(tResultSet.getLong("CPF"));
        tDono.setDataNascimento(tResultSet.getDate("DATA_NASCIMENTO").toLocalDate());
        tDono.setTelefone(tResultSet.getLong("TELEFONE"));
        tDono.setCelular(tResultSet.getLong("CELULAR"));
        tDono.setObservacao(tResultSet.getString("OBSERVACAO"));
        tDono.setEndereco(tResultSet.getString("ENDERECO"));
        tDono.setBairro(tResultSet.getString("BAIRRO"));
        tDono.setCep(tResultSet.getLong("CEP"));
        tDono.setIdCidade(tResultSet.getInt("ID_CIDADE"));
        return tDono;
    }
}
