package br.com.fsrocha.fiisexplorer.utils.valid;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * @author Filipe Rocha
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FieldError {

    String reason;

    Object errors;

    public FieldError() {
    }

    public FieldError(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldError that = (FieldError) o;
        return Objects.equals(reason, that.reason) &&
                Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reason, errors);
    }
}
