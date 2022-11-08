package com.benatti.evatesttask.controller;

import com.benatti.evatesttask.model.Product;
import com.benatti.evatesttask.model.dto.ProductRequestDto;
import com.benatti.evatesttask.model.dto.ProductResponseDto;
import com.benatti.evatesttask.service.ProductService;
import com.benatti.evatesttask.service.mapper.ProductMapper;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ShopController(ProductService productService,
                          ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/inject") // only for tests
    public String inject() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            Product model = new Product();
            model.setName(random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
            model.setDescription(random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
            productService.save(model);
        }
        return "Done!";
    }

    @PostMapping("/product")
    public ProductResponseDto save(@RequestBody ProductRequestDto requestDto) {
        return productMapper.mapToDto(
                productService.save(
                        productMapper.matToModel(requestDto)));
    }

    @GetMapping("/product")
    public List<ProductResponseDto> getByNameFilter(@RequestParam String nameFilter) {
        return productService.findAllByNameFilter(nameFilter)
                .stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
