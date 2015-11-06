package org.lemanoman.buscaendereco.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.lemanoman.buscaendereco.model.EnderecoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class EnderecoServiceImpl implements EnderecoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoServiceImpl.class);
    private final EnderecoRepository repository;

    @Inject
    public EnderecoServiceImpl(final EnderecoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EnderecoModel save(@NotNull @Valid final EnderecoModel endereco) {
        LOGGER.debug("Creating {}", endereco);
        return repository.save(endereco);
    }

    @Transactional(readOnly = true)
    public List<EnderecoModel> getList() {
        LOGGER.debug("Retrieving the list of all users");
        return repository.findAll();
    }

}
