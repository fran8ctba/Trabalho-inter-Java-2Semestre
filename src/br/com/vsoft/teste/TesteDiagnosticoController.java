package br.com.vsoft.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.vsoft.controller.DiagnosticoController;
import br.com.vsoft.dao.DiagnosticoDao;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dto.DiagnosticoDto;
import br.com.vsoft.model.Diagnostico;
import br.com.vsoft.model.HistClinico;


public class TesteDiagnosticoController
{
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
        // Pré Teste
        //
        // Criar um Diagnostico
    	//tDtAtualMsg.format(sFormatadorHora)
    	
    	Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Diagnostico tDiagnosticoA = new Diagnostico(0, tData1,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2a.getId());

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


        //
        // Teste
        //

        // Criando o objeto de Controller
        DiagnosticoController tController = new DiagnosticoController();

        // Criar um diagnostico
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Diagnostico tDiagnosticoB = new Diagnostico(0, tData2,"Kg", new BigDecimal("150.000"), "Rua Iguacu, 9",tHistClinico2b.getId());

        // Criar o diagnostico
        System.out.println();
        System.out.println("Incluindo um diagnostico via controller");
        DiagnosticoDto tDto = tController.cadastrarDiagnostico(tDiagnosticoB);
        if (tDto.isOk())
        {
            // Recuperando o diagnostico incluído para obter o ID gerado
            tDiagnosticoB = tDto.getDiagnostico();
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDiagnosticoB);
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Incluindo um diagnostico nulo");
        tDto = tController.cadastrarDiagnostico(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o diagnostico
        System.out.println();
        System.out.println("Recuperando um diagnostico via controller");
        tDto = tController.recuperarDiagnostico(tDiagnosticoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDiagnostico());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um diagnostico com id inválido");
        tDto = tController.recuperarDiagnostico(-32432);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um diagnostico não existente");
        tDto = tController.recuperarDiagnostico(9999999);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }


        // Atualizando o diagnostico
        System.out.println();
        System.out.println("Atualizando um diagnostico via controller");
        tDto = tController.atualizarDiagnostico(tDiagnosticoB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDiagnostico());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Atualizando um diagnostico nulo");
        tDto = tController.atualizarDiagnostico(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

    	Date tData3 = sFormatador.parse("08/11/2017 18:30");
        Diagnostico tDiagnosticoC = new Diagnostico(0, tData3,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2b.getId());

        System.out.println();
        System.out.println("Atualizando um diagnostico que não existe");
        tDto = tController.atualizarDiagnostico(tDiagnosticoC);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o diagnostico
        System.out.println();
        System.out.println("Recuperando um diagnostico via controller");
        tDto = tController.recuperarDiagnostico(tDiagnosticoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDiagnostico());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Removendo o diagnostico
        System.out.println();
        System.out.println("Removendo um diagnostico via controller");
        tDto = tController.removeDiagnostico(tDiagnosticoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Removendo um diagnostico com id inválido");
        tDto = tController.removeDiagnostico(-4);
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
        // Remover o Diagnostico
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tDiagnostico2a.getId()))
            System.out.println("OK...... : " + tDiagnostico2a);
        else
            System.out.println("ERRO.... : " + tDiagnostico2a);
    }
}
