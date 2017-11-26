package br.com.vsoft.model;

import java.time.LocalDate;

public class Dono {
	
	//ID, NOME, SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE
	private int id;
	private String nome; 
	private String sexo ;
	private LocalDate dataNascimento;
	private long rg ;
	private long cpf;
	private long telefone;
	private long celular;
	private String email;
	private String senha;
	private String observacao;
	private String endereco;
	private String bairro;
	private long cep;
	private int idCidade;
	
    // Construtores
    public Dono()
    {
        super();
    }
    //ID, NOME SEXO, DATA_NASCIMENTO, RG, CPF, TELEFONE, CELULAR, EMAIL, SENHA, OBSERVACAO, ENDERECO, BAIRRO, CEP, ID_CIDADE)"
    
    public Dono(int pId, String pNome,String pSexo, LocalDate pDataNascimento,long pRg, long pCpf, long pTelefone, long pCelular,String pEmail,String pSenha,String pObserevacao, String pEndereco,String pBairro, long pCep, int pIdCidade)
    {
        super();
        setId(pId);
        setNome(pNome);
        setSexo(pSexo);
        setDataNascimento(pDataNascimento);
        setRg(pRg);
        setCpf(pCpf);
        setEmail(pEmail);
        setEmail(pSenha);
        setTelefone(pTelefone);
        setCelular(pCelular);
        setObservacao(pObserevacao);
        setEndereco(pEndereco);
        setBairro(pBairro);
        setCep(pCep);
        setIdCidade(pIdCidade);
    }
	
	//Metodos de acesso
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String pSexo) {
		sexo = pSexo;
	}
    public LocalDate getDataNascimento()
    {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate pDataNascimento)
    {
        dataNascimento = pDataNascimento;
    }

	public long getRg() {
		return rg;
	}
	public void setRg(long pRg) {
		rg = pRg;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long pCpf) {
		cpf = pCpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String pSenha) {
		senha = pSenha;
	}
	public long getTelefone() {
		return telefone;
	}
	public void setTelefone(long pTelefone) {
		 telefone = pTelefone;
	}
	public long getCelular() {
		return celular;
	}
	public void setCelular(long pCelular) {
		 celular = pCelular;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String pObservacao) {
		 observacao = pObservacao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String pEndereco) {
		 endereco = pEndereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String pBairro) {
		 bairro = pBairro;
	}
	public long getCep() {
		return cep;
	}
	public void setCep(long pCep) {
		 cep = pCep;
	}
	public int getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(int pIdCidade) {
		idCidade = pIdCidade;
	}
    
	// Métodos gerais
    @Override
    public String toString()
    {

        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(getId());
        tBuilder.append(", ");
        tBuilder.append(getIdCidade());
        tBuilder.append(", ");
        tBuilder.append(getNome());
        tBuilder.append(", ");
        tBuilder.append(getSexo());
        tBuilder.append(", ");
        tBuilder.append(getDataNascimento());
        tBuilder.append(", ");
        tBuilder.append(getRg());
        tBuilder.append(", ");
        tBuilder.append(getCpf());
        tBuilder.append(", ");
        tBuilder.append(getEmail());
        tBuilder.append(", ");
        tBuilder.append(getSenha());
        tBuilder.append(", ");
        tBuilder.append(getTelefone());
        tBuilder.append(", ");
        tBuilder.append(getCelular());
        tBuilder.append(", ");
        tBuilder.append(getObservacao());
        tBuilder.append(", ");
        tBuilder.append(getEndereco());
        tBuilder.append(", ");
        tBuilder.append(getBairro());
        tBuilder.append(", ");
        tBuilder.append(getCep());
        tBuilder.append("]");

        return tBuilder.toString();
    }
}
