package br.com.vsoft.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receituario 
{ 
	//Atributos
	private int    id;
	private Date   data;
	private String unMedida;
	private BigDecimal peso;
	private	String receitaTexto;
	private	int	   idHistClinico;
	//Contrutores
	public Receituario()
	{
		super();
	}
		
	public Receituario(int pId, Date pData, String pUnMedida,BigDecimal pPeso, String pReceitaTexto, int pIdHistClinico )	
	{
		super();
		setId(pId);
		setData(pData);
		setUnMedida(pUnMedida);
		setPeso(pPeso);
		setReceitaTexto(pReceitaTexto);
		setIdHistClinico(pIdHistClinico);	
	}
	
	//Metodos de Acesso
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
		data =pData;
	}
	public String getUnMedida() {
		return unMedida;
	}
	public void setUnMedida(String pUnMedida) {
		unMedida = pUnMedida;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public void setPeso(BigDecimal pPeso) {
		peso = pPeso;
	}
	public String getReceitaTexto() {
		return receitaTexto;
	}
	public void setReceitaTexto(String pReceitaTexto) {
		receitaTexto = pReceitaTexto;
	}

	public int getIdHistClinico() {
		return idHistClinico;
	}
	public void setIdHistClinico(int pIdHistClinico) {
		idHistClinico = pIdHistClinico;
	}

	//Metodos gerais
	@Override
	public String toString()
	{
		SimpleDateFormat tFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
			StringBuilder tBuilder = new StringBuilder();
			tBuilder.append("[");
			tBuilder.append(getId());
			tBuilder.append(",");
			tBuilder.append(getUnMedida());
			tBuilder.append(",");
			tBuilder.append(getPeso());
			tBuilder.append(",");
			tBuilder.append(tFormatador.format(getData()));
			tBuilder.append(",");
			tBuilder.append(getReceitaTexto());
			tBuilder.append(",");
			tBuilder.append(getIdHistClinico());
			tBuilder.append("]");
			return tBuilder.toString();					
	}
}
