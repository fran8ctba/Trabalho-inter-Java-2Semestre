package br.com.vsoft.dto;

import java.util.List;

import br.com.vsoft.model.TipoExame;


public class TipoExameDto{
	
    private boolean        ok;
    private String         mensagem;
    private TipoExame      tipoExame;
    private List<TipoExame> lista;


    public TipoExameDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public TipoExameDto(boolean pOk, String pMensagem, TipoExame pTipoExame)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        tipoExame = pTipoExame;
    }

    public TipoExameDto(boolean pOk, String pMensagem, List<TipoExame> pLista)
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

    public TipoExame getTipoExame()
    {
        return tipoExame;
    }

    public void setTipoExame(TipoExame pTipoExame)
    {
        tipoExame = pTipoExame;
    }

    public List<TipoExame> getLista()
    {
        return lista;
    }

    public void setLista(List<TipoExame> pLista)
    {
        lista = pLista;
    }

}
