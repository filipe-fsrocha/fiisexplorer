package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.Objects;

import br.com.fsrocha.fiisexplorer.dto.UserDto;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserOutput {

    public UserDto user;

    public GetUserOutput(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetUserOutput output = (GetUserOutput) o;
        return Objects.equals(user, output.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
