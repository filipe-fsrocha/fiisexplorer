package br.com.fsrocha.fiisexplorer.utils;

import java.util.Objects;

/**
 * @author Filipe Rocha
 */
public class Pagination {

    /**
     * O número de páginas retornada. A primeira pagina corresponde ao índice 0
     */
    public Long pageNumber = 0L;

    /**
     * Quantidade de registros por página
     */
    public Long pageSize = 10L;

    public Pagination() {
    }

    public Pagination(Long pageNumber, Long pageSie) {
        this.pageNumber = pageNumber != null ? pageNumber : 0L;
        this.pageSize = pageSie != null ? pageSie : 10L;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagination that = (Pagination) o;
        return Objects.equals(pageNumber, that.pageNumber) &&
                Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize);
    }
}
