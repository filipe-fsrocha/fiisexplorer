package br.com.fsrocha.fiisexplorer.utils;

import java.util.Objects;

import lombok.Data;

@Data
public class ListInformation {

    /**
     * Total de resultados encontrados
     */
    public long totalElements;

    /**
     * Total de páginas encontradas
     */
    public long totalPages;

    public ListInformation() {
    }

    public ListInformation(long totalElements, long totalPages) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListInformation that = (ListInformation) o;
        return totalElements == that.totalElements &&
                totalPages == that.totalPages;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalElements, totalPages);
    }
}
