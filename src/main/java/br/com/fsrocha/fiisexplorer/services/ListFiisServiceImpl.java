package br.com.fsrocha.fiisexplorer.services;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import java.util.Arrays;

import javax.inject.Inject;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fsrocha.fiisexplorer.dto.FiiSummaryDto;
import br.com.fsrocha.fiisexplorer.dto.output.ListFiisOutput;
import br.com.fsrocha.fiisexplorer.model.projection.FiiProjection;
import br.com.fsrocha.fiisexplorer.repositories.FiiRepository;
import br.com.fsrocha.fiisexplorer.utils.ListInformation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ListFiisServiceImpl implements ListFiisService {

    FiiRepository fiiRepository;

    ModelMapper modelMapper;

    @Override
    public ListFiisOutput listFiis(String symbol, Pageable pageable) {
        Page<FiiProjection> page;

        if (isNotBlank(symbol)) {
            page = fiiRepository.listFiis(symbol, pageable);
        } else {
            page = fiiRepository.listAllFiis(pageable);
        }

        ListFiisOutput output = new ListFiisOutput();
        output.listFiis = Arrays.asList(modelMapper.map(page.getContent(), FiiSummaryDto[].class));
        output.listInformation = modelMapper.map(page, ListInformation.class);

        return output;
    }
}
