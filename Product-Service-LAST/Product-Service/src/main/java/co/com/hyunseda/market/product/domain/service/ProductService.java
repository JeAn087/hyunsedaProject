/**
 * @file Clase que tiene la implementación de la Interfaz del servicio de producto
 * @author Jeison Andrés Vallejo Gómez <jeisonvallejo@unicauca.edu.co>
 */

package co.com.hyunseda.market.product.domain.service;

import co.com.hyunseda.market.product.access.IProductRepository;
import co.com.hyunseda.market.product.access.iProductDao;
import co.com.hyunseda.market.product.domain.entity.Product;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ProductDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ProductError;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService implements iProductService{

    /**
     * Creación de una variable con uso de IProductDao para hacer operaciones CRUD
     */
    @Autowired
    private iProductDao atrProductDao;
    @Autowired
    private IProductRepository atrRepository;

    @Override
    @Transactional(readOnly = true)/*<! Método de springframework que sincroniza con la BD*/
    public List<Product> findAll() {
        /*<! Hacer coerción de tipo al usar un método de Dao, que usa CrudRepository*/
        return (List<Product>) atrProductDao.findAll();
    }


    public Product findByName(String name) throws ResourceNotFoundException  {
        Product objProduct = atrRepository.findByName(name);
        if(objProduct == null){throw new ResourceNotFoundException();}
        return objProduct;
    }

    @Override
    public Product findById(Long id) throws ResourceNotFoundException {
        Product objProduct = atrProductDao.findById(id).orElse(null);
        if (objProduct == null) {
            throw new ResourceNotFoundException();
        }
        return objProduct;
    }

    @Override
    public Product create(Product product) throws ProductDomainException {
        List<ProductError> errors = validateDomain(product);


        if (!errors.isEmpty()) {/*<! Si hay algún error*/
            throw new ProductDomainException(errors);
        }

        return atrProductDao.save(product);
    }

    @Override
    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }

        List<ProductError> errors = validateDomain(product);

        if (!errors.isEmpty()) {
            throw new ProductDomainException(errors);
        }

        prod.setProductName(product.getProductName());
        prod.setProductPrice(product.getProductPrice());

        return atrProductDao.save(prod);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        Product prod = this.findById(id);
        if (prod == null) {
            throw new ResourceNotFoundException();
        }
        atrProductDao.deleteById(id);
    }

    /**
     * Aplica validaciones para un producto. Antes de ser
     * agregado o modificado.
     *
     * @param product producto a validar
     * @return lista de errores de validación
     */
    private List<ProductError> validateDomain(Product product) {
        List<ProductError> errors = new ArrayList<>();

        if (product.getProductName() == null || product.getProductName().isBlank()) {
            errors.add(new ProductError(EnumErrorCodes.EMPTY_FIELD, "name", "El nombre del producto es obligatorio"));
        }

        if (product.getProductPrice() <= 0) {
            errors.add(new ProductError(EnumErrorCodes.INVALID_NUMBER, "price",
                    "El precio del producto es obligatorio y mayor a cero"));
        }
        return errors;
    }

}
