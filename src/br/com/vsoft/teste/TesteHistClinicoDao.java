package br.com.vsoft.teste;

import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.model.HistClinico;

public class TesteHistClinicoDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um HistClinico
	        HistClinico tHistClinicoA = new HistClinico(0);
	        HistClinico tHistClinicoB = new HistClinico(0);

	        // Criando o objeto de persistência
	        HistClinicoDao tDao = new HistClinicoDao();

	        // Incluir o HistClinico
	        System.out.println();
	        System.out.println("Incluindo");
	        HistClinico tHistClinico2a = tDao.create(tHistClinicoA);
	        if (tHistClinico2a != null)
	            System.out.println("OK...... : " + tHistClinico2a);
	        else
	            System.out.println("ERRO.... : " + tHistClinico2a);
	        HistClinico tHistClinico2b = tDao.create(tHistClinicoB);
	        if (tHistClinico2b != null)
	            System.out.println("OK...... : " + tHistClinico2b);
	        else
	            System.out.println("ERRO.... : " + tHistClinico2b);

	        // Recuperando o HistClinico
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        HistClinico tHistClinico3a = tDao.recovery(tHistClinico2a.getId());
	        if (tHistClinico3a != null)
	            System.out.println("OK...... : " + tHistClinico3a);
	        else
	            System.out.println("ERRO.... : " + tHistClinico3a);
	        HistClinico tHistClinico3b = tDao.recovery(tHistClinico2b.getId());
	        if (tHistClinico3b != null)
	            System.out.println("OK...... : " + tHistClinico3b);
	        else
	            System.out.println("ERRO.... : " + tHistClinico3b);

	        // Atualizando o HistClinico
	        System.out.println();
	        System.out.println("Atualizando");
	        
	        
	        // Recuperando o HistClinico
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        // Remover o HistClinico
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tHistClinico2a.getId()))
	            System.out.println("OK...... : " + tHistClinico2a);
	        else
	            System.out.println("ERRO.... : " + tHistClinico2a);
	        if (tDao.delete(tHistClinico2b.getId()))
	            System.out.println("OK...... : " + tHistClinico2b);
	        else
	            System.out.println("ERRO.... : " + tHistClinico2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tHistClinico2a.getId()))
	            System.out.println("ERRO.... : " + tHistClinico2a);
	        else
	            System.out.println("OK...... : " + tHistClinico2a);
	        if (tDao.delete(tHistClinico2b.getId()))
	            System.out.println("ERRO.... : " + tHistClinico2b);
	        else
	            System.out.println("OK...... : " + tHistClinico2b);
	    }
	}
