package br.com.vsoft.model;

public class HistClinico 
{	// Atributos
	private int id;
	
	//Construtores
	public HistClinico()
	{
		super();
	}
	public HistClinico(int pId)
	{
		super();
		setId(pId);	}
	
	//Metodos de Acao
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		id = pId;
	}
	
	//Metodos gerais
	@Override
	public String toString()
	{

		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append("[");
		tBuilder.append(getId());
		tBuilder.append("]");
		return tBuilder.toString();
	}
		
}
