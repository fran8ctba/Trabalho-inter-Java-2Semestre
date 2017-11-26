package br.com.vsoft.model;

public class Estado 
  {
	private int id;	
	private String nome;
	
	//Construtores
	public Estado()
	{
		super();
	}
	
	public Estado(int pId, String pNome)
	{
		super();
		setId(pId);
		setNome(pNome);
	}
	
	//Metodos de Acesso
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		id = pId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String pNome) {
		nome = pNome;
	}

	//Metodos gerais
	@Override
	public String toString() {
		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append("[");
		tBuilder.append(getId());
		tBuilder.append(", ");
		tBuilder.append(getNome());
		tBuilder.append("]");
		return tBuilder.toString();
	}

}