package co.com.hyunseda.market.product.presentation.rest.exceptions;

import co.com.hyunseda.market.product.domain.service.EnumErrorCodes;

public class CategoryError {
    /**
     * Codigo del error
     */
    public final EnumErrorCodes code;
    /**
     * Campo del error
     */
    public final String field;
    /**
     * Descripción del error
     */
    public final String description;

    public CategoryError(EnumErrorCodes code, String field, String description) {
        this.code = code;
        this.field = field;
        this.description = description;
    }
}
