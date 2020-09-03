package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.Objects;

import br.com.fsrocha.fiisexplorer.dto.UserDto;

/**
 * @author Filipe Rocha
 */
public class UpdateUserOutput {

    public UserDto user;

    public UpdateUserOutput(UserDto user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserOutput output = (UpdateUserOutput) o;
        return Objects.equals(user, output.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }
}
