package br.com.vsoft.teste;

import java.time.LocalDate;
import java.util.List;

import br.com.vsoft.dao.CidadeDao;
import br.com.vsoft.dao.DonoDao;
import br.com.vsoft.dao.EstadoDao;
import br.com.vsoft.model.Cidade;
import br.com.vsoft.model.Dono;
import br.com.vsoft.model.Estado;


public class TesteDonoDao {
	
    public static void main(String[] pArgs)
    {	
    	//
    	//Pre Teste
    	//
    	//Criar tipo de Estado
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
        //Criando um Cidade         
        Cidade tCidadeA = new Cidade(0, "exame do animal",  tEstado2a.getId());
        Cidade tCidadeB = new Cidade(0, "exame para a biopsia",  tEstado2b.getId());    
        
        // Criando o objeto de persistência
        CidadeDao tCidadeDao = new CidadeDao(); 
             
        // Incluir o Cidade
        System.out.println();
        System.out.println("Incluindo o Cidade");
        Cidade tCidade2a = tCidadeDao.create(tCidadeA);
        if (tCidade2a != null)
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        Cidade tCidade2b = tCidadeDao.create(tCidadeB);
        if (tCidade2b != null)
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

        //
        //Teste
        //
        //Criando um Dono
        //ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE
        Dono tDonoA = new Dono(0, 
        				"ruiva",
        				"f", 
        				LocalDate.of(2000, 11, 29),
        				124567892L,
        				23652215896L,
        				41986868622L,
        				4132697952L,
        				"fran8ctbahotmail.com",
        				"jorgina123",
        				"ligar 2 dias antes da consulta",
        				"Antonio Teixeira 450",
        				"Rebolcas",
        				811256325L,
        				tCidade2a.getId());
        Dono tDonoB = new Dono(0,
        				"julia",
        				"f", 
        				LocalDate.of(1999, 11, 8),
        				103171261L,
        				11908805986L,
        				41984568688L,
        				4132569855L,
        				"vandasilva_gmail.com",
        				"camila1239",
        				"ligar 2 dias antes da consulta",
        				"Antonio Teixeira 450",
        				"Rebolcas",
        				811256325L,
        				tCidade2b.getId());    
        
        // Criando o objeto de persistência
        DonoDao tDao = new DonoDao(); 
             
        // Incluir o Dono
        System.out.println();
        System.out.println("Incluindo o Dono");
        Dono tDono2a = tDao.create(tDonoA);
        if (tDono2a != null)
            System.out.println("OK...... : " + tDono2a);
        else
            System.out.println("ERRO.... : " + tDono2a);
        Dono tDono2b = tDao.create(tDonoB);
        if (tDono2b != null)
            System.out.println("OK...... : " + tDono2b);
        else
            System.out.println("ERRO.... : " + tDono2b);

        // Recuperando o Dono
        System.out.println();
        System.out.println("Recuperando");
        
        Dono tDono3a = tDao.recovery(tDono2a.getId());
        if (tDono3a != null)
            System.out.println("OK...... : " + tDono3a);
        else
            System.out.println("ERRO.... : " + tDono3a);
        Dono tDono3b = tDao.recovery(tDono2b.getId());
        if (tDono3b != null)
            System.out.println("OK...... : " + tDono3b);
        else
            System.out.println("ERRO.... : " + tDono3b);

        // Atualizando o Dono
        System.out.println();
        System.out.println("Atualizando");
      //ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE
        tDono2a.setNome("RUIVA");
        Dono tDono4a = tDao.update(tDono2a);
        
        if (tDono4a != null)
            System.out.println("OK...... : " + tDono4a);
        else
            System.out.println("ERRO.... : " + tDono4a);

      //ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE
        tDono2b.setNome("JULIA");
        tDono2b.setSexo("m");
        tDono2b.setDataNascimento(LocalDate.of(2000, 1, 31));
        tDono2b.setRg(11321546L);
        tDono2b.setCpf(15646516L);
        tDono2b.setTelefone(4132226565L);
        tDono2b.setCelular(41956868686L);
        tDono2b.setEmail("Floquinho@hotmail.com");
        tDono2b.setSenha("coisafeiasaidaqui");
        tDono2b.setObservacao("Pegara o animalzinho as 13 todas as vezes");
        tDono2b.setEndereco("AQuela rua 12445");
        tDono2b.setBairro("oiiiiii");
        tDono2b.setCep(121456416L);
         
        Dono tDono4b = tDao.update(tDono2b);
        if (tDono4a != null)
            System.out.println("OK...... : " + tDono4b);
        else
            System.out.println("ERRO.... : " + tDono4b);

        // Recuperando o Dono
        System.out.println();
        System.out.println("Recuperando");
        Dono tDono5a = tDao.recovery(tDono2a.getId());
        if (tDono5a != null)
            System.out.println("OK...... : " + tDono5a);
        else
            System.out.println("ERRO.... : " + tDono5a);
        Dono tDono5b = tDao.recovery(tDono2b.getId());
        if (tDono5b != null)
            System.out.println("OK...... : " + tDono5b);
        else
            System.out.println("ERRO.... : " + tDono5b);

        // Listar os Donos
        List<Dono> tLista = tDao.search();
        System.out.println();
        System.out.println("Pesquisando");
        for (Dono tDono : tLista)
        {
            System.out.println("OK...... : " + tDono);
        }

        // Remover o Dono
        System.out.println();
        System.out.println("Removendo");
        if (tDao.delete(tDono2a.getId()))
            System.out.println("OK...... : " + tDono2a);
        else
            System.out.println("ERRO.... : " + tDono2a);
        if (tDao.delete(tDono2b.getId()))
            System.out.println("OK...... : " + tDono2b);
        else
            System.out.println("ERRO.... : " + tDono2b);

        // Verificando se removeu
        System.out.println();
        System.out.println("Verificando a remoção");
        if (tDao.delete(tDono2a.getId()))
            System.out.println("ERRO.... : " + tDono2a);
        else
            System.out.println("OK...... : " + tDono2a);
        if (tDao.delete(tDono2b.getId()))
            System.out.println("ERRO.... : " + tDono2b);
        else
            System.out.println("OK...... : " + tDono2b);
        
       //
       //Pos teste
       //
        // Remover o Cidade
        System.out.println();
        System.out.println("Removendo");
        if (tCidadeDao.delete(tCidade2a.getId()))
            System.out.println("OK...... : " + tCidade2a);
        else
            System.out.println("ERRO.... : " + tCidade2a);
        if (tCidadeDao.delete(tCidade2b.getId()))
            System.out.println("OK...... : " + tCidade2b);
        else
            System.out.println("ERRO.... : " + tCidade2b);

       //Remover o tipo de Estado
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