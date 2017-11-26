package br.com.vsoft.dto;

import java.util.List;

import br.com.vsoft.model.Diagnostico;


public class DiagnosticoDto{
	
    private boolean        ok;
    private String         mensagem;
    private Diagnostico      diagnostico;
    private List<Diagnostico> lista;


    public DiagnosticoDto(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public DiagnosticoDto(boolean pOk, String pMensagem, Diagnostico pDiagnostico)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        diagnostico = pDiagnostico;
    }

    public DiagnosticoDto(boolean pOk, String pMensagem, List<Diagnostico> pLista)
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

    public Diagnostico getDiagnostico()
    {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico pDiagnostico)
    {
        diagnostico = pDiagnostico;
    }

    public List<Diagnostico> getLista()
    {
        return lista;
    }

    public void setLista(List<Diagnostico> pLista)
    {
        lista = pLista;
    }

}
