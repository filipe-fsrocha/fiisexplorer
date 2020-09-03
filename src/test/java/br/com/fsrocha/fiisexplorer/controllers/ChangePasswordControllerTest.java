package br.com.fsrocha.fiisexplorer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import br.com.fsrocha.fiisexplorer.dto.input.ChangePasswordInput;
import br.com.fsrocha.fiisexplorer.dto.output.ChangePasswordOutput;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import br.com.fsrocha.fiisexplorer.utils.ExceptionsAssertions;
import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;

public class ChangePasswordControllerTest extends DatabaseTest {

    @Inject
    ChangePasswordController controller;

    @Test
    public void testUpdatePassword() {
        // Assemble
        ChangePasswordInput input = new ChangePasswordInput();
        input.username = "user";
        input.currentPassword = "1234@abcA";
        input.newPassword = "12345@Abcs";

        // Act
        ChangePasswordOutput output = controller.changePassword(input);

        // Assert
        assertNotNull(output);
        assertEquals(output, new ChangePasswordOutput());
    }

    @Test
    public void testUpdatePasswordInvalidUser() {
        // Assemble
        ChangePasswordInput input = new ChangePasswordInput();
        input.username = "not_found";
        input.currentPassword = "1234@abcA";
        input.newPassword = "12345@Abcs";

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.changePassword(input));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("Usuário e/ou senha invalidos.");
    }

    @Test
    public void testUpdatePasswordInvalidCurrentPassword() {
        // Assemble
        ChangePasswordInput input = new ChangePasswordInput();
        input.username = "not_found";
        input.currentPassword = "1234@abcA";
        input.newPassword = "12345";

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.changePassword(input));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("Usuário e/ou senha invalidos.");
    }
}
