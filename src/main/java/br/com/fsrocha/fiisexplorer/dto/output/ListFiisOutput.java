package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.List;

import br.com.fsrocha.fiisexplorer.dto.FiiSummaryDto;
import br.com.fsrocha.fiisexplorer.utils.ListInformation;

/**
 * @author Filipe Roccha
 */
public class ListFiisOutput {

    /**
     * Lista com os FII's obtidos
     */
    public List<FiiSummaryDto> listFiis;

    /**
     * Informação sobre o resultado da listagem
     */
    public ListInformation listInformation;

    public ListFiisOutput() {
    }

    public ListFiisOutput(List<FiiSummaryDto> listFiis, ListInformation listInformation) {
        this.listFiis = listFiis;
        this.listInformation = listInformation;
    }

}
