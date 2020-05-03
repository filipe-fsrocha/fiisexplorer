package br.com.fsrocha.fiisexplorer.dto.output;

import java.util.Objects;

import br.com.fsrocha.fiisexplorer.dto.CompleteFiiDto;

public class CompleteFiiOutput {

    /**
     * Todas as informações completas do FII (Fundo de Investimentos Imbiliários)
     */
    public CompleteFiiDto completeFii;

    public CompleteFiiOutput() {
    }

    public CompleteFiiOutput(CompleteFiiDto completeFii) {
        this.completeFii = completeFii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompleteFiiOutput that = (CompleteFiiOutput) o;
        return Objects.equals(completeFii, that.completeFii);
    }

    @Override
    public int hashCode() {
        return Objects.hash(completeFii);
    }
}
