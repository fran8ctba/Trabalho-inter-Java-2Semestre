package br.com.vsoft.dto;

import java.util.List;

import br.com.vsoft.model.Estado;


public class EstadoDto{
	
    private boolean        ok;
    private String         mensagem;
    private Estado      Estado;
    private List<Estado> lista;


    public EstadoDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public EstadoDto(boolean pOk, String pMensagem, Estado pEstado)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        Estado = pEstado;
    }

    public EstadoDto(boolean pOk, String pMensagem, List<Estado> pLista)
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

    public Estado getEstado()
    {
        return Estado;
    }

    public void setEstado(Estado pEstado)
    {
        Estado = pEstado;
    }

    public List<Estado> getLista()
    {
        return lista;
    }

    public void setLista(List<Estado> pLista)
    {
        lista = pLista;
    }

}
