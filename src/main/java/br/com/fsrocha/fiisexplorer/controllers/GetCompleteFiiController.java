package br.com.fsrocha.fiisexplorer.controllers;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fsrocha.fiisexplorer.configuration.FiiExplorerConstants;
import br.com.fsrocha.fiisexplorer.dto.output.CompleteFiiOutput;
import br.com.fsrocha.fiisexplorer.repositories.FiiRepository;
import br.com.fsrocha.fiisexplorer.services.GetCompleteFiiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetCompleteFiiController {

    GetCompleteFiiService completeFiiService;

    FiiRepository fiiRepository;

    @GetMapping(value = FiiExplorerConstants.GET_COMPLETE_FII)
    public CompleteFiiOutput getCompleteFii(@PathVariable String symbol) {
        return completeFiiService.getCompleteFii(symbol);
    }
}
