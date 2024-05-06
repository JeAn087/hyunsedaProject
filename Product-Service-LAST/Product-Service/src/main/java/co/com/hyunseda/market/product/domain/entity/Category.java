package co.com.hyunseda.market.product.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data@Entity
@Table (name = "categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_Id")
    private Long categoryId;
    @Column(name="category_Name")
    private String categoryName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "productCategories")
    private List<Product> productList;
    public Category(){
        this.productList = new ArrayList<>();
    }
}
