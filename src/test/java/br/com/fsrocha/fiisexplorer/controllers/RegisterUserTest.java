package br.com.fsrocha.fiisexplorer.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import br.com.fsrocha.fiisexplorer.dto.RegisterDto;
import br.com.fsrocha.fiisexplorer.dto.output.RegisterOutput;
import br.com.fsrocha.fiisexplorer.utils.DatabaseTest;
import br.com.fsrocha.fiisexplorer.utils.ExceptionsAssertions;
import br.com.fsrocha.fiisexplorer.utils.exception.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterUserTest extends DatabaseTest {

    @Inject
    RegisterUserController controller;

    @Test
    public void testRegisterUser() {
        // Assemble
        RegisterDto dto = registerDto("user", "user@email.com", "123@Abc123");

        // Act
        RegisterOutput output = controller.registerUser(dto);

        // Assert
        assertNotNull(output);
        assertEquals(dto.getEmail(), output.email);
    }

    @Test
    public void testRegisterUserInvalidPassword() {
        // Assemble
        RegisterDto dto = registerDto("user", "user@email.com", "bc123");

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.registerUser(dto));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("A senha não atende os requisitos de complexidade!");
    }

    @Test
    public void testRegisterUserDuplicatedUsername() {
        // Assemble
        RegisterDto dto = registerDto("joao.silva", "user@email.com", "123@Abc123");

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.registerUser(dto));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("Este usuário joao.silva não está disponível.");
    }

    @Test
    public void testRegisterUserDuplicatedEmail() {
        // Assemble
        RegisterDto dto = registerDto("user2", "joao.silva@email.com", "123@Abc123");

        // Act
        ServiceException exception = ExceptionsAssertions.catchThrowableServiceException(() -> controller.registerUser(dto));

        // Assert
        ExceptionsAssertions.assertThat(exception).hasCategory(HttpStatus.BAD_REQUEST)
                .hasMessage("Este e-mail joao.silva@email.com não está disponível.");
    }

    private RegisterDto registerDto(String username, String email, String password) {
        RegisterDto entity = new RegisterDto();
        entity.setFullname("Test User");
        entity.setUsername(username);
        entity.setEmail(email);
        entity.setPassword(password);

        return entity;
    }
}
