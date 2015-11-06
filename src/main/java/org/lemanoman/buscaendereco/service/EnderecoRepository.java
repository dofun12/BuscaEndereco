package org.lemanoman.buscaendereco.service;

import org.lemanoman.buscaendereco.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, String> {
    
}
