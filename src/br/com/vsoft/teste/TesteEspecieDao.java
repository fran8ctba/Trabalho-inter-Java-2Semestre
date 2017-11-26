package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.EspecieDao;
import br.com.vsoft.model.Especie;

public class TesteEspecieDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um Especie
	        Especie tEspecieA = new Especie(0,"Rasquerento");
	        Especie tEspecieB = new Especie(0, "Nojento");

	        // Criando o objeto de persistência
	        EspecieDao tDao = new EspecieDao();

	        // Incluir o Especie
	        System.out.println();
	        System.out.println("Incluindo");
	        Especie tEspecie2a = tDao.create(tEspecieA);
	        if (tEspecie2a != null)
	            System.out.println("OK...... : " + tEspecie2a);
	        else
	            System.out.println("ERRO.... : " + tEspecie2a);
	        Especie tEspecie2b = tDao.create(tEspecieB);
	        if (tEspecie2b != null)
	            System.out.println("OK...... : " + tEspecie2b);
	        else
	            System.out.println("ERRO.... : " + tEspecie2b);

	        // Recuperando o Especie
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        Especie tEspecie3a = tDao.recovery(tEspecie2a.getId());
	        if (tEspecie3a != null)
	            System.out.println("OK...... : " + tEspecie3a);
	        else
	            System.out.println("ERRO.... : " + tEspecie3a);
	        Especie tEspecie3b = tDao.recovery(tEspecie2b.getId());
	        if (tEspecie3b != null)
	            System.out.println("OK...... : " + tEspecie3b);
	        else
	            System.out.println("ERRO.... : " + tEspecie3b);

	        // Atualizando o Especie
	        System.out.println();
	        System.out.println("Atualizando");
	        tEspecie2a.setDescricao("Especie Rasquerento");

	        Especie tEspecie4a = tDao.update(tEspecie2a);
	        
	        if (tEspecie4a != null)
	            System.out.println("OK...... : " + tEspecie4a);
	        else
	            System.out.println("ERRO.... : " + tEspecie4a);

	        tEspecie2b.setDescricao("Especie Nojento");
	        Especie tEspecie4b = tDao.update(tEspecie2b);
	        if (tEspecie4a != null)
	            System.out.println("OK...... : " + tEspecie4b);
	        else
	            System.out.println("ERRO.... : " + tEspecie4b);

	        // Recuperando o Especie
	        System.out.println();
	        System.out.println("Recuperando");
	        Especie tEspecie5a = tDao.recovery(tEspecie2a.getId());
	        if (tEspecie5a != null)
	            System.out.println("OK...... : " + tEspecie5a);
	        else
	            System.out.println("ERRO.... : " + tEspecie5a);
	        Especie tEspecie5b = tDao.recovery(tEspecie2b.getId());
	        if (tEspecie5b != null)
	            System.out.println("OK...... : " + tEspecie5b);
	        else
	            System.out.println("ERRO.... : " + tEspecie5b);

	        // Listar os Especies
	        List<Especie> tLista = tDao.search();
	        System.out.println();
	        System.out.println("Pesquisando");
	        for (Especie tEspecie : tLista)
	        {
	            System.out.println("OK...... : " + tEspecie);
	        }

	        // Remover o Especie
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tEspecie2a.getId()))
	            System.out.println("OK...... : " + tEspecie2a);
	        else
	            System.out.println("ERRO.... : " + tEspecie2a);
	        if (tDao.delete(tEspecie2b.getId()))
	            System.out.println("OK...... : " + tEspecie2b);
	        else
	            System.out.println("ERRO.... : " + tEspecie2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tEspecie2a.getId()))
	            System.out.println("ERRO.... : " + tEspecie2a);
	        else
	            System.out.println("OK...... : " + tEspecie2a);
	        if (tDao.delete(tEspecie2b.getId()))
	            System.out.println("ERRO.... : " + tEspecie2b);
	        else
	            System.out.println("OK...... : " + tEspecie2b);
	    }
	}
