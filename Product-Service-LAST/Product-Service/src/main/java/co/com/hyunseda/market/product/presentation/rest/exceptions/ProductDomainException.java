package co.com.hyunseda.market.product.presentation.rest.exceptions;

import java.util.List;

public class ProductDomainException extends Exception {
    /**
     * Lista de errores
     */
    public final List<ProductError> errors;

    public ProductDomainException(List<ProductError> errors) {
        this.errors = errors;
    }
}
