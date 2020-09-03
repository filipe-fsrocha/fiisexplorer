package br.com.fsrocha.fiisexplorer.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    String fullname;

    String username;

    String email;

    boolean changePassword;

    public UserDto() {
    }

    public UserDto(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
    }

}
