package br.com.fsrocha.fiisexplorer.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@UtilityClass
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Paginator {

    int DEFAULT_PAGE = 0;
    int DEFAULT_PAGE_SIZE = 10;

    public Pageable doPagination(Pagination pagination) {
        int page = DEFAULT_PAGE;
        int size = DEFAULT_PAGE_SIZE;

        if (pagination != null) {
            page = pagination.pageNumber != null ? pagination.pageNumber.intValue() : DEFAULT_PAGE;
            if (page < 0) {
                page = DEFAULT_PAGE;
            }

            size = pagination.pageSize != null ? pagination.pageSize.intValue() : DEFAULT_PAGE_SIZE;
            if (size < 1) {
                size = DEFAULT_PAGE_SIZE;
            }
        }
        return PageRequest.of(page, size);
    }
}
