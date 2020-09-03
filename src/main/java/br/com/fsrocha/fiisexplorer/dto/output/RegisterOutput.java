package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.Objects;

/**
 * @author Filipe Rocha
 */
public class RegisterOutput {

    public String email;

    public RegisterOutput() {
    }

    public RegisterOutput(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterOutput that = (RegisterOutput) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
