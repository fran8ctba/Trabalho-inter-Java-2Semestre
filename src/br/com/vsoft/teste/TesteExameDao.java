package br.com.vsoft.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.vsoft.dao.ExameDao;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dao.TipoExameDao;
import br.com.vsoft.model.Exame;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.model.TipoExame;


public class TesteExameDao {


    private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] pArgs) throws ParseException
    {	
    	//
    	//Pre Teste
    	//

		// Criar um HistClinico
		HistClinico tHistClinicoA = new HistClinico(0);
		HistClinico tHistClinicoB = new HistClinico(0);

		// Criando o objeto de persistência
		HistClinicoDao tDaoHistClinico = new HistClinicoDao();

		// Incluir o HistClinico
		System.out.println();
		System.out.println("Incluindo Historico Clinico");
		HistClinico tHistClinico2a = tDaoHistClinico.create(tHistClinicoA);
		if (tHistClinico2a != null)
			System.out.println("OK...... : " + tHistClinico2a);
		else
			System.out.println("ERRO.... : " + tHistClinico2a);
		HistClinico tHistClinico2b = tDaoHistClinico.create(tHistClinicoB);
		if (tHistClinico2b != null)
			System.out.println("OK...... : " + tHistClinico2b);
		else
			System.out.println("ERRO.... : " + tHistClinico2b);


    	//TESTE
    	//Criar tipo de exame
    	TipoExame tTipoExameA =new TipoExame(0, "Ultrassonografia");
    	TipoExame tTipoExameB =new TipoExame(0, "Sundreco");
    
    	// Criando o objeto de persistência
        TipoExameDao tTipoExameDao = new TipoExameDao();

    	//Incluir tipo de exame
        System.out.println();
        System.out.println("Incluindo o TipoExame");
        TipoExame tTipoExame2a = tTipoExameDao.create(tTipoExameA);
        if (tTipoExame2a != null)
            System.out.println("OK...... : " + tTipoExame2a);
        else
            System.out.println("ERRO.... : " + tTipoExame2a);
        TipoExame tTipoExame2b = tTipoExameDao.create(tTipoExameB);
        if (tTipoExame2b != null)
            System.out.println("OK...... : " + tTipoExame2b);
        else
            System.out.println("ERRO.... : " + tTipoExame2b);
        	
        //
        //Teste
        //
        //Criando um Exame         
        
    	Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Exame tExameA = new Exame(0, tData1,"exame do animal",  tTipoExame2a.getId(),tHistClinico2a.getId());
        Exame tExameB = new Exame(0,tData2,"exame para a biopsia",  tTipoExame2b.getId(),tHistClinico2b.getId());    
        
        // Criando o objeto de persistência
        ExameDao tDao = new ExameDao(); 
             
        // Incluir o Exame
        System.out.println();
        System.out.println("Incluindo o Exame");
        Exame tExame2a = tDao.create(tExameA);
        if (tExame2a != null)
            System.out.println("OK...... : " + tExame2a);
        else
            System.out.println("ERRO.... : " + tExame2a);
        Exame tExame2b = tDao.create(tExameB);
        if (tExame2b != null)
            System.out.println("OK...... : " + tExame2b);
        else
            System.out.println("ERRO.... : " + tExame2b);

        // Recuperando o Exame
        System.out.println();
        System.out.println("Recuperando");
        
        Exame tExame3a = tDao.recovery(tExame2a.getId());
        if (tExame3a != null)
            System.out.println("OK...... : " + tExame3a);
        else
            System.out.println("ERRO.... : " + tExame3a);
        Exame tExame3b = tDao.recovery(tExame2b.getId());
        if (tExame3b != null)
            System.out.println("OK...... : " + tExame3b);
        else
            System.out.println("ERRO.... : " + tExame3b);

        // Atualizando o Exame
        System.out.println();
        System.out.println("Atualizando");
        tExame2a.setDescricao(tExame2a.getDescricao() + "nao foi possivel realizar");

        Exame tExame4a = tDao.update(tExame2a);
        
        if (tExame4a != null)
            System.out.println("OK...... : " + tExame4a);
        else
            System.out.println("ERRO.... : " + tExame4a);

        tExame2b.setDescricao(tExame2b.getDescricao() + " Sundreco");
        
        Exame tExame4b = tDao.update(tExame2b);
        if (tExame4a != null)
            System.out.println("OK...... : " + tExame4b);
        else
            System.out.println("ERRO.... : " + tExame4b);

        // Recuperando o Exame
        System.out.println();
        System.out.println("Recuperando");
        Exame tExame5a = tDao.recovery(tExame2a.getId());
        if (tExame5a != null)
            System.out.println("OK...... : " + tExame5a);
        else
            System.out.println("ERRO.... : " + tExame5a);
        Exame tExame5b = tDao.recovery(tExame2b.getId());
        if (tExame5b != null)
            System.out.println("OK...... : " + tExame5b);
        else
            System.out.println("ERRO.... : " + tExame5b);

        // Listar os Exames
        List<Exame> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Exame tExame : tLista)
        {
            System.out.println("OK...... : " + tExame);
        }

        // Remover o Exame
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tExame2a.getId()))
            System.out.println("OK...... : " + tExame2a);
        else
            System.out.println("ERRO.... : " + tExame2a);
        if (tDao.delete(tExame2b.getId()))
            System.out.println("OK...... : " + tExame2b);
        else
            System.out.println("ERRO.... : " + tExame2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tExame2a.getId()))
            System.out.println("ERRO.... : " + tExame2a);
        else
            System.out.println("OK...... : " + tExame2a);
        if (tDao.delete(tExame2b.getId()))
            System.out.println("ERRO.... : " + tExame2b);
        else
            System.out.println("OK...... : " + tExame2b);
        
       //
       //Pos teste
       //
       //Remover o tipo de exame
        System.out.println("Removendo");
        if (tTipoExameDao.delete(tTipoExame2a.getId()))
            System.out.println("OK...... : " + tTipoExame2a);
        else
            System.out.println("ERRO.... : " + tTipoExame2a);
        if (tTipoExameDao.delete(tTipoExame2b.getId()))
            System.out.println("OK...... : " + tTipoExame2b);
        else
            System.out.println("ERRO.... : " + tTipoExame2b);
    
        // Remover o HistClinico
        System.out.println();
        System.out.println("Removendo");
        if (tDaoHistClinico.delete(tHistClinico2a.getId()))
            System.out.println("OK...... : " + tHistClinico2a);
        else
            System.out.println("ERRO.... : " + tHistClinico2a);
        if (tDaoHistClinico.delete(tHistClinico2b.getId()))
            System.out.println("OK...... : " + tHistClinico2b);
        else
            System.out.println("ERRO.... : " + tHistClinico2b);

    
    }
}