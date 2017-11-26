package br.com.vsoft.model;

public class Cidade 
{

	private int id ;
	private String nome;
	private int idEstado;
	
	//Contrutores 
	public Cidade() 
	{
		super();
	}
	
	public Cidade(int pId, String pNome, int pIdEstado) 
	{
		super();
		setId(pId);
		setNome(pNome);
		setIdEstado(pIdEstado);
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
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int pIdEstado) {
		idEstado = pIdEstado;
	}
	
	//Metodos Gerais
	@Override
	public String toString() {
		StringBuilder tBuilder = new StringBuilder();
		tBuilder.append("[");
		tBuilder.append(getId());
		tBuilder.append(", ");
		tBuilder.append(getNome());
		tBuilder.append(", ");
		tBuilder.append(getIdEstado());
		tBuilder.append("]");
		return tBuilder.toString();
	}
}
