package br.com.vsoft.teste;

import java.time.LocalDate;

import br.com.vsoft.controller.DonoController;
import br.com.vsoft.dao.CidadeDao;
import br.com.vsoft.dao.DonoDao;
import br.com.vsoft.dao.EstadoDao;
import br.com.vsoft.dto.DonoDto;
import br.com.vsoft.model.Cidade;
import br.com.vsoft.model.Dono;
import br.com.vsoft.model.Estado;

public class TesteDonoController {

	public static void main(String[] pArgs) {
		//
		// Pre Teste
		//
		// Criar tipo de Estado
		Estado tEstadoA = new Estado(0, "Parana");
		Estado tEstadoB = new Estado(0, "Rondonia");

		// Criando o objeto de persistência
		EstadoDao tEstadoDao = new EstadoDao();

		// Incluir Estado
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
		// Teste
		//
		// Criando um Cidade
		Cidade tCidadeA = new Cidade(0, "exame do animal", tEstado2a.getId());
		Cidade tCidadeB = new Cidade(0, "exame para a biopsia", tEstado2b.getId());

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
		// Teste
		//
		// Criando um Dono
		// ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA,
		// OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE
		Dono tDonoA = new Dono(0, "ruiva", "f", LocalDate.of(2000, 11, 29), 124567892L, 23652215896L, 41986868622L,
				4132697952L, "fran8ctbahotmail.com", "jorgina123", "ligar 2 dias antes da consulta",
				"Antonio Teixeira 450", "Rebolcas", 811256325L, tCidade2a.getId());

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

		
		//
        // Teste
        //

        // Criando o objeto de Controller
        DonoController tController = new DonoController();


		Dono tDonoB = new Dono(0, "julia", "f", LocalDate.of(1999, 11, 8), 119088861L, 11905966L, 41984568688L,
				41329888L, "vandasilva_gmail.com", "camila1239", "ligar 2 dias antes da consulta",
				"Antonio Teixeira 450", "Rebolcas", 811256325L, tCidade2b.getId());

		// Criar o dono
		System.out.println();
		System.out.println("Incluindo um dono via controller");
		DonoDto tDto = tController.cadastrarDono(tDonoB);
		if (tDto.isOk()) {
			// Recuperando o dono incluído para obter o ID gerado
			tDonoB = tDto.getDono();
			System.out.println("OK...... : " + tDto.getMensagem());
			System.out.println("           " + tDonoB);
		} else {
			System.out.println("ERRO.... : " + tDto.getMensagem());
		}
		
		
        // Recuperar o dono
        System.out.println();
        System.out.println("Recuperando um dono via controller");
        tDto = tController.recuperarDono(tDonoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDono());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um dono com id inválido");
        tDto = tController.recuperarDono(-32432);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Recuperando um dono não existente");
        tDto = tController.recuperarDono(9999999);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }
        
        


        // Atualizar o dono
        tDonoB.setNome(tDonoB.getNome() + " Silvantino");
        tDonoB.setDataNascimento(LocalDate.of(2000, 1, 1));
        tDonoB.setTelefone(998975511);
        tDonoB.setEmail("silvantino@gmail.com");
        tDonoB.setCpf(tDono2a.getCpf());

        System.out.println();
        System.out.println("Atualizando um dono para um cpf que existe");
        tDto = tController.atualizarDono(tDonoB);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Acertando o CPF para a atualização
        tDonoB.setCpf(88888888888L);

        // Atualizando o dono
        System.out.println();
        System.out.println("Atualizando um dono via controller");
        tDto = tController.atualizarDono(tDonoB);
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDono());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Atualizando um dono nulo");
        tDto = tController.atualizarDono(null);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

		Dono tDonoC = new Dono(0, "RUIVAAAAAAA", "f", LocalDate.of(2000, 11, 29), 124567892L, 23652215896L, 41986868622L,
				4132697952L, "fran8ctbahotmail.com", "jorgina123", "ligar 2 dias antes da consulta",
				"Antonio Teixeira 450", "Rebolcas", 811256325L, tCidade2a.getId());


        System.out.println();
        System.out.println("Atualizando um dono que não existe");
        tDto = tController.atualizarDono(tDonoC);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Recuperar o dono
        System.out.println();
        System.out.println("Recuperando um dono via controller");
        tDto = tController.recuperarDono(tDonoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
            System.out.println("           " + tDto.getDono());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        // Removendo o dono
        System.out.println();
        System.out.println("Removendo um dono via controller");
        tDto = tController.removeDono(tDonoB.getId());
        if (tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

        System.out.println();
        System.out.println("Removendo um dono com id inválido");
        tDto = tController.removeDono(-4);
        if (!tDto.isOk())
        {
            System.out.println("OK...... : " + tDto.getMensagem());
        }
        else
        {
            System.out.println("ERRO.... : " + tDto.getMensagem());
        }

		//
		// Pos teste
		//

		// Remover o Dono
		System.out.println();
		System.out.println("Removendo");
		if (tDao.delete(tDono2a.getId()))
			System.out.println("OK...... : " + tDono2a);
		else
			System.out.println("ERRO.... : " + tDono2a);

		
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

		// Remover o tipo de Estado
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