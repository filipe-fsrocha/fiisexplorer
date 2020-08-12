package br.com.fsrocha.fiisexplorer.dto.input;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;

/**
 * @author Filipe Rocha
 */
public class UpdateUserInput {

    /**
     * Nome completo do usuário
     */
    @NotEmpty
    public String fullname;

    /**
     * Email do usuário
     */
    @NotEmpty
    public String email;

    public UpdateUserInput() {
    }

    public UpdateUserInput(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateUserInput that = (UpdateUserInput) o;
        return Objects.equals(fullname, that.fullname) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullname, email);
    }
}

