package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.RacaDao;
import br.com.vsoft.dao.EspecieDao;
import br.com.vsoft.model.Raca;
import br.com.vsoft.model.Especie;


public class TesteRacaDao {
	
    public static void main(String[] pArgs)
    {	
    	//
    	//Pre Teste
    	//
    	//Criar Especie
    	Especie tEspecieA =new Especie(0, "Especie Vai Pacia");
    	Especie tEspecieB =new Especie(0, "Especie Vai Cata Coquinho");
    
    	// Criando o objeto de persistência
        EspecieDao tEspecieDao = new EspecieDao();

    	//Incluir Especie
        System.out.println();
        System.out.println("Incluindo o Especie");
        Especie tEspecie2a = tEspecieDao.create(tEspecieA);
        if (tEspecie2a != null)
            System.out.println("OK...... : " + tEspecie2a);
        else
            System.out.println("ERRO.... : " + tEspecie2a);
        Especie tEspecie2b = tEspecieDao.create(tEspecieB);
        if (tEspecie2b != null)
            System.out.println("OK...... : " + tEspecie2b);
        else
            System.out.println("ERRO.... : " + tEspecie2b);
        	
        //
        //Teste
        //
        //Criando um Raca         
        Raca tRacaA = new Raca(0, "Vo nao",  tEspecie2a.getId());
        Raca tRacaB = new Raca(0,"Vai vc",  tEspecie2b.getId());    
        
        // Criando o objeto de persistência
        RacaDao tDao = new RacaDao(); 
             
        // Incluir o Raca
        System.out.println();
        System.out.println("Incluindo o Raca");
        Raca tRaca2a = tDao.create(tRacaA);
        if (tRaca2a != null)
            System.out.println("OK...... : " + tRaca2a);
        else
            System.out.println("ERRO.... : " + tRaca2a);
        Raca tRaca2b = tDao.create(tRacaB);
        if (tRaca2b != null)
            System.out.println("OK...... : " + tRaca2b);
        else
            System.out.println("ERRO.... : " + tRaca2b);

        // Recuperando o Raca
        System.out.println();
        System.out.println("Recuperando");
        
        Raca tRaca3a = tDao.recovery(tRaca2a.getId());
        if (tRaca3a != null)
            System.out.println("OK...... : " + tRaca3a);
        else
            System.out.println("ERRO.... : " + tRaca3a);
        Raca tRaca3b = tDao.recovery(tRaca2b.getId());
        if (tRaca3b != null)
            System.out.println("OK...... : " + tRaca3b);
        else
            System.out.println("ERRO.... : " + tRaca3b);

        // Atualizando o Raca
        System.out.println();
        System.out.println("Atualizando");
        tRaca2a.setDescricao("Raca de Vibora");

        Raca tRaca4a = tDao.update(tRaca2a);
        
        if (tRaca4a != null)
            System.out.println("OK...... : " + tRaca4a);
        else
            System.out.println("ERRO.... : " + tRaca4a);

        tRaca2b.setDescricao("Tua Familia");
        
        Raca tRaca4b = tDao.update(tRaca2b);
        if (tRaca4a != null)
            System.out.println("OK...... : " + tRaca4b);
        else
            System.out.println("ERRO.... : " + tRaca4b);

        // Recuperando o Raca
        System.out.println();
        System.out.println("Recuperando");
        Raca tRaca5a = tDao.recovery(tRaca2a.getId());
        if (tRaca5a != null)
            System.out.println("OK...... : " + tRaca5a);
        else
            System.out.println("ERRO.... : " + tRaca5a);
        Raca tRaca5b = tDao.recovery(tRaca2b.getId());
        if (tRaca5b != null)
            System.out.println("OK...... : " + tRaca5b);
        else
            System.out.println("ERRO.... : " + tRaca5b);

        // Listar os Racas
        List<Raca> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Raca tRaca : tLista)
        {
            System.out.println("OK...... : " + tRaca);
        }

        // Remover o Raca
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tRaca2a.getId()))
            System.out.println("OK...... : " + tRaca2a);
        else
            System.out.println("ERRO.... : " + tRaca2a);
        if (tDao.delete(tRaca2b.getId()))
            System.out.println("OK...... : " + tRaca2b);
        else
            System.out.println("ERRO.... : " + tRaca2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tRaca2a.getId()))
            System.out.println("ERRO.... : " + tRaca2a);
        else
            System.out.println("OK...... : " + tRaca2a);
        if (tDao.delete(tRaca2b.getId()))
            System.out.println("ERRO.... : " + tRaca2b);
        else
            System.out.println("OK...... : " + tRaca2b);
        
       //
       //Pos teste
       //
       //Remover o tipo de exame
        System.out.println("Removendo");
        if (tEspecieDao.delete(tEspecie2a.getId()))
            System.out.println("OK...... : " + tEspecie2a);
        else
            System.out.println("ERRO.... : " + tEspecie2a);
        if (tEspecieDao.delete(tEspecie2b.getId()))
            System.out.println("OK...... : " + tEspecie2b);
        else
            System.out.println("ERRO.... : " + tEspecie2b);
        
    }
}