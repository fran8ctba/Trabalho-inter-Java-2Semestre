package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.CidadeDao;
import br.com.vsoft.dao.EstadoDao;
import br.com.vsoft.model.Cidade;
import br.com.vsoft.model.Estado;


public class TesteCidadeDao {
	
    public static void main(String[] pArgs)
    {	
    	//
    	//Pre Teste
    	//
    	//Criar Estado
    	Estado tEstadoA =new Estado(0, "Parana");
    	Estado tEstadoB =new Estado(0, "Rondonia");
    
    	// Criando o objeto de persistência
        EstadoDao tEstadoDao = new EstadoDao();

    	//Incluir Estado
        System.out.println();
        System.out.println("Incluindo o Estado");
        Estado tEstado2a = tEstadoDao.create(tEstadoA);
        if (tEstado2a != null)
            System.out.println("OK...... : " + tEstado2a);
        else
            System.out.println("ERRO.... : " + tEstado2a);
        Estado tEstado2b = tEstadoDao.create(tEstadoB);
        if (tEstado2b != null)
            System.out.println("OK...... : " + tEstado2b);
        else
            System.out.println("ERRO.... : " + tEstado2b);
        	
        //
        //Teste
        //
        //Criando uma Cidade         
        Cidade tCidadeA = new Cidade(0, "Curuiuva",  tEstado2a.getId());
        Cidade tCidadeB = new Cidade(0, "Matelandia",  tEstado2b.getId());    
        
        // Criando o objeto de persistência
        CidadeDao tDao = new CidadeDao(); 
             
        // Incluir a Cidade
        System.out.println();
        System.out.println("Incluindo o Cidade");
        Cidade tCidade2a = tDao.create(tCidadeA);
        if (tCidade2a != null)
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        Cidade tCidade2b = tDao.create(tCidadeB);
        if (tCidade2b != null)
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

        // Recuperando o Cidade
        System.out.println();
        System.out.println("Recuperando");
        
        Cidade tCidade3a = tDao.recovery(tCidade2a.getId());
        if (tCidade3a != null)
            System.out.println("OK...... : " + tCidade3a);
        else
            System.out.println("ERRO.... : " + tCidade3a);
        Cidade tCidade3b = tDao.recovery(tCidade2b.getId());
        if (tCidade3b != null)
            System.out.println("OK...... : " + tCidade3b);
        else
            System.out.println("ERRO.... : " + tCidade3b);

        // Atualizando o Cidade
        System.out.println();
        System.out.println("Atualizando");
        tCidade2a.setNome( "Corijo");

        Cidade tCidade4a = tDao.update(tCidade2a);
        
        if (tCidade4a != null)
            System.out.println("OK...... : " + tCidade4a);
        else
            System.out.println("ERRO.... : " + tCidade4a);

        tCidade2b.setNome("Galinha");
        
        Cidade tCidade4b = tDao.update(tCidade2b);
        if (tCidade4a != null)
            System.out.println("OK...... : " + tCidade4b);
        else
            System.out.println("ERRO.... : " + tCidade4b);

        // Recuperando o Cidade
        System.out.println();
        System.out.println("Recuperando");
        Cidade tCidade5a = tDao.recovery(tCidade2a.getId());
        if (tCidade5a != null)
            System.out.println("OK...... : " + tCidade5a);
        else
            System.out.println("ERRO.... : " + tCidade5a);
        Cidade tCidade5b = tDao.recovery(tCidade2b.getId());
        if (tCidade5b != null)
            System.out.println("OK...... : " + tCidade5b);
        else
            System.out.println("ERRO.... : " + tCidade5b);

        // Listar os Cidades
        List<Cidade> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Cidade tCidade : tLista)
        {
            System.out.println("OK...... : " + tCidade);
        }

        // Remover o Cidade
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tCidade2a.getId()))
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        if (tDao.delete(tCidade2b.getId()))
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tCidade2a.getId()))
            System.out.println("ERRO.... : " + tCidade2a);
        else
            System.out.println("OK...... : " + tCidade2a);
        if (tDao.delete(tCidade2b.getId()))
            System.out.println("ERRO.... : " + tCidade2b);
        else
            System.out.println("OK...... : " + tCidade2b);
        
       //
       //Pos teste
       //
       //Remover o tipo de exame
        System.out.println("Removendo");
        if (tEstadoDao.delete(tEstado2a.getId()))
            System.out.println("OK...... : " + tEstado2a);
        else
            System.out.println("ERRO.... : " + tEstado2a);
        if (tEstadoDao.delete(tEstado2b.getId()))
            System.out.println("OK...... : " + tEstado2b);
        else
            System.out.println("ERRO.... : " + tEstado2b);
        
    }
}