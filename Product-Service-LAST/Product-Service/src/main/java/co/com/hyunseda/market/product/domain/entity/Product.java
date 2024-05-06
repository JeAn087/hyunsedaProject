/**
 * @file Clase Producto
 */
package co.com.hyunseda.market.product.domain.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity
@Table(name = "products")/*<! Nombre de la tabla principal de productos*/
public class Product  implements Serializable {

    private static final long serialVersionUID = 1L;//se utiliza para garantizar la compatibilidad entre diferentes
    // versiones de la clase cuando se serializa y deserializa.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Identity es que sea unico y se debe ingresar manualmente
    @Column(name="product_Id")
    private Long productId;/*<! Id del producto, es único y obligatorio*/
    @Column(name="product_Name")
    private String productName;/*<! Nombre del producto, es obligatorio*/
    @Column(name="product_Description")
    private String productDescription;/*<! Nombre del producto, es obligatorio*/
    @Column(name="product_Price")
    private Double productPrice;/*<! Precio del producto*/
    @Column(name="product_Stock")
    private Double productStock;/*<! Cantidad del producto */
    @Column(name="product_URL")
    private String productURL; /*<! URL del producto */

    /**
     * Creación de una tabla producto_categoría, para almacenar más de una categoría por producto
     */
    @ManyToMany
    @JoinTable(name = "Product_Category",
    joinColumns = {@JoinColumn(name = "product_Id")},
    inverseJoinColumns = {@JoinColumn(name = "category_Id")})
    private List<Category> productCategories;/*<! Lista de categorías de un producto*/

}
