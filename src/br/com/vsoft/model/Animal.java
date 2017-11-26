package br.com.vsoft.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Animal 
{   // Atributos
	private int  		id;
	private String 		nome;
	private LocalDate	dataNascimento;	
	private int			idade;
	private long		anilha;
	private BigDecimal	consumoRacao;
	private String  	pelagem;
	private String 	pedigee;
	private int 		idDono;
	private int 		idHistClinico;
	private int 		idSexo;
	private	int			idRaca;
	private int 		idPorte;
	
	// Construtores
    public Animal()
    {
        super();
    }

    public Animal(int pId, String pNome, LocalDate pDataNascimento, int pIdade, long pAnilha, BigDecimal	pConsumoRacao, String pPelagem, String pPedigee, int pIdRaca, int pIdSexo, int pIdDono,int pIdHistClinico, int pIdPorte)
    {
        super();
        setId(pId);
        setNome(pNome);
        setDataNascimento(pDataNascimento);
        setIdade(pIdade);
        setAnilha(pAnilha);
        setConsumoRacao(pConsumoRacao);
        setPelagem(pPelagem);
        setPedigee(pPedigee);
        setIdDono(pIdDono);
        setIdHistClinico(pIdHistClinico);
        setIdSexo(pIdSexo);
        setIdRaca(pIdRaca);
        setIdPorte(pIdPorte);
        
    }
    
 // Métodos de acesso
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
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate pDataNascimento) {
		dataNascimento = pDataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int pIdade) {
		idade = pIdade;
	}
	public long getAnilha() {
		return anilha;
	}
	public void setAnilha(long pAnilha) {
		anilha = pAnilha;
	}
	public BigDecimal getConsumoRacao() {
		return consumoRacao;
	}
	public void setConsumoRacao(BigDecimal pConsumoRacao) {
		consumoRacao = pConsumoRacao;
	}
	public String getPelagem() {
		return pelagem;
	}
	public void setPelagem(String pPelagem) {
		pelagem = pPelagem;
	}
	public String getPedigee() {
		return pedigee;
	}
	public void setPedigee(String pPedigee) {
		pedigee = pPedigee;
	}
	public int getIdDono() {
		return idDono;
	}
	public void setIdDono(int pIdDono) {
		idDono = pIdDono;
	}
	public int getIdHistClinico() {
		return idHistClinico;
	}
	public void setIdHistClinico(int pIdHistClinico) {
		idHistClinico = pIdHistClinico;
	}
	public int getIdSexo() {
		return idSexo;
	}
	public void setIdSexo(int pIdSexo) {
		idSexo = pIdSexo;
	}
	public int getIdRaca() {
		return idRaca;
	}
	public void setIdRaca(int pIdRaca) {
		idRaca = pIdRaca;
	}
	public int getIdPorte() {
		return idPorte;
	}
	public void setIdPorte(int pIdPorte) {
		idPorte = pIdPorte;
	}
	
	// Métodos gerais
    @Override
    public String toString()
    {
      
        StringBuilder tBuilder = new StringBuilder();
        
        tBuilder.append(getId());
        tBuilder.append("[");
        tBuilder.append(getNome());
        tBuilder.append(",");       
        tBuilder.append(getDataNascimento());
        tBuilder.append(",");       
        tBuilder.append(getIdade());
        tBuilder.append(",");
        tBuilder.append(getAnilha());
        tBuilder.append(",");
        tBuilder.append(getConsumoRacao());
        tBuilder.append(",");
        tBuilder.append(getPelagem());
        tBuilder.append(",");
        tBuilder.append(getPedigee());
        tBuilder.append(",");        
        tBuilder.append(getIdHistClinico());
        tBuilder.append(",");
        tBuilder.append(getIdSexo());
        tBuilder.append(",");
        tBuilder.append(getIdRaca());
        tBuilder.append(",");
        tBuilder.append(getIdPorte());
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
