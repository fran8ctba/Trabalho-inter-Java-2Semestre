package br.com.vsoft.controller;


import br.com.vsoft.dao.DiagnosticoDao;
import br.com.vsoft.dto.DiagnosticoDto;
import br.com.vsoft.model.Diagnostico;

public class DiagnosticoController
{
    public DiagnosticoDto cadastrarDiagnostico(Diagnostico pDiagnostico)
    {
        // Verificar as informações
        if (pDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Tentativa de inclusão de diagnostico nulo");
        }

        // Criando o objeto de persistência
        DiagnosticoDao tDao = new DiagnosticoDao();

        // Incluindo o diagnostico
        Diagnostico tDiagnostico = tDao.create(pDiagnostico);
        if (tDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Erro no processo de inclusão");
        }

        // Retornando o indicativo de sucesso
        return new DiagnosticoDto(true, "Diagnostico incluído com sucesso", tDiagnostico);
    }

    public DiagnosticoDto recuperarDiagnostico(int pId)
    {
        // Verificar as informações
        if (pId <= 0)
        {
            return new DiagnosticoDto(false, "Identificador do diagnostico inválido");
        }

        // Criando o objeto de persistência
        DiagnosticoDao tDao = new DiagnosticoDao();

        // Recuperando o diagnostico
        Diagnostico tDiagnostico = tDao.recovery(pId);
        if (tDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Não existe diagnostico com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new DiagnosticoDto(true, "Diagnostico recuperado com sucesso", tDiagnostico);
    }


    public DiagnosticoDto atualizarDiagnostico(Diagnostico pDiagnostico)
    {
        // Verificar as informações
        if (pDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Tentativa de atualização de diagnostico nulo");
        }

        // Criando o objeto de persistência
        DiagnosticoDao tDao = new DiagnosticoDao();

        // Recuperando o diagnostico
        Diagnostico tDiagnostico = tDao.recovery(pDiagnostico.getId());
        if (tDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Não existe diagnostico com o identificador informado");
        }

        // Atualizando o diagnostico
        tDiagnostico = tDao.update(pDiagnostico);
        if (tDiagnostico == null)
        {
            return new DiagnosticoDto(false, "Não existe diagnostico com o identificador informado");
        }

        // Retornando o indicativo de sucesso
        return new DiagnosticoDto(true, "Diagnostico alterado com sucesso", tDiagnostico);
    }

    public DiagnosticoDto removeDiagnostico(int pId)
    {
        // Verificar as informações
        if (pId <= 0)
        {
            return new DiagnosticoDto(false, "Identificador do diagnostico inválido");
        }

       
        // Criando o objeto de persistência
        DiagnosticoDao tDao = new DiagnosticoDao();

        // Incluindo o diagnostico
        if (tDao.delete(pId))
        {
            // Retornando o indicativo de sucesso
            return new DiagnosticoDto(true, "Diagnostico removido com sucesso");
        }

        // Retornando o indicativo de erro
        return new DiagnosticoDto(false, "Erro no processo de remoção");
    }
}
