package br.com.vsoft.dto;

import java.util.List;

import br.com.vsoft.model.Receituario;


public class ReceituarioDto{
	
    private boolean        ok;
    private String         mensagem;
    private Receituario      receituario;
    private List<Receituario> lista;


    public ReceituarioDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public ReceituarioDto(boolean pOk, String pMensagem, Receituario pReceituario)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        receituario = pReceituario;
    }

    public ReceituarioDto(boolean pOk, String pMensagem, List<Receituario> pLista)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }

    public boolean isOk()
    {
        return ok;
    }

    public void setOk(boolean pOk)
    {
        ok = pOk;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String pMensagem)
    {
        mensagem = pMensagem;
    }

    public Receituario getReceituario()
    {
        return receituario;
    }

    public void setReceituario(Receituario pReceituario)
    {
        receituario = pReceituario;
    }

    public List<Receituario> getLista()
    {
        return lista;
    }

    public void setLista(List<Receituario> pLista)
    {
        lista = pLista;
    }

}
