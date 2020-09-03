package br.com.fsrocha.fiisexplorer.dto.input;

import java.util.Objects;

/**
 * @author Filipe Rocha
 */
public class ChangePasswordInput {

    public String username;

    public String currentPassword;

    public String newPassword;

    public ChangePasswordInput() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangePasswordInput that = (ChangePasswordInput) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(currentPassword, that.currentPassword) &&
                Objects.equals(newPassword, that.newPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, currentPassword, newPassword);
    }
}
