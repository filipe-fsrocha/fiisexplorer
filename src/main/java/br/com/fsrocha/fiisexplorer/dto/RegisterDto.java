package br.com.fsrocha.fiisexplorer.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Registra um novo usuário
 *
 * @author Filipe Rocha
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {

    @NotNull @NotEmpty
    @Size(min = 5, max = 100)
    String fullname;

    @NotNull @NotEmpty
    @Size(min = 5, max = 100)
    String username;

    @NotNull @NotEmpty @Email
    String email;

    @NotNull @NotEmpty
    String password;

    public RegisterDto() {

    }

    public RegisterDto(String fullname, String username, String email, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
