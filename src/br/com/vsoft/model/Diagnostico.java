package br.com.vsoft.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diagnostico 
{ 	
	//Atributos	
	private int    id;
	private Date   data;
	private String unMedida;
	private BigDecimal peso;
	private String diagnosticoTexto;
	private	int	   idHistClinico;

	//Metodos de acesso
	public Diagnostico() 
	{
		super();
	}
	public Diagnostico(int pId, Date pData, String pUnMedida, BigDecimal pPeso, String pDiagnosticoTexto, int pIdHistClinico) 
	{
		super();
		setId(pId);
		setData(pData);
		setUnMedida(pUnMedida);
		setPeso(pPeso);
		setDiagnosticoTexto(pDiagnosticoTexto);
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
	public String getDiagnosticoTexto() {
		return diagnosticoTexto;
	}
	public void setDiagnosticoTexto(String pDiagnosticoTexto) {
		diagnosticoTexto = pDiagnosticoTexto;
	}
	
	public int getIdHistClinico() {
		return idHistClinico;
	}
	public void setIdHistClinico(int pIdHistClinico) {
		idHistClinico = pIdHistClinico;
	}

	//Metodos gerais
	public String toString()
	{
		SimpleDateFormat tFormatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append("[");
		tBuilder.append(getId());
		tBuilder.append(",");
		tBuilder.append(tFormatador.format(getData()));
		tBuilder.append(",");
		tBuilder.append(getUnMedida());
		tBuilder.append(",");
		tBuilder.append(getPeso());
		tBuilder.append(",");
		tBuilder.append(getDiagnosticoTexto());
		tBuilder.append(",");
		tBuilder.append(getIdHistClinico());
		tBuilder.append("]");
		
		return tBuilder.toString();
		
	}
}