package com.example.modules.product.application.port.in;

import com.example.modules.product.domain.Product;

import java.util.List;

public interface GetProductsUseCase {
    public List<Product>  getAll();
}
