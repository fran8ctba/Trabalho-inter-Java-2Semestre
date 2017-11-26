package br.com.vsoft.model;

public class Raca 
{
	//Atributos
	private int id;
	private String descricao;
	private int idEspecie;
	
	//Metodos de Acesso
	public Raca() 
	{
		super();
	}
	
	public Raca(int pId, String pDescricao, int pIdEspecie) 
	{
		super();
		setId(pId);
		setDescricao(pDescricao);
		setIdEspecie(pIdEspecie);
	}
	
	//Construtores
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		id = pId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String pDescricao) {
		descricao = pDescricao;
	}
	public int getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(int pIdEspecie) {
		idEspecie = pIdEspecie;
	}	
	
	
	//Metodos gerais]
	@Override
    public String toString() 
    {
    	StringBuilder tBuilder = new StringBuilder();
    	tBuilder.append("[");
    	tBuilder.append(getId());
    	tBuilder.append(", ");
    	tBuilder.append(getDescricao());
    	tBuilder.append(", ");
    	tBuilder.append(getIdEspecie());
    	tBuilder.append("]");
    	return tBuilder.toString();  	
		
	}

}
