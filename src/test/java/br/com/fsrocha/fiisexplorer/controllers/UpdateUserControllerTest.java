package br.com.fsrocha.fiisexplorer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import br.com.fsrocha.fiisexplorer.dto.input.UpdateUserInput;
import br.com.fsrocha.fiisexplorer.dto.output.UpdateUserOutput;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import br.com.fsrocha.fiisexplorer.utils.ExceptionsAssertions;
import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;

public class UpdateUserControllerTest extends DatabaseTest {

    @Inject
    UpdateUserController controller;

    @Test
    public void testUpdateUser() {
        // Assemble
        UpdateUserInput input = new UpdateUserInput();
        input.fullname = "Capitão América";
        input.email = "capitao@email.com";

        // Act
        UpdateUserOutput output = controller.updateUser("4e8edc68-184b-497e-a863-b11d323b83d3", input);

        // Assert
        assertNotNull(output);
        assertEquals(input.fullname, output.user.getFullname());
        assertEquals(input.email, output.user.getEmail());
    }

    @Test
    public void testUpdateUserExistingEmail() {
        // Assemble
        UpdateUserInput input = new UpdateUserInput();
        input.fullname = "Capitão América";
        input.email = "user@email.com";

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.updateUser("4e8edc68-184b-497e-a863-b11d323b83d3", input));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("Este e-mail user@email.com não está disponível.");
    }


}
