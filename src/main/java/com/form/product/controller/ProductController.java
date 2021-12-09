package com.form.product.controller;

import com.form.product.entity.Product;
import com.form.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ProductController {

    @Autowired
    private ProductRepository itemRepository;

    @GetMapping(value = "/custom/getById/{id}")
    public Product customGetById(@PathVariable("id") long id) {
        log.info("Inicio customGetById");
        Product product = itemRepository.findById(id).orElse(null);
        log.info("Fin customGetById: ", product);
        return product;
    }

    @GetMapping(value = "/custom/findAll")
    public List<Product> customFindAll() {
        log.info("Inicio customFindAll");
        List<Product> products = (List<Product>)itemRepository.findAll();
        log.info("Fin customFindAll: ", products);
        return products;
    }
}

