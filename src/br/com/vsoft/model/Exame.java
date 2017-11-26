package br.com.vsoft.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame 
{
	//Atributos
	private int id;
	private Date   data;
	private String descricao;
	private int idTipoExame;
	private	int	   idHistClinico;

	//Metodos de Acesso
	public Exame() 
	{
		super();
	}
	
	public Exame(int pId, Date pData, String pDescricao, int pIdTipoExame,int pIdHistClinico) 
	{
		super();
		setId(pId);
		setData(pData);
		setDescricao(pDescricao);
		setIdTipoExame(pIdTipoExame);
		setIdHistClinico(pIdHistClinico);	
		
	}
	
	//Construtores
	public int getId() {
		return id;
	}
	public void setId(int pId) {
		id = pId;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date pData) {
		data = pData;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String pDescricao) {
		descricao = pDescricao;
	}
	public int getIdTipoExame() {
		return idTipoExame;
	}
	public void setIdTipoExame(int pIdTipoExame) {
		idTipoExame = pIdTipoExame;
	}	
	
	public int getIdHistClinico() {
		return idHistClinico;
	}
	public void setIdHistClinico(int pIdHistClinico) {
		idHistClinico = pIdHistClinico;
	}
	
	//Metodos gerais]
	@Override
    public String toString() 
    {
		SimpleDateFormat tFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		StringBuilder tBuilder = new StringBuilder();
    	tBuilder.append("[");
    	tBuilder.append(getId());
    	tBuilder.append(", ");
		tBuilder.append(tFormatador.format(getData()));
		tBuilder.append(",");
    	tBuilder.append(getDescricao());
    	tBuilder.append(", ");
    	tBuilder.append(getIdTipoExame());
    	tBuilder.append(",");
		tBuilder.append(getIdHistClinico());
		tBuilder.append("]");
    	return tBuilder.toString();  	
		
	}

}
