package br.com.fsrocha.fiisexplorer.controllers;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;

import org.junit.Test;

import br.com.fsrocha.fiisexplorer.dto.FiiSummaryDto;
import br.com.fsrocha.fiisexplorer.dto.input.ListFiisInput;
import br.com.fsrocha.fiisexplorer.dto.output.ListFiisOutput;
import br.com.fsrocha.fiisexplorer.repositories.FiiRepository;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import br.com.fsrocha.fiisexplorer.utils.Pagination;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListFiisControllerTest extends DatabaseTest {

    static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    static final String DATE_2020_4_26_16_13_27 = "2020-04-26 16:13:27";

    @Inject
    FiiRepository repository;

    @Inject
    ListFiisController controller;

    @Test
    public void testListFiis() {
        // Assemble
        ListFiisInput input = new ListFiisInput("", new Pagination(0L, 10L));

        // Act
        ListFiisOutput output = controller.listFiis(input);

        // Assert
        assertEquals(3, output.listFiis.size());
        assertEquals(3L, output.listInformation.totalElements);
        assertEquals(1L, output.listInformation.totalPages);
        assertThat(output.listFiis, containsInAnyOrder(
                new FiiSummaryDto("ABCP11", "Rio Bravo", LocalDateTime.parse(DATE_2020_4_26_16_13_27, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))),
                new FiiSummaryDto("ALMI11", "BTG Pactual", LocalDateTime.parse(DATE_2020_4_26_16_13_27, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT))),
                new FiiSummaryDto("ALZR11", "BTG Pactual", LocalDateTime.parse(DATE_2020_4_26_16_13_27, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
        ));
    }

    @Test
    public void testListFiis_Search() {
        // Assemble
        ListFiisInput input = new ListFiisInput("ALZR11", new Pagination(0L, 10L));

        // Act
        ListFiisOutput output = controller.listFiis(input);

        // Assert
        assertEquals(1, output.listFiis.size());
        assertEquals(1L, output.listInformation.totalPages);
        assertEquals(1L, output.listInformation.totalPages);
        assertThat(output.listFiis, containsInAnyOrder(
                new FiiSummaryDto("ALZR11", "BTG Pactual", LocalDateTime.parse(DATE_2020_4_26_16_13_27, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)))
        ));
    }

    @Test
    public void testListFiis_Empty() {
        // Assemble
        ListFiisInput input = new ListFiisInput("Empty", new Pagination(0L, 10L));

        // Act
        ListFiisOutput output = controller.listFiis(input);

        // Assert
        assertEquals(0, output.listFiis.size());
    }
}
