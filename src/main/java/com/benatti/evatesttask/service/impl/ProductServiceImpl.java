package com.benatti.evatesttask.service.impl;

import com.benatti.evatesttask.model.Product;
import com.benatti.evatesttask.repository.ProductRepository;
import com.benatti.evatesttask.service.ProductService;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> findAllByNameFilter(String nameFilter) {
        Pattern pattern = Pattern.compile(nameFilter, Pattern.CASE_INSENSITIVE);
        return repository.findAll()
                .stream()
                .filter(product ->
                        pattern.matcher(product.getName())
                                .find())
                .collect(Collectors.toList());
    }
}
