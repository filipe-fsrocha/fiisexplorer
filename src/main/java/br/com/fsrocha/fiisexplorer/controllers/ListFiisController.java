package br.com.fsrocha.fiisexplorer.controllers;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import javax.inject.Inject;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.input.ListFiisInput;
import br.com.fsrocha.fiisexplorer.dto.output.ListFiisOutput;
import br.com.fsrocha.fiisexplorer.services.ListFiisService;
import br.com.fsrocha.fiisexplorer.utils.Paginator;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListFiisController {

    ListFiisService listFiisService;

    @PostMapping(value = FiiExplorerConstants.LIST_FIIS)
    public ListFiisOutput listFiis(@RequestBody ListFiisInput request) {
        String search = null;

        if (isNotBlank(request.search)) {
            search = "%" + request.search.toLowerCase() + "%";
        }

        Pageable pageable = Paginator.doPagination(request.pagination);

        return listFiisService.listFiis(search, pageable);
    }
}
