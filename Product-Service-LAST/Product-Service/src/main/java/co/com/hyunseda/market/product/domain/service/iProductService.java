package co.com.hyunseda.market.product.domain.service;

import java.util.List;
import co.com.hyunseda.market.product.domain.entity.Product;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ProductDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;


public interface iProductService  {
    /**
     * Busca todos los productos
     * @return Lista de productos
     */
    public List<Product> findAll();
    /**
     * @brief
     * @param id Id del Producto
     * @return Un producto, que concuerde con la id ingresada
     * @throws ResourceNotFoundException
     */
    public Product findById(Long id) throws ResourceNotFoundException;

    /**
     * Crea un producto y lo inserta en la BD
     * @param product Producto a Crear
     * @return El producto creado
     * @throws ProductDomainException
     */
    public Product create(Product product) throws ProductDomainException;

    /**
     * Modifica un producto de la BD
     * @param id Identificador del producto a crear
     * @param product Producto con las modificaciones
     * @return Producto después de ser actualizado en la BD
     * @throws ProductDomainException
     * @throws ResourceNotFoundException
     */
    public Product update(Long id, Product product) throws ProductDomainException, ResourceNotFoundException;

    /**
     * Borra un producto dado un Id
     * @param id Identificador del producto
     * @throws ResourceNotFoundException
     */
    public void deleteById(Long id) throws ResourceNotFoundException;
    /**
    *Encuentra un producto dado un nombre
     * @param name Es el nombre del producto
    */
    public Product findByName(String name) throws ResourceNotFoundException;
}


