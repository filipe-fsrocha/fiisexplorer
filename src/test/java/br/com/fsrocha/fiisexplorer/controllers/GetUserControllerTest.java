package br.com.fsrocha.fiisexplorer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import br.com.fsrocha.fiisexplorer.dto.UserDto;
import br.com.fsrocha.fiisexplorer.dto.output.GetUserOutput;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import br.com.fsrocha.fiisexplorer.utils.ExceptionsAssertions;
import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;

public class GetUserControllerTest extends DatabaseTest {

    @Inject
    GetUserController controller;

    @Test
    public void testGetUser() {
        // Act
        GetUserOutput output = controller.getUser("b36200c1-bdb2-4cce-94ed-6d4a4a88514c");

        // Assert
        assertNotNull(output);
        assertEquals(output.user, user());
    }

    @Test
    public void testGetUserNotFound() {
        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.getUser("b36200c1-bdb2-4cce-94ed-6d4a4a88514a"));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.NOT_FOUND)
                .hasMessage("Usuário não encontrado");
    }

    private UserDto user() {
        UserDto dto = new UserDto();
        dto.setFullname("User Test");
        dto.setUsername("user");
        dto.setEmail("user@email.com");
        dto.setChangePassword(false);

        return dto;
    }
}
