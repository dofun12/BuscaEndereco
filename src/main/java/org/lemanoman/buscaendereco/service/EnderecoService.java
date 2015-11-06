package org.lemanoman.buscaendereco.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lemanoman.buscaendereco.model.EnderecoModel;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

public interface EnderecoService {
    public EnderecoModel save(@NotNull @Valid final EnderecoModel endereco);
    public List<EnderecoModel> getList();
}
