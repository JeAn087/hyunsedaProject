package co.com.hyunseda.market.product.presentation.rest;

import co.com.hyunseda.market.product.domain.entity.Category;
import co.com.hyunseda.market.product.domain.service.iCategoryService;
import co.com.hyunseda.market.product.presentation.rest.exceptions.CategoryDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
   @Autowired
    private iCategoryService CategoryService;

    /**
     * Listar todos
     *
     * @return listado de Categorías en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//Va a ser una respuesta JSON
    public List<Category> findAll() {
        return (List<Category>) CategoryService.findAll();
    }

    /**
     * Listar una Categoría por id
     *
     * @param id identificador
     * @return Categoría en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id) throws ResourceNotFoundException {

        Category Category = CategoryService.findById(id);
        return Category;
    }

    /**
     * Crear una Categoría
     *
     * @param Category Categoría
     * @return Categoría creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category Category) throws CategoryDomainException {
        return CategoryService.create(Category);
    }

    /**
     * Editar
     *
     * @param Category Categoría a editar
     * @param id      identificador del Categoría
     * @return Categoría editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category Category, @PathVariable Long id)
            throws CategoryDomainException, ResourceNotFoundException {
        return CategoryService.update(id, Category);
    }

    /**
     * Eliminar
     *
     * @param id id de la Categoría
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        CategoryService.deleteById(id);
    }

}
