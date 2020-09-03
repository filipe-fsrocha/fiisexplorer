package br.com.fsrocha.fiisexplorer.dto.input;

import java.util.Objects;

import br.com.fsrocha.fiisexplorer.utils.Pagination;

/**
 * @author Filipe Rocha
 */
public class ListFiisInput {

    /**
     * Termo para buscar no campo symbol
     */
    public String search;

    /**
     * As configurações de paginação da listagem. Nâo definido, retornará os 10 primeiros resultados.
     */
    public Pagination pagination;

    public ListFiisInput() {
    }

    public ListFiisInput(String search, Pagination pagination) {
        this.search = search;
        this.pagination = pagination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListFiisInput that = (ListFiisInput) o;
        return Objects.equals(search, that.search) &&
                Objects.equals(pagination, that.pagination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(search, pagination);
    }
}
