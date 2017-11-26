package br.com.vsoft.controller;

import br.com.vsoft.dao.ExameDao;
import br.com.vsoft.dao.TipoExameDao;
import br.com.vsoft.dto.ExameDto;
import br.com.vsoft.model.Exame;
import br.com.vsoft.model.TipoExame;

public class ExameController
{
    public ExameDto cadastrarExame(Exame pExame)
    {
        // Verificar as informa��es
        if (pExame == null)
        {
            return new ExameDto(false, "Tentativa de inclus�o de exame nulo");
        }

        // Criando o objeto de persist�ncia
        ExameDao tDao = new ExameDao();
        TipoExameDao tDaoTipoExame = new TipoExameDao();
        
        // Incluindo o exame
        Exame tExame = tDao.create(pExame);
        if (tExame == null)
        {
            return new ExameDto(false, "Erro no processo de inclus�o");
        }
        
        // Validando se os identificadores existem na base de dados
        TipoExame tTipoExame = tDaoTipoExame.recovery(pExame.getIdTipoExame());
        if (tTipoExame == null)
        {
            return new ExameDto(false, "N�o existe o Tipo de Exame com o identificador informado");
        }


        // Retornando o indicativo de sucesso
        return new ExameDto(true, "Exame inclu�do com sucesso", tExame);
    }

    public ExameDto recuperarExame(int pId)
    {
        // Verificar as informa��es
        if (pId <= 0)
        {
            return new ExameDto(false, "Identificador do exame inv�lido");
        }

        // Criando o objeto de persist�ncia
        ExameDao tDao = new ExameDao();

        // Recuperando o exame
        Exame tExame = tDao.recovery(pId);
        if (tExame == null)
        {
            return new ExameDto(false, "N�o existe exame com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new ExameDto(true, "Exame recuperado com sucesso", tExame);
    }


    public ExameDto atualizarExame(Exame pExame)
    {
        // Verificar as informa��es
        if (pExame == null)
        {
            return new ExameDto(false, "Tentativa de atualiza��o de exame nulo");
        }

        // Criando o objeto de persist�ncia
        ExameDao tDao = new ExameDao();

        // Recuperando o exame
        Exame tExame = tDao.recovery(pExame.getId());
        if (tExame == null)
        {
            return new ExameDto(false, "N�o existe exame com o identificador informado");
        }

        // Atualizando o exame
        tExame = tDao.update(pExame);
        if (tExame == null)
        {
            return new ExameDto(false, "N�o existe exame com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new ExameDto(true, "Exame alterado com sucesso", tExame);
    }

    public ExameDto removeExame(int pId)
    {
        // Verificar as informa��es
        if (pId <= 0)
        {
            return new ExameDto(false, "Identificador do exame inv�lido");
        }

       
        // Criando o objeto de persist�ncia
        ExameDao tDao = new ExameDao();

        // Incluindo o exame
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new ExameDto(true, "Exame removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new ExameDto(false, "Erro no processo de remo��o");
    }
}
