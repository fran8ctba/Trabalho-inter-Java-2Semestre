package br.com.vsoft.teste;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import br.com.vsoft.controller.ExameController;
import br.com.vsoft.dao.ExameDao;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dao.TipoExameDao;
import br.com.vsoft.dto.ExameDto;
import br.com.vsoft.model.Exame;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.model.TipoExame;


public class TesteExameController
{
	 private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] pArgs) throws ParseException, java.text.ParseException
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
        
        Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Exame tExameA = new Exame(0,tData1, "exame do animal",  tTipoExame2a.getId(), tHistClinico2a.getId());
        
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

        //
        // Teste
        //

        // Criando o objeto de Controller
        ExameController tController = new ExameController();

        // Criar um exame
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Exame tExameB = new Exame(0,tData2,"exame para a biopsia",  tTipoExame2b.getId(), tHistClinico2b.getId());    
        
        // Criar o exame
        System.out.println();
        System.out.println("Incluindo um exame via controller");
        ExameDto tDto = tController.cadastrarExame(tExameB);
        if (tDto.isOk())
        {
            // Recuperando o exame incluído para obter o ID gerado
            tExameB = tDto.getExame();
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tExameB);
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Incluindo um exame nulo");
        tDto = tController.cadastrarExame(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        
        // Criar um exame com tipo de exame nao existente
        System.out.println();
        System.out.println("Agendando a consulta para médico que não existe");
        tExameB.setIdTipoExame(0);
        tDto = tController.atualizarExame(tExameB);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o exame
        System.out.println();
        System.out.println("Recuperando um exame via controller");
        tDto = tController.recuperarExame(tExameB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getExame());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um exame com id inválido");
        tDto = tController.recuperarExame(-32432);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um exame não existente");
        tDto = tController.recuperarExame(9999999);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }


        // Atualizando o exame
        System.out.println();
        System.out.println("Atualizando um exame via controller");
        tDto = tController.atualizarExame(tExameB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getExame());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Atualizando um exame nulo");
        tDto = tController.atualizarExame(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

       
        Exame tExameC = new Exame(0,tData2,"exame para a biopsia",  tTipoExame2b.getId(), tHistClinico2b.getId());    
        
        System.out.println();
        System.out.println("Atualizando um exame que não existe");
        tDto = tController.atualizarExame(tExameC);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o exame
        System.out.println();
        System.out.println("Recuperando um exame via controller");
        tDto = tController.recuperarExame(tExameB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getExame());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Removendo o exame
        System.out.println();
        System.out.println("Removendo um exame via controller");
        tDto = tController.removeExame(tExameB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Removendo um exame com id inválido");
        tDto = tController.removeExame(-4);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        //
        // Pós teste
        //
        // Remover o Exame
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tExame2a.getId()))
            System.out.println("OK...... : " + tExame2a);
        else
            System.out.println("ERRO.... : " + tExame2a);
    
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
