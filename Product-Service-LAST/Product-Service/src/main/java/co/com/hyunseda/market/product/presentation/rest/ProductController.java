package co.com.hyunseda.market.product.presentation.rest;

import co.com.hyunseda.market.product.domain.entity.Product;
import co.com.hyunseda.market.product.domain.service.ProductService;
import co.com.hyunseda.market.product.domain.service.iProductService;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ProductDomainException;
import co.com.hyunseda.market.product.presentation.rest.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired/*Mirar implementaciones específicas de la interfaz*/
    private iProductService productService;

    /**
     * Listar todos
     *
     * @return listado de productos en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//Va a ser una respuesta JSON
    public List<Product> findAll() {
        return (List<Product>) productService.findAll();
    }
    /**
     * Listar un producto por nombre
     *
     * @param productName nombre del producto
     * @return Listado de productos en formato json
     * @throws Exception
     */

    @RequestMapping(value = "/name/{productName}",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody//Va a ser una respuesta JSON
    public Product findByName(@PathVariable(name = "productName") String productName) throws ResourceNotFoundException {productName.toUpperCase();
        return productService.findByName(productName);
    }

    /**
     * Listar un producto por id
     *
     * @param id identificador
     * @return Producto en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id) throws ResourceNotFoundException {
        Product product = productService.findById(id);
        return product;
    }

    /**
     * Crear un producto
     *
     * @param product producto
     * @return producto creado
     */

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) throws ProductDomainException {
        return productService.create(product);
    }

    /**
     * Editar
     *
     * @param product Producto a editar
     * @param id      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 Id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id)
            throws ProductDomainException, ResourceNotFoundException {
        return productService.update(id, product);
    }

    /**
     * Eliminar
     *
     * @param id id del producto
     * @throws ResourceNotFoundException id no encontrado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.deleteById(id);
    }

}
