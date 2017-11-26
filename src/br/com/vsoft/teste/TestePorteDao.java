package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.PorteDao;
import br.com.vsoft.model.Porte;

public class TestePorteDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um Porte
	        Porte tPorteA = new Porte(0,"MEGA GIGANTE");
	        Porte tPorteB = new Porte(0,"Super pequeno");

	        // Criando o objeto de persistência
	        PorteDao tDao = new PorteDao();

	        // Incluir o Porte
	        System.out.println();
	        System.out.println("Incluindo");
	        Porte tPorte2a = tDao.create(tPorteA);
	        if (tPorte2a != null)
	            System.out.println("OK...... : " + tPorte2a);
	        else
	            System.out.println("ERRO.... : " + tPorte2a);
	        Porte tPorte2b = tDao.create(tPorteB);
	        if (tPorte2b != null)
	            System.out.println("OK...... : " + tPorte2b);
	        else
	            System.out.println("ERRO.... : " + tPorte2b);

	        // Recuperando o Porte
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        Porte tPorte3a = tDao.recovery(tPorte2a.getId());
	        if (tPorte3a != null)
	            System.out.println("OK...... : " + tPorte3a);
	        else
	            System.out.println("ERRO.... : " + tPorte3a);
	        Porte tPorte3b = tDao.recovery(tPorte2b.getId());
	        if (tPorte3b != null)
	            System.out.println("OK...... : " + tPorte3b);
	        else
	            System.out.println("ERRO.... : " + tPorte3b);

	        // Atualizando o Porte
	        System.out.println();
	        System.out.println("Atualizando");
	        tPorte2a.setDescricao("MEGA GIGANTAOOOOOO");

	        Porte tPorte4a = tDao.update(tPorte2a);
	        
	        if (tPorte4a != null)
	            System.out.println("OK...... : " + tPorte4a);
	        else
	            System.out.println("ERRO.... : " + tPorte4a);

	        tPorte2b.setDescricao(" super pequenininhuuuuuuuu");
	        Porte tPorte4b = tDao.update(tPorte2b);
	        if (tPorte4a != null)
	            System.out.println("OK...... : " + tPorte4b);
	        else
	            System.out.println("ERRO.... : " + tPorte4b);

	        // Recuperando o Porte
	        System.out.println();
	        System.out.println("Recuperando");
	        Porte tPorte5a = tDao.recovery(tPorte2a.getId());
	        if (tPorte5a != null)
	            System.out.println("OK...... : " + tPorte5a);
	        else
	            System.out.println("ERRO.... : " + tPorte5a);
	        Porte tPorte5b = tDao.recovery(tPorte2b.getId());
	        if (tPorte5b != null)
	            System.out.println("OK...... : " + tPorte5b);
	        else
	            System.out.println("ERRO.... : " + tPorte5b);

	        // Listar os Portes
	        List<Porte> tLista = tDao.search();
	        System.out.println();
	        System.out.println("Pesquisando");
	        for (Porte tPorte : tLista)
	        {
	            System.out.println("OK...... : " + tPorte);
	        }

	        // Remover o Porte
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tPorte2a.getId()))
	            System.out.println("OK...... : " + tPorte2a);
	        else
	            System.out.println("ERRO.... : " + tPorte2a);
	        if (tDao.delete(tPorte2b.getId()))
	            System.out.println("OK...... : " + tPorte2b);
	        else
	            System.out.println("ERRO.... : " + tPorte2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tPorte2a.getId()))
	            System.out.println("ERRO.... : " + tPorte2a);
	        else
	            System.out.println("OK...... : " + tPorte2a);
	        if (tDao.delete(tPorte2b.getId()))
	            System.out.println("ERRO.... : " + tPorte2b);
	        else
	            System.out.println("OK...... : " + tPorte2b);
	    }
	}
