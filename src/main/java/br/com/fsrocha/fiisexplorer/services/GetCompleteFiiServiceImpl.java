package br.com.fsrocha.fiisexplorer.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fsrocha.fiisexplorer.dto.CompleteFiiDto;
import br.com.fsrocha.fiisexplorer.dto.output.CompleteFiiOutput;
import br.com.fsrocha.fiisexplorer.model.FiiEntity;
import br.com.fsrocha.fiisexplorer.repositories.FiiRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetCompleteFiiServiceImpl implements GetCompleteFiiService {

    FiiRepository fiiRepository;

    ModelMapper modelMapper;

    @Override
    @Transactional
    public CompleteFiiOutput getCompleteFii(String symbol) {
        FiiEntity completeFii = fiiRepository.findCompleteFii(symbol)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Fundo %s não encontrado!", symbol)));

        return new CompleteFiiOutput(modelMapper.map(completeFii, CompleteFiiDto.class));
    }
}
