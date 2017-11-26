package br.com.vsoft.controller;


import br.com.vsoft.dao.ReceituarioDao;
import br.com.vsoft.dto.ReceituarioDto;
import br.com.vsoft.model.Receituario;

public class ReceituarioController
{
    public ReceituarioDto cadastrarReceituario(Receituario pReceituario)
    {
        // Verificar as informações
        if (pReceituario == null)
        {
            return new ReceituarioDto(false, "Tentativa de inclusão de receituario nulo");
        }

        // Criando o objeto de persistência
        ReceituarioDao tDao = new ReceituarioDao();

        // Incluindo o receituario
        Receituario tReceituario = tDao.create(pReceituario);
        if (tReceituario == null)
        {
            return new ReceituarioDto(false, "Erro no processo de inclusão");
        }

        // Retornando o indicativo de sucesso
        return new ReceituarioDto(true, "Receituario incluído com sucesso", tReceituario);
    }

    public ReceituarioDto recuperarReceituario(int pId)
    {
        // Verificar as informações
        if (pId <= 0)
        {
            return new ReceituarioDto(false, "Identificador do receituario inválido");
        }

        // Criando o objeto de persistência
        ReceituarioDao tDao = new ReceituarioDao();

        // Recuperando o receituario
        Receituario tReceituario = tDao.recovery(pId);
        if (tReceituario == null)
        {
            return new ReceituarioDto(false, "Não existe receituario com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new ReceituarioDto(true, "Receituario recuperado com sucesso", tReceituario);
    }


    public ReceituarioDto atualizarReceituario(Receituario pReceituario)
    {
        // Verificar as informações
        if (pReceituario == null)
        {
            return new ReceituarioDto(false, "Tentativa de atualização de receituario nulo");
        }

        // Criando o objeto de persistência
        ReceituarioDao tDao = new ReceituarioDao();

        // Recuperando o receituario
        Receituario tReceituario = tDao.recovery(pReceituario.getId());
        if (tReceituario == null)
        {
            return new ReceituarioDto(false, "Não existe receituario com o identificador informado");
        }

        // Atualizando o receituario
        tReceituario = tDao.update(pReceituario);
        if (tReceituario == null)
        {
            return new ReceituarioDto(false, "Não existe receituario com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new ReceituarioDto(true, "Receituario alterado com sucesso", tReceituario);
    }

    public ReceituarioDto removeReceituario(int pId)
    {
        // Verificar as informações
        if (pId <= 0)
        {
            return new ReceituarioDto(false, "Identificador do receituario inválido");
        }

       
        // Criando o objeto de persistência
        ReceituarioDao tDao = new ReceituarioDao();

        // Incluindo o receituario
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new ReceituarioDto(true, "Receituario removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new ReceituarioDto(false, "Erro no processo de remoção");
    }
}
