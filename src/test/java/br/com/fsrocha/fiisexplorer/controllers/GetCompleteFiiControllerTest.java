package br.com.fsrocha.fiisexplorer.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import br.com.fsrocha.fiisexplorer.dto.output.CompleteFiiOutput;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetCompleteFiiControllerTest extends DatabaseTest {

    @Inject
    GetCompleteFiiController controller;

    @Test
    public void testGetCompleteFii() {
        // Assemble
        String symbol = "abcp11";

        // Act
        CompleteFiiOutput output = controller.getCompleteFii(symbol);

        // Assert
        assertNotNull(output);
    }

    @Test
    public void testCompleteFii_NotFound() {
        // Assemble
        String symbol = "not_found";

        // Act
        final Throwable throwable = Assertions.catchThrowable(() -> controller.getCompleteFii(symbol));

        // Assert
        assertThat(throwable)
                .hasMessage("404 NOT_FOUND \"Fundo not_found não encontrado!\"");
    }

}