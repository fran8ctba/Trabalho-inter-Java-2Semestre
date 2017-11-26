package br.com.vsoft.dto;

import java.util.List;

import br.com.vsoft.model.Exame;


public class ExameDto{
	
    private boolean        ok;
    private String         mensagem;
    private Exame      Exame;
    private List<Exame> lista;


    public ExameDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public ExameDto(boolean pOk, String pMensagem, Exame pExame)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        Exame = pExame;
    }

    public ExameDto(boolean pOk, String pMensagem, List<Exame> pLista)
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

    public Exame getExame()
    {
        return Exame;
    }

    public void setExame(Exame pExame)
    {
        Exame = pExame;
    }

    public List<Exame> getLista()
    {
        return lista;
    }

    public void setLista(List<Exame> pLista)
    {
        lista = pLista;
    }

}
