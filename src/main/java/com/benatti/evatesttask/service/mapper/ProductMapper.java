package com.benatti.evatesttask.service.mapper;

import com.benatti.evatesttask.model.Product;
import com.benatti.evatesttask.model.dto.ProductRequestDto;
import com.benatti.evatesttask.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements MapperToDto<Product, ProductResponseDto>,
        MapperToModel<Product, ProductRequestDto> {
    @Override
    public ProductResponseDto mapToDto(Product model) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setDescription(model.getDescription());
        return responseDto;
    }

    @Override
    public Product matToModel(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        return product;
    }
}
