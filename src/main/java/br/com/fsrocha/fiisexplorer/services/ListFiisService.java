package br.com.fsrocha.fiisexplorer.services;

import org.springframework.data.domain.Pageable;

import br.com.fsrocha.fiisexplorer.dto.output.ListFiisOutput;

public interface ListFiisService {

    ListFiisOutput listFiis(String symbol, Pageable pageable);
}
