package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.Objects;

/**
 * @author Filipe Rocha
 */
public class UpdateUserOutput {

    public String username;

    public UpdateUserOutput() {
    }

    public UpdateUserOutput(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserOutput that = (UpdateUserOutput) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
