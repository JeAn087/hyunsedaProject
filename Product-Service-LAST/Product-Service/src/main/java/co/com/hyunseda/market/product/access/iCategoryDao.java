package co.com.hyunseda.market.product.access;

import co.com.hyunseda.market.product.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * @brief Interfaz Dao de productos
 * @author Jeison Vallejo <jeisonvallejo@unicauca.edu.co>
 */
public interface iCategoryDao extends CrudRepository<Category,Long> {/**<!Al extender de CrudRepository, puede realizar cualquier operación CRUD*/
}