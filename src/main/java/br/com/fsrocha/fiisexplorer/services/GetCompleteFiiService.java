package br.com.fsrocha.fiisexplorer.services;

import br.com.fsrocha.fiisexplorer.dto.output.CompleteFiiOutput;

public interface GetCompleteFiiService {

    CompleteFiiOutput getCompleteFii(String symbol);
}
