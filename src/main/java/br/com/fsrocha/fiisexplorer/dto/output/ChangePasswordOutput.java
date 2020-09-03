package br.com.fsrocha.fiisexplorer.dto.output;

/**
 * @author Filipe Rocha
 */
public class ChangePasswordOutput {

    public ChangePasswordOutput() {
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) {
           return true;
       }
        return obj instanceof ChangePasswordOutput;
    }
}
