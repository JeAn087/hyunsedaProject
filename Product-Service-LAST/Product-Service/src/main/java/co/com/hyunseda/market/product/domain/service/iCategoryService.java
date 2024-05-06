package co.com.hyunseda.market.product.domain.service;

import co.com.hyunseda.market.product.domain.entity.Category;
import co.com.hyunseda.market.product.presentation.rest.exceptions.CategoryDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;

import java.util.List;

public interface iCategoryService  {
    /**
     * Busca todas las categorías
     * @return Lista de categorías
     */
    public List<Category> findAll();
    /**
     * @brief
     * @param id Id del Categoría
     * @return Una Categoría, que concuerde con el ID ingresado
     * @throws ResourceNotFoundException
     */
    public Category findById(Long id) throws ResourceNotFoundException;

    /**
     * Crea una Categoría y lo inserta en la BD
     * @param Category Categoría a Crear
     * @return La Categoría creada
     * @throws CategoryDomainException
     */
    public Category create(Category Category) throws CategoryDomainException;

    /**
     * Modifica una Categoría de la BD
     * @param id Identificador de lCategoría a crear
     * @param Category Categoría con las modificaciones
     * @return Categoría después de ser actualizado en la BD
     * @throws CategoryDomainException
     * @throws ResourceNotFoundException
     */
    public Category update(Long id, Category Category) throws CategoryDomainException, ResourceNotFoundException;

    /**
     * Borra un Categoría dado un Id
     * @param id Identificador de la Categoría
     * @throws ResourceNotFoundException
     */
    public void deleteById(Long id) throws ResourceNotFoundException;

}


