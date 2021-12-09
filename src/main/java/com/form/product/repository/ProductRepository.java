package com.form.product.repository;

import com.form.product.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@CrossOrigin 
@RepositoryRestResource(excerptProjection = Product.class)
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameStartingWithIgnoreCase(@Param("name") String name);

}
