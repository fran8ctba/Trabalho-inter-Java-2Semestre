package br.com.vsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import br.com.vsoft.jdbc.Conexao;
import br.com.vsoft.model.Diagnostico;
import br.com.vsoft.util.ExceptionUtil;

public class DiagnosticoDao {
	
	private String comandoCreate   = "INSERT INTO DIAGNOSTICO "
	        + "(ID, DATA, UNMEDIDA, PESO,DIAGNOSTICOTEXTO,ID_HISTCLINICO )"
	        + "VALUES (DIAGNOSTICO_SEQ.NEXTVAL, ?, ?, ?, ?,?)";
	private String comandoRecovery = "SELECT ID, DATA, UNMEDIDA, PESO, DIAGNOSTICOTEXTO,ID_HISTCLINICO "
	        + "FROM DIAGNOSTICO "
	        + "WHERE ID = ?";
	private String comandoUpdate = "UPDATE DIAGNOSTICO "
	        + "SET DATA = ?, "
	        + "UNMEDIDA = ?, "
	        + "PESO = ?, "
	        + "DIAGNOSTICOTEXTO = ?, "
	        + "ID_HISTCLINICO = ? "
	        + "WHERE ID = ? ";
	private String comandoDelete   = "DELETE FROM DIAGNOSTICO "
	        + "WHERE ID = ?";
	private String comandoSearch   = "SELECT ID, DATA, UNMEDIDA, PESO,DIAGNOSTICOTEXTO,ID_HISTCLINICO "
	        + "FROM DIAGNOSTICO";
	private String comandoPesquisaPorHistorico   = "SELECT * "
			+ "FROM DIAGNOSTICO " 
			+ "WHERE ID_HISTCLINICO IN (SELECT ID_HISTCLINICO " 
	        				+ "FROM ANIMAL " 
	        				+ "WHERE ID = ?)";
 

	
	public Diagnostico create(Diagnostico pDiagnostico)

	{
		try
		{
		    // Obter a conexão
		    Connection tConexao = Conexao.getConexao();
		
		    // Criar o comando
		    PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoCreate, new String[] { "ID" });
		
		    // Preencher o comando
		    int i = 1;
		    tComandoJdbc.setTimestamp(i++, new Timestamp(pDiagnostico.getData().getTime()));
		    tComandoJdbc.setString(i++, pDiagnostico.getUnMedida());
		    tComandoJdbc.setBigDecimal(i++, pDiagnostico.getPeso());
		    tComandoJdbc.setString(i++, pDiagnostico.getDiagnosticoTexto());
		    tComandoJdbc.setInt(i++, pDiagnostico.getIdHistClinico());
		    // Executar o comando
		    int tQtd = tComandoJdbc.executeUpdate();
		
		    // Processar o resultado
		    if (tQtd == 1)
		    {
		        // Copiando o parametro
		        Diagnostico tDiagnostico = pDiagnostico;
		
		        // Recuperando o código gerado pelo banco de dados
		        ResultSet tRsChave = tComandoJdbc.getGeneratedKeys();
		        tRsChave.next();
		
		        // Assinalar a chave primária gerada no objeto
		        pDiagnostico.setId(tRsChave.getInt(1));
		
		        // Liberar os recursos
		        tRsChave.close();
		        tComandoJdbc.close();
		
		        // Retornando o objeto inserido
		        return tDiagnostico;
		    }
		}
		
		catch (SQLException tExcept)
		
		{
		    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Diagnostico");
		}
		
		// Retorna null indicando algum erro de processamento
		
		return null;		
	}
		
	
	public Diagnostico recovery(int pId)
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
		        Diagnostico tDiagnostico = recuperarDiagnostico(tResultSet);
		
		        // Liberar os recursos
		        tResultSet.close();
		        tComandoJdbc.close();
		
		        // Retornando o objeto inserido
		        return tDiagnostico;
		    }
		}


			catch (SQLException tExcept)
		{    
			ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Diagnostico");
		}

		// Retorna null indicando algum erro de processamento
		return null;
		}
		
		public Diagnostico update(Diagnostico pDiagnostico)
		
		{
			try
			{
		    
				// Obter a conexão
		    
				Connection tConexao = Conexao.getConexao();
		
		   
				// Criar o comando
		    
				PreparedStatement tComandoJdbc = tConexao.prepareStatement(comandoUpdate);
		
		
				// Preencher o comando
		    
				int i = 1;
		    
				tComandoJdbc.setTimestamp(i++, new Timestamp(pDiagnostico.getData().getTime()));
		    
				tComandoJdbc.setString(i++, pDiagnostico.getUnMedida());
		    
				tComandoJdbc.setBigDecimal(i++, pDiagnostico.getPeso());
		    
				tComandoJdbc.setString(i++, pDiagnostico.getDiagnosticoTexto());
		    
				tComandoJdbc.setInt(i++, pDiagnostico.getIdHistClinico());
		
				tComandoJdbc.setInt(i++, pDiagnostico.getId());

				// Executar o comando
	
				int tQtd = tComandoJdbc.executeUpdate();
		
		    
				// Processar o resultado
		    
				if (tQtd == 1)
		   
				{
		        // Copiando o parametro
		        Diagnostico tDiagnostico = pDiagnostico;
		
		        // Liberar os recursos
		        tComandoJdbc.close();
		
		        // Retornando o objeto inserido
		        return tDiagnostico;		    
				}		
			}		
			catch (SQLException tExcept)		
			{
		    ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Diagnostico");
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
		    ExceptionUtil.mostrarErro(tExcept, "Problemas na remoção do Diagnostico");
		}
		
		// Retorna falso indicando algum erro de processamento
		return false;
		}
		
		
		
	    public List<Diagnostico> pesquisaPorHistorico(int pId)
	    {
	        List<Diagnostico> tLista = new ArrayList<>();

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
	            	Diagnostico tDiagnostico = recuperarDiagnostico(tResultSet);

	                // Adicionar o o bjeto na lista
	                tLista.add(tDiagnostico);
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
	    
		public List<Diagnostico> search()
		
		{
		
			List<Diagnostico> tLista = new ArrayList<>();
		
		
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
		        

					Diagnostico tDiagnostico = recuperarDiagnostico(tResultSet);
		

					// Adicionar o o bjeto na lista
	
					tLista.add(tDiagnostico);
		    
				}
		
		    
				// Liberar os recursos
		   
				tResultSet.close();
		    
				tComandoJdbc.close();
		
		
			}
		
			catch (SQLException tExcept)
		
			{
		    
				ExceptionUtil.mostrarErro(tExcept, "Problemas na criação do Diagnostico");
		
			}
		
		
			// Retornando a lista de objetos
		
			return tLista;
	

		}
		private Diagnostico recuperarDiagnostico(ResultSet tResultSet) throws SQLException
		
		{
			Diagnostico tDiagnostico = new Diagnostico();
			// Recuperando os dados do resultSet		
			tDiagnostico.setId(tResultSet.getInt("ID"));
			tDiagnostico.setData(new java.util.Date(tResultSet.getTimestamp("DATA").getTime()));		
			tDiagnostico.setUnMedida(tResultSet.getString("UNMEDIDA"));	
			tDiagnostico.setPeso(tResultSet.getBigDecimal("PESO"));		
			tDiagnostico.setDiagnosticoTexto(tResultSet.getString("DIAGNOSTICOTEXTO"));		
			tDiagnostico.setIdHistClinico(tResultSet.getInt("ID_HISTCLINICO"));
			return tDiagnostico;
			
		}
}


