package br.com.vsoft.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.vsoft.controller.ReceituarioController;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dao.ReceituarioDao;
import br.com.vsoft.dto.ReceituarioDto;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.model.Receituario;


public class TesteReceituarioController
{
    private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public static void main(String[] pArgs) throws ParseException
    {
        //
        // Pré Teste
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
        // Criar um Receituario
    	//tDtAtualMsg.format(sFormatadorHora)
    	
    	Date tData1 = sFormatador.parse("15/09/2017 18:30");
        Receituario tReceituarioA = new Receituario(0, tData1,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2a.getId());

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


        //
        // Teste
        //

        // Criando o objeto de Controller
        ReceituarioController tController = new ReceituarioController();

        // Criar um receituario
        Date tData2 = sFormatador.parse("04/10/2017 10:45");
        Receituario tReceituarioB = new Receituario(0, tData2,"Kg", new BigDecimal("150.000"), "Rua Iguacu, 9",tHistClinico2b.getId());

        // Criar o receituario
        System.out.println();
        System.out.println("Incluindo um receituario via controller");
        ReceituarioDto tDto = tController.cadastrarReceituario(tReceituarioB);
        if (tDto.isOk())
        {
            // Recuperando o receituario incluído para obter o ID gerado
            tReceituarioB = tDto.getReceituario();
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tReceituarioB);
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Incluindo um receituario nulo");
        tDto = tController.cadastrarReceituario(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o receituario
        System.out.println();
        System.out.println("Recuperando um receituario via controller");
        tDto = tController.recuperarReceituario(tReceituarioB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getReceituario());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um receituario com id inválido");
        tDto = tController.recuperarReceituario(-32432);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um receituario não existente");
        tDto = tController.recuperarReceituario(9999999);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }


        // Atualizando o receituario
        System.out.println();
        System.out.println("Atualizando um receituario via controller");
        tDto = tController.atualizarReceituario(tReceituarioB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getReceituario());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Atualizando um receituario nulo");
        tDto = tController.atualizarReceituario(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

    	Date tData3 = sFormatador.parse("08/11/2017 18:30");
        Receituario tReceituarioC = new Receituario(0, tData3,"Kg", new BigDecimal("250.000"), "Rua getulio vargas, 902",tHistClinico2b.getId());

        System.out.println();
        System.out.println("Atualizando um receituario que não existe");
        tDto = tController.atualizarReceituario(tReceituarioC);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o receituario
        System.out.println();
        System.out.println("Recuperando um receituario via controller");
        tDto = tController.recuperarReceituario(tReceituarioB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getReceituario());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Removendo o receituario
        System.out.println();
        System.out.println("Removendo um receituario via controller");
        tDto = tController.removeReceituario(tReceituarioB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Removendo um receituario com id inválido");
        tDto = tController.removeReceituario(-4);
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
        // Remover o Receituario
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tReceituario2a.getId()))
            System.out.println("OK...... : " + tReceituario2a);
        else
            System.out.println("ERRO.... : " + tReceituario2a);

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
