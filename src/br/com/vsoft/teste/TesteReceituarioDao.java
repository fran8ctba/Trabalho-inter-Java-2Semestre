package br.com.vsoft.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dao.ReceituarioDao;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.model.Receituario;


public class TesteReceituarioDao {
	

    private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    public static void main(String[] pArgs) throws ParseException
    {
		//
		//PRE TESTE 
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


    	
    	//Teste
        // Criar um Receituario
    	//tDtAtualMsg.format(sFormatadorHora)
    	
    	Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Receituario tReceituarioA = new Receituario(0, tData1,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2a.getId());
        Receituario tReceituarioB = new Receituario(0, tData2,"Kg", new BigDecimal("150.000"), "Rua Iguacu, 9",tHistClinico2b.getId());

        // Criando o objeto de persistência
        ReceituarioDao tDao = new ReceituarioDao();

        // Incluir o Receituario
        System.out.println();
        System.out.println("Incluindo");
        Receituario tReceituario2a = tDao.create(tReceituarioA);
        if (tReceituario2a != null)
            System.out.println("OK...... : " + tReceituario2a);
        else
            System.out.println("ERRO.... : " + tReceituario2a);
        Receituario tReceituario2b = tDao.create(tReceituarioB);
        if (tReceituario2b != null)
            System.out.println("OK...... : " + tReceituario2b);
        else
            System.out.println("ERRO.... : " + tReceituario2b);

        // Recuperando o Receituario
        System.out.println();
        System.out.println("Recuperando");
        Receituario tReceituario3a = tDao.recovery(tReceituario2a.getId());
        if (tReceituario3a != null)
            System.out.println("OK...... : " + tReceituario3a);
        else
            System.out.println("ERRO.... : " + tReceituario3a);
        Receituario tReceituario3b = tDao.recovery(tReceituario2b.getId());
        if (tReceituario3b != null)
            System.out.println("OK...... : " + tReceituario3b);
        else
            System.out.println("ERRO.... : " + tReceituario3b);

        // Atualizando o Receituario
        Date tData3 = sFormatador.parse("25/09/2017 10:30");
        Date tData4 = sFormatador.parse("14/11/2017 08:00");
        
        System.out.println();
        System.out.println("Atualizando");
        tReceituario2a.setData(tData3);
        tReceituario2a.setUnMedida("Kg");
        tReceituario2a.setPeso(new BigDecimal("10"));
        tReceituario2a.setReceitaTexto("lavar uma vaez a cada 5 dias.");
        
        
        Receituario tReceituario4a = tDao.update(tReceituario2a);
        if (tReceituario4a != null)
            System.out.println("OK...... : " + tReceituario4a);
        else
            System.out.println("ERRO.... : " + tReceituario4a);

        tReceituario2b.setData(tData4);
        tReceituario2b.setUnMedida("Kg");
        tReceituario2b.setPeso(new BigDecimal("12"));
        tReceituario2b.setReceitaTexto("lavar uma vez a cada 5 dias.");        
        Receituario tReceituario4b = tDao.update(tReceituario2b);
        
        if (tReceituario4a != null)
            System.out.println("OK...... : " + tReceituario4b);
        else
            System.out.println("ERRO.... : " + tReceituario4b);

        // Recuperando o Receituario
        System.out.println();
        System.out.println("Recuperando");
        Receituario tReceituario5a = tDao.recovery(tReceituario2a.getId());
        if (tReceituario5a != null)
            System.out.println("OK...... : " + tReceituario5a);
        else
            System.out.println("ERRO.... : " + tReceituario5a);
        Receituario tReceituario5b = tDao.recovery(tReceituario2b.getId());
        if (tReceituario5b != null)
            System.out.println("OK...... : " + tReceituario5b);
        else
            System.out.println("ERRO.... : " + tReceituario5b);

        // Listar os Receituarios
        List<Receituario> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Receituario tReceituario : tLista)
        {
            System.out.println("OK...... : " + tReceituario);
        }

        // Remover o Receituario
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tReceituario2a.getId()))
            System.out.println("OK...... : " + tReceituario2a);
        else
            System.out.println("ERRO.... : " + tReceituario2a);
        if (tDao.delete(tReceituario2b.getId()))
            System.out.println("OK...... : " + tReceituario2b);
        else
            System.out.println("ERRO.... : " + tReceituario2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tReceituario2a.getId()))
            System.out.println("ERRO.... : " + tReceituario2a);
        else
            System.out.println("OK...... : " + tReceituario2a);
        if (tDao.delete(tReceituario2b.getId()))
            System.out.println("ERRO.... : " + tReceituario2b);
        else
            System.out.println("OK...... : " + tReceituario2b);
    
    
    //Pos teste
        
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

