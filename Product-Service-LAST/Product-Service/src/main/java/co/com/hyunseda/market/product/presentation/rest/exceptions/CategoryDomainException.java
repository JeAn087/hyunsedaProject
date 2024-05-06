package co.com.hyunseda.market.product.presentation.rest.exceptions;

import java.util.List;

public class CategoryDomainException extends Exception {
    /**
     * Lista de errores
     */
    public final List<CategoryError> errors;

    public CategoryDomainException(List<CategoryError> errors) {
        this.errors = errors;
    }
}



