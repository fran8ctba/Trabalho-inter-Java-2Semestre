package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Animal;
import br.com.vsoft.util.ExceptionUtil;


public class AnimalDao
{
	private String comandoCreate   = "INSERT INTO ANIMAL "
                    				+ "(ID, NOME, DATA_NASCIMENTO, IDADE, ANILHA, CONSUMO_RACAO, PELAGEM, PEDIGREE, ID_DONO, ID_HISTCLINICO, ID_SEXO, ID_RACA, ID_PORTE)"
                    				+ "VALUES (ANIMAL_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
    private String comandoRecovery = "SELECT ID, NOME, DATA_NASCIMENTO, IDADE, ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE, ID_DONO, ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE "
                    				+ "FROM ANIMAL "
                    				+ "WHERE ID = ?";
    private String comandoUpdate   = "UPDATE ANIMAL "
                    				+ "SET NOME =?, "
                    				+ "DATA_NASCIMENTO=?, "
                    				+ "IDADE=?, "
                    				+ "ANILHA=?, "
                    				+ "CONSUMO_RACAO=?, " 
                    				+ "PELAGEM=?, "
                    				+ "PEDIGREE=?, "
                    				+ "ID_DONO=?, "
                    				+ "ID_HISTCLINICO=?, "
                    				+ "ID_SEXO=?, "
                    				+ "ID_RACA=?, "
                    				+ "ID_PORTE=? " 
                    				+ "WHERE ID=? ";
    private String comandoDelete   = "DELETE FROM ANIMAL "
                    				+ "WHERE ID = ?";
    private String comandoSearch   = "SELECT ID, NOME, DATA_NASCIMENTO, IDADE, ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE, ID_DONO, ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE "
                    				+ "FROM ANIMAL";
	
    public Animal create(Animal pAnimal)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });

            // Preencher o comando
            int i = 1;
        	tComandoJdbc.setString(i++, pAnimal.getNome());
        	tComandoJdbc.setDate(i++, Date.valueOf(pAnimal.getDataNascimento()));
            tComandoJdbc.setInt(i++, pAnimal.getIdade());
            tComandoJdbc.setLong(i++, pAnimal.getAnilha());
            tComandoJdbc.setBigDecimal(i++, pAnimal.getConsumoRacao());
            tComandoJdbc.setString(i++, pAnimal.getPelagem());
            tComandoJdbc.setString(i++, pAnimal.getPedigee());
            tComandoJdbc.setInt(i++, pAnimal.getIdDono());
            tComandoJdbc.setInt(i++, pAnimal.getIdHistClinico());
            tComandoJdbc.setInt(i++, pAnimal.getIdSexo());
            tComandoJdbc.setInt(i++, pAnimal.getIdRaca());
            tComandoJdbc.setInt(i++, pAnimal.getIdPorte());
            
            
            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Animal tAnimal = pAnimal;

                // Recuperando o código gerado pelo banco de dados
                ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
                tRsChave.next();

                // Assinalar a chave primária gerada no objeto
                pAnimal.setId(tRsChave.getInt(1));

                // Liberar os recursos
                tRsChave.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAnimal;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Animal");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

    public Animal recovery(int pId)
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
                Animal tAnimal = recuperarAnimal(tResultSet);

                // Liberar os recursos
                tResultSet.close();
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAnimal;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Animal");
        }

        // Retorna null indicando algum erro de processamento
        return null;
    }

   
    public Animal update(Animal pAnimal)
    {
        try
        {
            // Obter a conexão
            Connection tConexao = Conexao.getConexao();

            // Criar o comando
            PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);

            // Preencher o comando
            int i = 1;
            tComandoJdbc.setString(i++, pAnimal.getNome());
        	tComandoJdbc.setDate(i++, Date.valueOf(pAnimal.getDataNascimento()));
            tComandoJdbc.setInt(i++, pAnimal.getIdade());
            tComandoJdbc.setLong(i++, pAnimal.getAnilha());
            tComandoJdbc.setBigDecimal(i++, pAnimal.getConsumoRacao());
            tComandoJdbc.setString(i++, pAnimal.getPelagem());
            tComandoJdbc.setString(i++, pAnimal.getPedigee());
            tComandoJdbc.setInt(i++, pAnimal.getIdDono());
            tComandoJdbc.setInt(i++, pAnimal.getIdHistClinico());
            tComandoJdbc.setInt(i++, pAnimal.getIdSexo());
            tComandoJdbc.setInt(i++, pAnimal.getIdRaca());
            tComandoJdbc.setInt(i++, pAnimal.getIdPorte());
            tComandoJdbc.setInt(i++, pAnimal.getId());
             

            // Executar o comando
            int tQtd = tComandoJdbc.executeUpdate();

            // Processar o resultado
            if (tQtd == 1)
            {
                // Copiando o parametro
                Animal tAnimal = pAnimal;

                // Liberar os recursos
                tComandoJdbc.close();

                // Retornando o objeto inserido
                return tAnimal;
            }
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Animal");
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
            ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Animal");
        }

        // Retorna falso indicando algum erro de processamento
        return false;
    }


    public List<Animal> search()
    {
        List<Animal> tLista = new ArrayList<>();

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
                Animal tAnimal = recuperarAnimal(tResultSet);

                // Adicionar o o bjeto na lista
                tLista.add(tAnimal);
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

    private Animal recuperarAnimal(ResultSet tResultSet) throws SQLException
    {
        Animal tAnimal = new Animal();

        // Recuperando os dados do resultSet

        //ID, NOME, IDADE, ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE, ID_DONO, ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE
        
        
        tAnimal.setId(tResultSet.getInt("ID"));
        tAnimal.setNome(tResultSet.getString("NOME"));
        tAnimal.setDataNascimento(tResultSet.getDate("DATA_NASCIMENTO").toLocalDate());
        tAnimal.setIdade(tResultSet.getInt("IDADE"));
        tAnimal.setAnilha(tResultSet.getLong("ANILHA"));
        tAnimal.setConsumoRacao(tResultSet.getBigDecimal("CONSUMO_RACAO"));
        tAnimal.setPelagem(tResultSet.getString("PELAGEM"));
        tAnimal.setPedigee(tResultSet.getString("PEDIGREE"));
        tAnimal.setIdDono(tResultSet.getInt("ID_DONO"));
        tAnimal.setIdHistClinico(tResultSet.getInt("ID_HISTCLINICO"));
        tAnimal.setIdSexo(tResultSet.getInt("ID_SEXO"));
        tAnimal.setIdRaca(tResultSet.getInt("ID_RACA"));
        tAnimal.setIdPorte(tResultSet.getInt("ID_PORTE"));
        
        return tAnimal;
    }
}
