package co.com.hyunseda.market.product.access;

import co.com.hyunseda.market.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:productName%")
    Product findByName(@Param("productName") String productName);
}
