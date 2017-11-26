package br.com.vsoft.teste;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.com.vsoft.dao.AnimalDao;
import br.com.vsoft.dao.CidadeDao;
import br.com.vsoft.dao.DiagnosticoDao;
import br.com.vsoft.dao.DonoDao;
import br.com.vsoft.dao.EspecieDao;
import br.com.vsoft.dao.EstadoDao;
import br.com.vsoft.dao.HistClinicoDao;
import br.com.vsoft.dao.PorteDao;
import br.com.vsoft.dao.RacaDao;
import br.com.vsoft.dao.SexoDao;
import br.com.vsoft.model.Animal;
import br.com.vsoft.model.Cidade;
import br.com.vsoft.model.Diagnostico;
import br.com.vsoft.model.Dono;
import br.com.vsoft.model.Especie;
import br.com.vsoft.model.Estado;
import br.com.vsoft.model.HistClinico;
import br.com.vsoft.model.Porte;
import br.com.vsoft.model.Raca;
import br.com.vsoft.model.Sexo;

public class TesteAnimalDao {

	private static SimpleDateFormat sFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static void main(String[] pArgs) throws ParseException {
		//
		// Pre Teste
		//
		// Criar um Estado
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

		// Criando um Dono
		Dono tDonoA = new Dono(0, "ruiva", "f", LocalDate.of(2000, 11, 29), 124567892L, 23652215896L, 41986868622L,
				4132697952L, "fran8ctbahotmail.com", "jorgina123", "ligar 2 dias antes da consulta",
				"Antonio Teixeira 450", "Rebolcas", 811256325L, tCidade2a.getId());
		Dono tDonoB = new Dono(0, "julia", "f", LocalDate.of(1999, 11, 8), 103171261L, 11908805986L, 41984568688L,
				4132569855L, "vandasilva_gmail.com", "camila1239", "ligar 2 dias antes da consulta",
				"Antonio Teixeira 450", "Rebolcas", 811256325L, tCidade2b.getId());

		// Criando o objeto de persistência
		DonoDao tDaoDono = new DonoDao();

		// Incluir o Dono
		System.out.println();
		System.out.println("Incluindo o Dono");
		Dono tDono2a = tDaoDono.create(tDonoA);
		if (tDono2a != null)
			System.out.println("OK...... : " + tDono2a);
		else
			System.out.println("ERRO.... : " + tDono2a);
		Dono tDono2b = tDaoDono.create(tDonoB);
		if (tDono2b != null)
			System.out.println("OK...... : " + tDono2b);
		else
			System.out.println("ERRO.... : " + tDono2b);

		// Criar um Porte
		Porte tPorteA = new Porte(0, "MEGA GIGANTE");
		Porte tPorteB = new Porte(0, "Super pequeno");

		// Criando o objeto de persistência
		PorteDao tDaoPorte = new PorteDao();

		// Incluir o Porte
		System.out.println();
		System.out.println("Incluindo o Porte");
		Porte tPorte2a = tDaoPorte.create(tPorteA);
		if (tPorte2a != null)
			System.out.println("OK...... : " + tPorte2a);
		else
			System.out.println("ERRO.... : " + tPorte2a);
		Porte tPorte2b = tDaoPorte.create(tPorteB);
		if (tPorte2b != null)
			System.out.println("OK...... : " + tPorte2b);
		else
			System.out.println("ERRO.... : " + tPorte2b);

		// Criar um Sexo
		Sexo tSexoA = new Sexo(0, "AQUELEEEEEE");
		Sexo tSexoB = new Sexo(0, "AQUILOOOOO");

		// Criando o objeto de persistência
		SexoDao tDaoSexo = new SexoDao();

		// Incluir o Sexo
		System.out.println();
		System.out.println("Incluindo Sexo");
		Sexo tSexo2a = tDaoSexo.create(tSexoA);
		if (tSexo2a != null)
			System.out.println("OK...... : " + tSexo2a);
		else
			System.out.println("ERRO.... : " + tSexo2a);
		Sexo tSexo2b = tDaoSexo.create(tSexoB);
		if (tSexo2b != null)
			System.out.println("OK...... : " + tSexo2b);
		else
			System.out.println("ERRO.... : " + tSexo2b);

		// Criar Especie
		Especie tEspecieA = new Especie(0, "Especie Vai Pacia");
		Especie tEspecieB = new Especie(0, "Especie Vai Cata Coquinho");

		// Criando o objeto de persistência
		EspecieDao tEspecieDao = new EspecieDao();

		// Incluir Especie
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

		// Criando um Raca
		Raca tRacaA = new Raca(0, "Vo nao", tEspecie2a.getId());
		Raca tRacaB = new Raca(0, "Vai vc", tEspecie2b.getId());

		// Criando o objeto de persistência
		RacaDao tDaoRaca = new RacaDao();

		// Incluir o Raca
		System.out.println();
		System.out.println("Incluindo o Raca");
		Raca tRaca2a = tDaoRaca.create(tRacaA);
		if (tRaca2a != null)
			System.out.println("OK...... : " + tRaca2a);
		else
			System.out.println("ERRO.... : " + tRaca2a);
		Raca tRaca2b = tDaoRaca.create(tRacaB);
		if (tRaca2b != null)
			System.out.println("OK...... : " + tRaca2b);
		else
			System.out.println("ERRO.... : " + tRaca2b);

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

		// Criando um diagnostico
		Date tData1 = sFormatador.parse("15/09/2017 18:30");
		Date tData2 = sFormatador.parse("04/10/2017 10:45");
		Diagnostico tDiagnosticoA = new Diagnostico(0, tData1, "Kg", new BigDecimal("6.000"), "Animal com infeccao",
				tHistClinico2a.getId());
		Diagnostico tDiagnosticoB = new Diagnostico(0, tData2, "Kg", new BigDecimal("15.300"), "Animal com gripe",
				tHistClinico2b.getId());
		Diagnostico tDiagnosticoC = new Diagnostico(0, tData2, "Kg", new BigDecimal("15.300"), "Animal com gripe",
				tHistClinico2b.getId());

		// Criando o objeto de persistência
		DiagnosticoDao tDaoDiagnostico = new DiagnosticoDao();

		// Incluir o Diagnostico
		System.out.println();
		System.out.println("Incluindo");
		Diagnostico tDiagnostico2a = tDaoDiagnostico.create(tDiagnosticoA);
		if (tDiagnostico2a != null)
			System.out.println("OK...... : " + tDiagnostico2a);
		else
			System.out.println("ERRO.... : " + tDiagnostico2a);
		Diagnostico tDiagnostico2b = tDaoDiagnostico.create(tDiagnosticoB);
		if (tDiagnostico2b != null)
			System.out.println("OK...... : " + tDiagnostico2b);
		else
			System.out.println("ERRO.... : " + tDiagnostico2b);
		Diagnostico tDiagnostico2c = tDaoDiagnostico.create(tDiagnosticoC);
		if (tDiagnostico2b != null)
			System.out.println("OK...... : " + tDiagnostico2c);
		else
			System.out.println("ERRO.... : " + tDiagnostico2c);

		//
		// TESTE
		//

		// problema no big decimal
		// Criando um Animal
		// int pId, String pNome, Date pDataNascimento, int pIdade, long pAnilha,
		// BigDecimal pConsumoRacao, String pPelagem, boolean pPedigee, int pIdRaca, int
		// pIdSexo, int pIdDono,int pIdHistClinico, int pIdPorteID, NOME, IDADE,
		// ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE, ID_DONO,
		// ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE
		Animal tAnimalA = new Animal(0, "Toto", LocalDate.of(2005, 6, 25), 12, 80693508L, new BigDecimal(0), "Marrom",
				"t", tDono2a.getId(), tHistClinico2a.getId(), tSexo2a.getId(), tRaca2a.getId(), tPorte2a.getId());
		Animal tAnimalB = new Animal(0, "Gilo", LocalDate.of(2016, 11, 8), 1, 12134563L, new BigDecimal(0), "Branco",
				"f", tDono2a.getId(), tHistClinico2b.getId(), tSexo2b.getId(), tRaca2b.getId(), tPorte2b.getId());

		// Criando o objeto de persistencia
		AnimalDao tDao = new AnimalDao();

		// Incluir o Animal
		System.out.println();
		System.out.println("Incluindo o Animal");
		Animal tAnimal2a = tDao.create(tAnimalA);
		if (tAnimal2a != null)
			System.out.println("OK...... : " + tAnimal2a);
		else
			System.out.println("ERRO.... : " + tAnimal2a);
		Animal tAnimal2b = tDao.create(tAnimalB);
		if (tAnimal2b != null)
			System.out.println("OK...... : " + tAnimal2b);
		else
			System.out.println("ERRO.... : " + tAnimal2b);

		// Recuperando o Animal
		System.out.println();
		System.out.println("Recuperando");

		Animal tAnimal3a = tDao.recovery(tAnimal2a.getId());
		if (tAnimal3a != null)
			System.out.println("OK...... : " + tAnimal3a);
		else
			System.out.println("ERRO.... : " + tAnimal3a);
		Animal tAnimal3b = tDao.recovery(tAnimal2b.getId());
		if (tAnimal3b != null)
			System.out.println("OK...... : " + tAnimal3b);
		else
			System.out.println("ERRO.... : " + tAnimal3b);

		// Atualizando o Animal
		// ID, NOME, IDADE, DATA_NASCIMENTO, ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE,
		// ID_DONO, ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE
		System.out.println();
		System.out.println("Atualizando");
		tAnimal2a.setNome("Marrom");
		tAnimal2a.setIdade(2);
		tAnimal2a.setDataNascimento(LocalDate.of(2015, 9, 06));
		tAnimal2a.setAnilha(2659863L);
		tAnimal2a.setConsumoRacao(new BigDecimal(0));
		tAnimal2a.setPelagem("Dourada");
		Animal tAnimal4a = tDao.update(tAnimal2a);

		if (tAnimal4a != null)
			System.out.println("OK...... : " + tAnimal4a);
		else
			System.out.println("ERRO.... : " + tAnimal4a);

		// ID, NOME, IDADE, DATA_NASCIMENTO, ANILHA,CONSUMO_RACAO, PELAGEM, PEDIGREE,
		// ID_DONO, ID_HISTCLINICO,ID_SEXO,ID_RACA,ID_PORTE
		tAnimal2b.setNome("Belinha");
		Animal tAnimal4b = tDao.update(tAnimal2b);

		if (tAnimal4a != null)
			System.out.println("OK...... : " + tAnimal4b);
		else
			System.out.println("ERRO.... : " + tAnimal4b);

		// Recuperando o Animal
		System.out.println();
		System.out.println("Recuperando");
		Animal tAnimal5a = tDao.recovery(tAnimal2a.getId());
		if (tAnimal5a != null)
			System.out.println("OK...... : " + tAnimal5a);
		else
			System.out.println("ERRO.... : " + tAnimal5a);
		Animal tAnimal5b = tDao.recovery(tAnimal2b.getId());
		if (tAnimal5b != null)
			System.out.println("OK...... : " + tAnimal5b);
		else
			System.out.println("ERRO.... : " + tAnimal5b);

		// Listar os diagnosticos
		List<Diagnostico> tLista2 = tDaoDiagnostico.pesquisaPorHistorico(tAnimal2a.getId());
		System.out.println();
		System.out.println("Pesquisando Diagnosticos");
		for (Diagnostico tDiagnostico : tLista2) {
			System.out.println("OK...... : " + tDiagnostico);

		}

		// Listar os diagnosticos
		List<Diagnostico> tLista3 = tDaoDiagnostico.pesquisaPorHistorico(tAnimal2b.getId());
		System.out.println();
		System.out.println("Pesquisando Diagnosticos");
		for (Diagnostico tDiagnostico : tLista3) {
			System.out.println("OK...... : " + tDiagnostico);

		}

		// Listar os Animals
		List<Animal> tLista = tDao.search();
		System.out.println();
		System.out.println("Pesquisando");
		for (Animal tAnimal : tLista) {
			System.out.println("OK...... : " + tAnimal);
		}

		// Remover o Animal
		System.out.println();
		System.out.println("Removendo animal");
		if (tDao.delete(tAnimal2a.getId()))
			System.out.println("OK...... : " + tAnimal2a);
		else
			System.out.println("ERRO.... : " + tAnimal2a);
		if (tDao.delete(tAnimal2b.getId()))
			System.out.println("OK...... : " + tAnimal2b);
		else
			System.out.println("ERRO.... : " + tAnimal2b);

		// Verificando se removeu
		System.out.println();
		System.out.println("Verificando a remoção");
		if (tDao.delete(tAnimal2a.getId()))
			System.out.println("ERRO.... : " + tAnimal2a);
		else
			System.out.println("OK...... : " + tAnimal2a);
		if (tDao.delete(tAnimal2b.getId()))
			System.out.println("ERRO.... : " + tAnimal2b);
		else
			System.out.println("OK...... : " + tAnimal2b);

		//
		// Pos teste
		//

		// Remover o Diagnostico
		System.out.println();
		System.out.println("Removendo Diagnostico");
		if (tDaoDiagnostico.delete(tDiagnostico2a.getId()))
			System.out.println("OK...... : " + tDiagnostico2a);
		else
			System.out.println("ERRO.... : " + tDiagnostico2a);
		if (tDaoDiagnostico.delete(tDiagnostico2b.getId()))
			System.out.println("OK...... : " + tDiagnostico2b);
		else
			System.out.println("ERRO.... : " + tDiagnostico2b);
		if (tDaoDiagnostico.delete(tDiagnostico2c.getId()))
			System.out.println("OK...... : " + tDiagnostico2b);
		else
			System.out.println("ERRO.... : " + tDiagnostico2b);

		// Remover o Raca
		System.out.println();
		System.out.println("Removendo Raca");
		if (tDaoRaca.delete(tRaca2a.getId()))
			System.out.println("OK...... : " + tRaca2a);
		else
			System.out.println("ERRO.... : " + tRaca2a);
		if (tDaoRaca.delete(tRaca2b.getId()))
			System.out.println("OK...... : " + tRaca2b);
		else
			System.out.println("ERRO.... : " + tRaca2b);

		// Remover o tipo de exame
		System.out.println("Removendo Exame");
		if (tEspecieDao.delete(tEspecie2a.getId()))
			System.out.println("OK...... : " + tEspecie2a);
		else
			System.out.println("ERRO.... : " + tEspecie2a);
		if (tEspecieDao.delete(tEspecie2b.getId()))
			System.out.println("OK...... : " + tEspecie2b);
		else
			System.out.println("ERRO.... : " + tEspecie2b);

		// Remover o Sexo
		System.out.println();
		System.out.println("Removendo Sexo");
		if (tDaoSexo.delete(tSexo2a.getId()))
			System.out.println("OK...... : " + tSexo2a);
		else
			System.out.println("ERRO.... : " + tSexo2a);
		if (tDaoSexo.delete(tSexo2b.getId()))
			System.out.println("OK...... : " + tSexo2b);
		else
			System.out.println("ERRO.... : " + tSexo2b);

		// Remover o Porte
		System.out.println();
		System.out.println("Removendo Porte");
		if (tDaoPorte.delete(tPorte2a.getId()))
			System.out.println("OK...... : " + tPorte2a);
		else
			System.out.println("ERRO.... : " + tPorte2a);
		if (tDaoPorte.delete(tPorte2b.getId()))
			System.out.println("OK...... : " + tPorte2b);
		else
			System.out.println("ERRO.... : " + tPorte2b);

		// Remover o Dono
		System.out.println();
		System.out.println("Removendo Dono");
		if (tDaoDono.delete(tDono2a.getId()))
			System.out.println("OK...... : " + tDono2a);
		else
			System.out.println("ERRO.... : " + tDono2a);
		if (tDaoDono.delete(tDono2b.getId()))
			System.out.println("OK...... : " + tDono2b);
		else
			System.out.println("ERRO.... : " + tDono2b);

		// Remover o Cidade
		System.out.println();
		System.out.println("Removendo Cidade");
		if (tCidadeDao.delete(tCidade2a.getId()))
			System.out.println("OK...... : " + tCidade2a);
		else
			System.out.println("ERRO.... : " + tCidade2a);
		if (tCidadeDao.delete(tCidade2b.getId()))
			System.out.println("OK...... : " + tCidade2b);
		else
			System.out.println("ERRO.... : " + tCidade2b);

		// Remover o tipo de Estado
		System.out.println("Removendo Estado");
		if (tEstadoDao.delete(tEstado2a.getId()))
			System.out.println("OK...... : " + tEstado2a);
		else
			System.out.println("ERRO.... : " + tEstado2a);
		if (tEstadoDao.delete(tEstado2b.getId()))
			System.out.println("OK...... : " + tEstado2b);
		else
			System.out.println("ERRO.... : " + tEstado2b);

		// Remover o HistClinico
		System.out.println();
		System.out.println("Removendo Historico Clinico");
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