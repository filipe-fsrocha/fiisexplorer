package br.com.fsrocha.fiisexplorer.services;

import br.com.fsrocha.fiisexplorer.dto.output.CompleteFiiOutput;

/**
 * @author Filipe Rocha
 */
public interface GetCompleteFiiService {

    CompleteFiiOutput getCompleteFii(String symbol);
}
