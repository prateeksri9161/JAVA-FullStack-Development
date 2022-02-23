package com.example.modules.product.application.port.in;

import com.example.modules.product.domain.Product;

public interface CreateProductUseCase {

    public Product create(Product product);

}
