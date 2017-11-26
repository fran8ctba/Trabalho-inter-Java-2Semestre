package br.com.vsoft.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import br.com.vsoft.dao.DiagnosticoDao;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.model.Diagnostico;
import br.com.vsoft.model.HistClinico;


public class TesteDiagnosticoDao {
	

    private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    public static void main(String[] pArgs) throws ParseException
    {
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

		//
		//PRE TESTE 
		//
        // Criar um Diagnostico
    	//tDtAtualMsg.format(sFormatadorHora)
    	
    	Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Diagnostico tDiagnosticoA = new Diagnostico(0, tData1,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2a.getId());
        Diagnostico tDiagnosticoB = new Diagnostico(0, tData2,"Kg", new BigDecimal("150.000"), "Rua Iguacu, 9",tHistClinico2b.getId());

        // Criando o objeto de persistência
        DiagnosticoDao tDao = new DiagnosticoDao();

        // Incluir o Diagnostico
        System.out.println();
        System.out.println("Incluindo");
        Diagnostico tDiagnostico2a = tDao.create(tDiagnosticoA);
        if (tDiagnostico2a != null)
            System.out.println("OK...... : " + tDiagnostico2a);
        else
            System.out.println("ERRO.... : " + tDiagnostico2a);
        Diagnostico tDiagnostico2b = tDao.create(tDiagnosticoB);
        if (tDiagnostico2b != null)
            System.out.println("OK...... : " + tDiagnostico2b);
        else
            System.out.println("ERRO.... : " + tDiagnostico2b);

        // Recuperando o Diagnostico
        System.out.println();
        System.out.println("Recuperando");
        Diagnostico tDiagnostico3a = tDao.recovery(tDiagnostico2a.getId());
        if (tDiagnostico3a != null)
            System.out.println("OK...... : " + tDiagnostico3a);
        else
            System.out.println("ERRO.... : " + tDiagnostico3a);
        Diagnostico tDiagnostico3b = tDao.recovery(tDiagnostico2b.getId());
        if (tDiagnostico3b != null)
            System.out.println("OK...... : " + tDiagnostico3b);
        else
            System.out.println("ERRO.... : " + tDiagnostico3b);

        // Atualizando o Diagnostico
        Date tData3 = sFormatador.parse("25/09/2017 10:30");
        Date tData4 = sFormatador.parse("14/11/2017 08:00");
        
        System.out.println();
        System.out.println("Atualizando");
        tDiagnostico2a.setData(tData3);
        tDiagnostico2a.setUnMedida("Kg");
        tDiagnostico2a.setPeso(new BigDecimal("10"));
        tDiagnostico2a.setDiagnosticoTexto("lavar uma vaez a cada 5 dias.");
        
        
        Diagnostico tDiagnostico4a = tDao.update(tDiagnostico2a);
        if (tDiagnostico4a != null)
            System.out.println("OK...... : " + tDiagnostico4a);
        else
            System.out.println("ERRO.... : " + tDiagnostico4a);

        tDiagnostico2b.setData(tData4);
        tDiagnostico2b.setUnMedida("Kg");
        tDiagnostico2b.setPeso(new BigDecimal("12"));
        tDiagnostico2b.setDiagnosticoTexto("lavar uma vez a cada 5 dias.");        
        Diagnostico tDiagnostico4b = tDao.update(tDiagnostico2b);
        
        if (tDiagnostico4a != null)
            System.out.println("OK...... : " + tDiagnostico4b);
        else
            System.out.println("ERRO.... : " + tDiagnostico4b);

        // Recuperando o Diagnostico
        System.out.println();
        System.out.println("Recuperando");
        Diagnostico tDiagnostico5a = tDao.recovery(tDiagnostico2a.getId());
        if (tDiagnostico5a != null)
            System.out.println("OK...... : " + tDiagnostico5a);
        else
            System.out.println("ERRO.... : " + tDiagnostico5a);
        Diagnostico tDiagnostico5b = tDao.recovery(tDiagnostico2b.getId());
        if (tDiagnostico5b != null)
            System.out.println("OK...... : " + tDiagnostico5b);
        else
            System.out.println("ERRO.... : " + tDiagnostico5b);

        // Listar os Diagnosticos
        List<Diagnostico> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Diagnostico tDiagnostico : tLista)
        {
            System.out.println("OK...... : " + tDiagnostico);
        }

        // Remover o Diagnostico
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tDiagnostico2a.getId()))
            System.out.println("OK...... : " + tDiagnostico2a);
        else
            System.out.println("ERRO.... : " + tDiagnostico2a);
        if (tDao.delete(tDiagnostico2b.getId()))
            System.out.println("OK...... : " + tDiagnostico2b);
        else
            System.out.println("ERRO.... : " + tDiagnostico2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tDiagnostico2a.getId()))
            System.out.println("ERRO.... : " + tDiagnostico2a);
        else
            System.out.println("OK...... : " + tDiagnostico2a);
        if (tDao.delete(tDiagnostico2b.getId()))
            System.out.println("ERRO.... : " + tDiagnostico2b);
        else
            System.out.println("OK...... : " + tDiagnostico2b);
   
    //posteste
        
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

