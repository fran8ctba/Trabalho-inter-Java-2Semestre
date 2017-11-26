package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.TipoExameDao;
import br.com.vsoft.model.TipoExame;

public class TesteTipoExameDao {

	    public static void main(String[] pArgs)
	    {
	        // Criar um TipoExame
	        TipoExame tTipoExameA = new TipoExame(0,"hemograma");
	        TipoExame tTipoExameB = new TipoExame(0, "bioquiemica");

	        // Criando o objeto de persistência
	        TipoExameDao tDao = new TipoExameDao();

	        // Incluir o TipoExame
	        System.out.println();
	        System.out.println("Incluindo");
	        TipoExame tTipoExame2a = tDao.create(tTipoExameA);
	        if (tTipoExame2a != null)
	            System.out.println("OK...... : " + tTipoExame2a);
	        else
	            System.out.println("ERRO.... : " + tTipoExame2a);
	        TipoExame tTipoExame2b = tDao.create(tTipoExameB);
	        if (tTipoExame2b != null)
	            System.out.println("OK...... : " + tTipoExame2b);
	        else
	            System.out.println("ERRO.... : " + tTipoExame2b);

	        // Recuperando o TipoExame
	        System.out.println();
	        System.out.println("Recuperando");
	        
	        TipoExame tTipoExame3a = tDao.recovery(tTipoExame2a.getId());
	        if (tTipoExame3a != null)
	            System.out.println("OK...... : " + tTipoExame3a);
	        else
	            System.out.println("ERRO.... : " + tTipoExame3a);
	        TipoExame tTipoExame3b = tDao.recovery(tTipoExame2b.getId());
	        if (tTipoExame3b != null)
	            System.out.println("OK...... : " + tTipoExame3b);
	        else
	            System.out.println("ERRO.... : " + tTipoExame3b);

	        // Atualizando o TipoExame
	        System.out.println();
	        System.out.println("Atualizando");
	        tTipoExame2a.setDescricao(tTipoExame2a.getDescricao() + " Ultrassonografia");

	        TipoExame tTipoExame4a = tDao.update(tTipoExame2a);
	        
	        if (tTipoExame4a != null)
	            System.out.println("OK...... : " + tTipoExame4a);
	        else
	            System.out.println("ERRO.... : " + tTipoExame4a);

	        tTipoExame2b.setDescricao(tTipoExame2b.getDescricao() + " Sundreco");
	        TipoExame tTipoExame4b = tDao.update(tTipoExame2b);
	        if (tTipoExame4a != null)
	            System.out.println("OK...... : " + tTipoExame4b);
	        else
	            System.out.println("ERRO.... : " + tTipoExame4b);

	        // Recuperando o TipoExame
	        System.out.println();
	        System.out.println("Recuperando");
	        TipoExame tTipoExame5a = tDao.recovery(tTipoExame2a.getId());
	        if (tTipoExame5a != null)
	            System.out.println("OK...... : " + tTipoExame5a);
	        else
	            System.out.println("ERRO.... : " + tTipoExame5a);
	        TipoExame tTipoExame5b = tDao.recovery(tTipoExame2b.getId());
	        if (tTipoExame5b != null)
	            System.out.println("OK...... : " + tTipoExame5b);
	        else
	            System.out.println("ERRO.... : " + tTipoExame5b);

	        // Listar os TipoExames
	        List<TipoExame> tLista = tDao.search();
	        System.out.println();
	        System.out.println("Pesquisando");
	        for (TipoExame tTipoExame : tLista)
	        {
	            System.out.println("OK...... : " + tTipoExame);
	        }

	        // Remover o TipoExame
	        System.out.println();
	        System.out.println("Removendo");
	        if (tDao.delete(tTipoExame2a.getId()))
	            System.out.println("OK...... : " + tTipoExame2a);
	        else
	            System.out.println("ERRO.... : " + tTipoExame2a);
	        if (tDao.delete(tTipoExame2b.getId()))
	            System.out.println("OK...... : " + tTipoExame2b);
	        else
	            System.out.println("ERRO.... : " + tTipoExame2b);

	        // Verificando se removeu
	        System.out.println();
	        System.out.println("Verificando a remoção");
	        if (tDao.delete(tTipoExame2a.getId()))
	            System.out.println("ERRO.... : " + tTipoExame2a);
	        else
	            System.out.println("OK...... : " + tTipoExame2a);
	        if (tDao.delete(tTipoExame2b.getId()))
	            System.out.println("ERRO.... : " + tTipoExame2b);
	        else
	            System.out.println("OK...... : " + tTipoExame2b);
	    }
	}
