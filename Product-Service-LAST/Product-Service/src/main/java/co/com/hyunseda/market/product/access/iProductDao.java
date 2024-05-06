package co.com.hyunseda.market.product.access;

import co.com.hyunseda.market.product.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @brief Interfaz Dao de productos
 * @author Jeison Vallejo <jeisonvallejo@unicauca.edu.co>
 */
public interface iProductDao extends CrudRepository<Product,Long> {/**<!Al extender de CrudRepository, puede realizar cualquier operación CRUD*/
}
