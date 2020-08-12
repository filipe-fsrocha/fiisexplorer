package br.com.fsrocha.fiisexplorer.services;

import org.springframework.data.domain.Pageable;

import br.com.fsrocha.fiisexplorer.dto.output.ListFiisOutput;

/**
 * @author Filipe Rocha
 */
public interface ListFiisService {

    ListFiisOutput listFiis(String symbol, Pageable pageable);
}
