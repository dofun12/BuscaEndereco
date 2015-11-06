package org.lemanoman.buscaendereco.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lemanoman.buscaendereco.model.EnderecoModel;

public interface EnderecoService {
    public EnderecoModel save(@NotNull @Valid EnderecoModel endereco);
    public List<EnderecoModel> getList();
    public void deletar(String id);
    
}
