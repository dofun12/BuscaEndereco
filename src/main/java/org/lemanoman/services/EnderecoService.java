package org.lemanoman.services;

import org.lemanoman.model.EnderecoModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public interface EnderecoService{
    public EnderecoModel searchByCEP(String cepSearch);
}
