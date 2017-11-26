package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.EstadoDao;
import br.com.vsoft.model.Estado;

public class TesteEstadoDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um Estado
	        Estado tEstadoA = new Estado(0, "AQUEL");
	        Estado tEstadoB = new Estado(0, "Anuuu");

	        // Criando o objeto de persistência
	        EstadoDao tDao = new EstadoDao();

	        // Incluir o Estado
	        System.out.println();
	        System.out.println("Incluindo");
	        Estado tEstado2a = tDao.create(tEstadoA);
	        if (tEstado2a != null)
	            System.out.println("OK...... : " + tEstado2a);
	        else
	            System.out.println("ERRO.... : " + tEstado2a);
	        Estado tEstado2b = tDao.create(tEstadoB);
	        if (tEstado2b != null)
	            System.out.println("OK...... : " + tEstado2b);
	        else
	            System.out.println("ERRO.... : " + tEstado2b);

	        // Recuperando o Estado
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        Estado tEstado3a = tDao.recovery(tEstado2a.getId());
	        if (tEstado3a != null)
	            System.out.println("OK...... : " + tEstado3a);
	        else
	            System.out.println("ERRO.... : " + tEstado3a);
	        Estado tEstado3b = tDao.recovery(tEstado2b.getId());
	        if (tEstado3b != null)
	            System.out.println("OK...... : " + tEstado3b);
	        else
	            System.out.println("ERRO.... : " + tEstado3b);

	        // Atualizando o Estado
	        System.out.println();
	        System.out.println("Atualizando");
	        tEstado2a.setNome("EUA");

	        Estado tEstado4a = tDao.update(tEstado2a);
	        
	        if (tEstado4a != null)
	            System.out.println("OK...... : " + tEstado4a);
	        else
	            System.out.println("ERRO.... : " + tEstado4a);

	        tEstado2b.setNome("NUUUUU");
	        Estado tEstado4b = tDao.update(tEstado2b);
	        if (tEstado4a != null)
	            System.out.println("OK...... : " + tEstado4b);
	        else
	            System.out.println("ERRO.... : " + tEstado4b);

	        // Recuperando o Estado
	        System.out.println();
	        System.out.println("Recuperando");
	        Estado tEstado5a = tDao.recovery(tEstado2a.getId());
	        if (tEstado5a != null)
	            System.out.println("OK...... : " + tEstado5a);
	        else
	            System.out.println("ERRO.... : " + tEstado5a);
	        Estado tEstado5b = tDao.recovery(tEstado2b.getId());
	        if (tEstado5b != null)
	            System.out.println("OK...... : " + tEstado5b);
	        else
	            System.out.println("ERRO.... : " + tEstado5b);

	        // Listar os Estados
	        List<Estado> tLista = tDao.search();
	        System.out.println();
	        System.out.println("Pesquisando");
	        for (Estado tEstado : tLista)
	        {
	            System.out.println("OK...... : " + tEstado);
	        }

	        // Remover o Estado
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tEstado2a.getId()))
	            System.out.println("OK...... : " + tEstado2a);
	        else
	            System.out.println("ERRO.... : " + tEstado2a);
	        if (tDao.delete(tEstado2b.getId()))
	            System.out.println("OK...... : " + tEstado2b);
	        else
	            System.out.println("ERRO.... : " + tEstado2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tEstado2a.getId()))
	            System.out.println("ERRO.... : " + tEstado2a);
	        else
	            System.out.println("OK...... : " + tEstado2a);
	        if (tDao.delete(tEstado2b.getId()))
	            System.out.println("ERRO.... : " + tEstado2b);
	        else
	            System.out.println("OK...... : " + tEstado2b);
	    }
	}
