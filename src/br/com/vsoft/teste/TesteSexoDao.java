package br.com.vsoft.teste;

import java.util.List;

import br.com.vsoft.dao.SexoDao;
import br.com.vsoft.model.Sexo;

public class TesteSexoDao {

	public static void main(String[] pArgs) {
		// Criar um Sexo
		Sexo tSexoA = new Sexo(0, "AQUELEEEEEE");
		Sexo tSexoB = new Sexo(0, "AQUILOOOOO");

		// Criando o objeto de persistência
		SexoDao tDao = new SexoDao();

		// Incluir o Sexo
		System.out.println();
		System.out.println("Incluindo");
		Sexo tSexo2a = tDao.create(tSexoA);
		if (tSexo2a != null)
			System.out.println("OK...... : " + tSexo2a);
		else
			System.out.println("ERRO.... : " + tSexo2a);
		Sexo tSexo2b = tDao.create(tSexoB);
		if (tSexo2b != null)
			System.out.println("OK...... : " + tSexo2b);
		else
			System.out.println("ERRO.... : " + tSexo2b);

		// Recuperando o Sexo
		System.out.println();
		System.out.println("Recuperando");

		Sexo tSexo3a = tDao.recovery(tSexo2a.getId());
		if (tSexo3a != null)
			System.out.println("OK...... : " + tSexo3a);
		else
			System.out.println("ERRO.... : " + tSexo3a);
		Sexo tSexo3b = tDao.recovery(tSexo2b.getId());
		if (tSexo3b != null)
			System.out.println("OK...... : " + tSexo3b);
		else
			System.out.println("ERRO.... : " + tSexo3b);

		// Atualizando o Sexo
		System.out.println();
		System.out.println("Atualizando");
		tSexo2a.setDescricao("FEMININOOOOO");

		Sexo tSexo4a = tDao.update(tSexo2a);

		if (tSexo4a != null)
			System.out.println("OK...... : " + tSexo4a);
		else
			System.out.println("ERRO.... : " + tSexo4a);

		tSexo2b.setDescricao("MASCOLINOOOOO");
		Sexo tSexo4b = tDao.update(tSexo2b);
		if (tSexo4a != null)
			System.out.println("OK...... : " + tSexo4b);
		else
			System.out.println("ERRO.... : " + tSexo4b);

		// Recuperando o Sexo
		System.out.println();
		System.out.println("Recuperando");
		Sexo tSexo5a = tDao.recovery(tSexo2a.getId());
		if (tSexo5a != null)
			System.out.println("OK...... : " + tSexo5a);
		else
			System.out.println("ERRO.... : " + tSexo5a);
		Sexo tSexo5b = tDao.recovery(tSexo2b.getId());
		if (tSexo5b != null)
			System.out.println("OK...... : " + tSexo5b);
		else
			System.out.println("ERRO.... : " + tSexo5b);

		// Listar os Sexos
		List<Sexo> tLista = tDao.search();
		System.out.println();
		System.out.println("Pesquisando");
		for (Sexo tSexo : tLista) {
			System.out.println("OK...... : " + tSexo);
		}

		// Remover o Sexo
		System.out.println();
		System.out.println("Removendo");
		if (tDao.delete(tSexo2a.getId()))
			System.out.println("OK...... : " + tSexo2a);
		else
			System.out.println("ERRO.... : " + tSexo2a);
		if (tDao.delete(tSexo2b.getId()))
			System.out.println("OK...... : " + tSexo2b);
		else
			System.out.println("ERRO.... : " + tSexo2b);

		// Verificando se removeu
		System.out.println();
		System.out.println("Verificando a remoção");
		if (tDao.delete(tSexo2a.getId()))
			System.out.println("ERRO.... : " + tSexo2a);
		else
			System.out.println("OK...... : " + tSexo2a);
		if (tDao.delete(tSexo2b.getId()))
			System.out.println("ERRO.... : " + tSexo2b);
		else
			System.out.println("OK...... : " + tSexo2b);

	}
}