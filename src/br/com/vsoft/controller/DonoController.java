package br.com.vsoft.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.vsoft.dao.DonoDao;
import br.com.vsoft.dto.DonoDto;
import br.com.vsoft.model.Dono;

public class DonoController
{
    public DonoDto cadastrarDono(Dono pDono)
    {
        // Verificar as informa��es
        if (pDono == null)
        {
            return new DonoDto(false, "Tentativa de inclus�o de dono nulo");
        }

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Verificando se o dono j� existe
        Dono tDono = tDao.recoveryByCpf(pDono.getCpf());
        if (tDono != null)
        {
            return new DonoDto(false, "J� existe dono com o cpf informado");
        }

        // Incluindo o dono
        tDono = tDao.create(pDono);
        if (tDono == null)
        {
            return new DonoDto(false, "Erro no processo de inclus�o");
        }

        // Retornando o indicativo de sucesso
        return new DonoDto(true, "Dono inclu�do com sucesso", tDono);
    }

    public DonoDto recuperarDono(int pId)
    {
        // Verificar as informa��es
        if (pId <= 0)
        {
            return new DonoDto(false, "Identificador do dono inv�lido");
        }

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Recuperando o dono
        Dono tDono = tDao.recovery(pId);
        if (tDono == null)
        {
            return new DonoDto(false, "N�o existe dono com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new DonoDto(true, "Dono recuperado com sucesso", tDono);
    }

    public DonoDto recuperarDonoPorCpf(long pCpf)
    {
        // Verificar as informa��es
        if (pCpf <= 0)
        {
            return new DonoDto(false, "CPF do dono inv�lido");
        }

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Recuperando o dono
        Dono tDono = tDao.recoveryByCpf(pCpf);
        if (tDono == null)
        {
            return new DonoDto(false, "N�o existe dono com o CPF informado");
        }

        // Retornando o indicativo de sucesso
        return new DonoDto(true, "Dono recuperado com sucesso", tDono);
    }

    public DonoDto atualizarDono(Dono pDono)
    {
        // Verificar as informa��es
        if (pDono == null)
        {
            return new DonoDto(false, "Tentativa de atualiza��o de dono nulo");
        }

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Recuperando o dono
        Dono tDono = tDao.recovery(pDono.getId());
        if (tDono == null)
        {
            return new DonoDto(false, "N�o existe dono com o identificador informado");
        }

        if (pDono.getCpf() != tDono.getCpf())
        {
            // Verificando se existe um dono com o novo CPF
            tDono = tDao.recoveryByCpf(pDono.getCpf());
            if (tDono != null)
            {
                return new DonoDto(false, "J� existe dono com o cpf informado");
            }
        }

        // Atualizando o dono
        tDono = tDao.update(pDono);
        if (tDono == null)
        {
            return new DonoDto(false, "N�o existe dono com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new DonoDto(true, "Dono alterado com sucesso", tDono);
    }

    public DonoDto removeDono(int pId)
    {
        // Verificar as informa��es
        if (pId <= 0)
        {
            return new DonoDto(false, "Identificador do dono inv�lido");
        }

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Incluindo o dono
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new DonoDto(true, "Dono removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new DonoDto(false, "Erro no processo de remo��o");
    }

    public DonoDto pesquisarDonosPorNome(String pNome)
    {
        // Criando a lista de retorno
        List<Dono> tLista = new ArrayList<>();

        // Criando o objeto de persist�ncia
        DonoDao tDao = new DonoDao();

        // Recuperando o dono
        tLista = tDao.searchByNome(pNome);

        // Retornando o indicativo de sucesso
        return new DonoDto(true, "Lista de donos recuperada com sucesso", tLista);
    }
}
