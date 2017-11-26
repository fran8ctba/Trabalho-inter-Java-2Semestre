package br.com.vsoft.jsf.javabean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.vsoft.controller.DonoController;
import br.com.vsoft.dto.DonoDto;
import br.com.vsoft.model.Dono;

@ViewScoped
@ManagedBean(name = "DonoVB")

public class DonoJavaBean
{		
	
	// Atributos - Valores dos componentes visuais
	private Integer id;
	private String nome; 
	private String sexo ;
	private Date dataNascimento;
	private Long rg ;
	private Long cpf;
	private Long telefone;
	private Long celular;
	private String email;
	private String senha;
	private String observacao;
	private String endereco;
	private String bairro;
	private Long cep;
	private Integer idCidade;
    private boolean edicao;
    private String  tela;
    private List<Dono> listaDono;

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer pId) {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date pDataNascimento) {
		dataNascimento = pDataNascimento;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long pRg) {
		rg = pRg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long pCpf) {
		cpf = pCpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long pTelefone) {
		telefone = pTelefone;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long pCelular) {
		celular = pCelular;
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

	public Long getCep() {
		return cep;
	}

	public void setCep(Long pCep) {
		cep = pCep;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer pIdCidade) {
		idCidade = pIdCidade;
	}

	public boolean isEdicao() {
		return edicao;
	}

	public void setEdicao(boolean pEdicao) {
		edicao = pEdicao;
	}

	public String getTela() {
		return tela;
	}

	public void setTela(String pTela) {
		tela = pTela;
	}

	public List<Dono> getListaDono() {
		return listaDono;
	}

	public void setListaDono(List<Dono> pListaDono) {
		listaDono = pListaDono;
	}


	
    @PostConstruct
    public void init()
    {
        Dono tDono = (Dono) FacesContext.getCurrentInstance().getExternalContext()
                        .getRequestMap().get("DONO");
        if (tDono != null)
        {
            id = tDono.getId();
            email = tDono.getEmail();
            senha = tDono.getSenha();
            nome = tDono.getNome();
            dataNascimento = java.sql.Date.valueOf(tDono.getDataNascimento());
            telefone = tDono.getTelefone();
            cpf = tDono.getCpf();
            rg = tDono.getRg();
            telefone = tDono.getTelefone();
            celular = tDono.getCelular();
            sexo = tDono.getSexo();
            observacao = tDono.getObservacao();
            endereco = tDono.getEndereco();
            bairro = tDono.getBairro();
            cep = tDono.getCep();
            idCidade = tDono.getIdCidade();
            edicao = true;
        }
    }

    // Métodos da Controller
    public String limpar()
    {
        id = null;
        email = null;
        senha = null;
        nome = null;
        dataNascimento = null;
        telefone = null;
        cpf = null;
        rg = null;
        telefone = null;
        celular = null;
        sexo = null;
        observacao = null;
        endereco = null;
        bairro = null;
        cep = null;
        idCidade = null;
        edicao = false;

        return tela;
    }

    public String cadastrar()
    {
        System.out.println("DonoVB - Cadastrar : " + this);

        Dono tDono = new Dono();
        tDono.setEmail(email);
        tDono.setSenha(senha);
        tDono.setNome(nome);
        LocalDate tDataNascimento = new java.sql.Date(dataNascimento.getTime()).toLocalDate();
        tDono.setDataNascimento(tDataNascimento);
        tDono.setTelefone(telefone);
        tDono.setCelular(celular);
        tDono.setCpf(cpf);
        tDono.setRg(rg);
        tDono.setSexo(sexo);
        tDono.setObservacao(observacao);
        tDono.setEndereco(endereco);
        tDono.setBairro(bairro);
        tDono.setIdCidade(idCidade);

        DonoController tController = new DonoController();

        DonoDto tDto = tController.cadastrarDono(tDono);
        if (tDto.isOk())
        {
            // Ok, incluído
            id = tDto.getDono().getId();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
        }
        else
        {
            // Erro de inclusão

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }
        return null;
    }

    public String alterar()
    {
        System.out.println("DonoVB - Alterar : " + this);

        Dono tDono = new Dono();
        tDono.setId(id);
        tDono.setEmail(email);
        tDono.setSenha(senha);
        tDono.setNome(nome);
        LocalDate tDataNascimento = new java.sql.Date(dataNascimento.getTime()).toLocalDate();
        tDono.setDataNascimento(tDataNascimento);
        tDono.setTelefone(telefone);
        tDono.setCelular(celular);
        tDono.setCpf(cpf);
        tDono.setRg(rg);
        tDono.setSexo(sexo);
        tDono.setObservacao(observacao);
        tDono.setEndereco(endereco);
        tDono.setBairro(bairro);
        tDono.setIdCidade(idCidade);

        DonoController tController = new DonoController();

        DonoDto tDto = tController.atualizarDono(tDono);
        if (tDto.isOk())
        {
            // Ok, alterado
            id = tDto.getDono().getId();

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));
        }
        else
        {
            // Erro de alteração

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }
        return null;
    }

    public String consultar()
    {
        System.out.println("DonoVB - Consultar : " + this);

        DonoController tController = new DonoController();

        DonoDto tDto = tController.recuperarDono(id);
        if (tDto.isOk())
        {
            // Ok, recuperado
            Dono tDono = tDto.getDono();

            id = tDono.getId();
            email = tDono.getEmail();
            senha = tDono.getSenha();
            nome = tDono.getNome();
            dataNascimento = java.sql.Date.valueOf(tDono.getDataNascimento());
            telefone = tDono.getTelefone();
            cpf = tDono.getCpf();
            rg = tDono.getRg();
            telefone = tDono.getTelefone();
            celular = tDono.getCelular();
            sexo = tDono.getSexo();
            observacao = tDono.getObservacao();
            endereco = tDono.getEndereco();
            bairro = tDono.getBairro();
            cep = tDono.getCep();
            idCidade = tDono.getIdCidade();

            
            
            // indicando que a pesquisa deu certo
            edicao = true;

            // Passando o obejto para outra instância de ViewBean, se necessário
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("PACIENTE", tDono);
        }
        else
        {
            // Erro de consulta
            edicao = false;

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return tela;
    }

    public String excluir()
    {
        System.out.println("DonoVB - Excluir : " + this);

        DonoController tController = new DonoController();

        DonoDto tDto = tController.removeDono(id);
        if (tDto.isOk())
        {
            // Ok, exluido
            limpar();

            // indicando que a pesquisa deu certo
            edicao = false;

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_INFO, tDto.getMensagem(), tDto.getMensagem()));

        }
        else
        {
            // Erro de consulta
            edicao = false;

            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
    }

    public String pesquisar()
    {
        System.out.println("DonoVB - Pesquisar : " + this);

        DonoController tController = new DonoController();

        DonoDto tDto = tController.pesquisarDonosPorNome(nome);
        if (tDto.isOk())
        {
            // Ok, recuperado
            listaDono = tDto.getLista();
        }
        else
        {
            // Colocando a mensagem do sistema
            FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR, tDto.getMensagem(), tDto.getMensagem()));
        }

        return null;
    }

    // Métodos Gerais
    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("[");
        tBuilder.append(id);
        tBuilder.append(", ");
        tBuilder.append(idCidade);
        tBuilder.append(", ");
        tBuilder.append(nome);
        tBuilder.append(", ");
        tBuilder.append(sexo);
        tBuilder.append(", ");
        tBuilder.append(dataNascimento);
        tBuilder.append(", ");
        tBuilder.append(rg);
        tBuilder.append(", ");
        tBuilder.append(cpf);
        tBuilder.append(", ");
        tBuilder.append(email);
        tBuilder.append(", ");
        tBuilder.append(senha);
        tBuilder.append(", ");
        tBuilder.append(telefone);
        tBuilder.append(", ");
        tBuilder.append(celular);
        tBuilder.append(", ");
        tBuilder.append(observacao);
        tBuilder.append(", ");
        tBuilder.append(endereco);
        tBuilder.append(", ");
        tBuilder.append(bairro);
        tBuilder.append(", ");
        tBuilder.append(cep);
        tBuilder.append("]");
        return tBuilder.toString();
    }
}
