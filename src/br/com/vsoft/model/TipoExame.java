package br.com.vsoft.model;

public class TipoExame
{
	//Atributos
	private int 	id;
	private String  descricao;
	
	//Metodos de acesso
	public TipoExame()
	{
		super();
	}
	
	public TipoExame(int pId, String pDescricao)
	{
		super();
		setId(pId);
		setDescricao(pDescricao);
	}
	
	//Contrutores
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
	
	//Metodos gerais
	public String toString()
	{
		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append("[");
		tBuilder.append(getId());
		tBuilder.append(",");
		tBuilder.append(getDescricao());
		tBuilder.append("]");
		return tBuilder.toString();
	}
	
}

