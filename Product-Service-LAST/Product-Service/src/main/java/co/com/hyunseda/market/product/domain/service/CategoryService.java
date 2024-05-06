package co.com.hyunseda.market.product.domain.service;

import co.com.hyunseda.market.product.access.iCategoryDao;
import co.com.hyunseda.market.product.domain.entity.Category;
import co.com.hyunseda.market.product.presentation.rest.exceptions.CategoryDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.CategoryError;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService implements iCategoryService {
    /**
     * Creación de una variable con uso de ICategoryDao para hacer operaciones CRUD
     */
    @Autowired
    private iCategoryDao atrCategoryDao;


    @Override
    @Transactional(readOnly = true)/*<! Método de springframework que sincroniza con la BD*/
    public List<Category> findAll() {
        /*<! Hacer coerción de tipo al usar un método de Dao, que usa CrudRepository*/
        return (List<Category>) atrCategoryDao.findAll();
    }


    @Override
    public Category findById(Long id) throws ResourceNotFoundException {
        Category objCategory = atrCategoryDao.findById(id).orElse(null);
        if (objCategory == null) {
            throw new ResourceNotFoundException();
        }
        return null;
    }

    @Override
    public Category create(Category Category) throws CategoryDomainException {
        List<CategoryError> errors = validateDomain(Category);


        if (!errors.isEmpty()) {/*<! Si hay algún error*/
            throw new CategoryDomainException(errors);
        }

        return atrCategoryDao.save(Category);
    }

    @Override
    public Category update(Long id, Category Category) throws CategoryDomainException, ResourceNotFoundException {
        Category prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }

        List<CategoryError> errors = validateDomain(Category);

        if (!errors.isEmpty()) {
            throw new CategoryDomainException(errors);
        }

        prod.setCategoryName(Category.getCategoryName());
        prod.setCategoryId(Category.getCategoryId());

        return atrCategoryDao.save(prod);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Category prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        atrCategoryDao.deleteById(id);
    }


    /**
     * Aplica validaciones para un Categoryo. Antes de ser
     * agregado o modificado.
     *
     * @param Category Categoryo a validar
     * @return lista de errores de validación
     */
    private List<CategoryError> validateDomain(Category Category) {
        List<CategoryError> errors = new ArrayList<>();

        if (Category.getCategoryName() == null || Category.getCategoryName().isBlank()) {
            errors.add(new CategoryError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del Categoría es obligatorio"));
        }

        if (Category.getCategoryId() <= 0) {
            errors.add(new CategoryError(EnumErrorCodes.INVALID_NUMBER, "id",
                    "El Id del Categoría es obligatorio y mayor a cero"));
        }
        return errors;
    }
}