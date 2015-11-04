package org.lemanoman.services;

import org.lemanoman.model.EnderecoModel;

public interface EnderecoService{
    public EnderecoModel searchByCEP(String cepSearch);
}
