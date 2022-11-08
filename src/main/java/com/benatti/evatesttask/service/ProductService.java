package com.benatti.evatesttask.service;

import com.benatti.evatesttask.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAllByNameFilter(String nameFilter);


}
