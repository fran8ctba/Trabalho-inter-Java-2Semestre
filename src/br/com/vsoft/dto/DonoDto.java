package br.com.vsoft.dto;

import java.util.List;
import br.com.vsoft.model.Dono;


public class DonoDto{
	
    private boolean        ok;
    private String         mensagem;
    private Dono      dono;
    private List<Dono> lista;


    public DonoDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public DonoDto(boolean pOk, String pMensagem, Dono pDono)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        dono = pDono;
    }

    public DonoDto(boolean pOk, String pMensagem, List<Dono> pLista)
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

    public Dono getDono()
    {
        return dono;
    }

    public void setDono(Dono pDono)
    {
        dono = pDono;
    }

    public List<Dono> getLista()
    {
        return lista;
    }

    public void setLista(List<Dono> pLista)
    {
        lista = pLista;
    }

}
