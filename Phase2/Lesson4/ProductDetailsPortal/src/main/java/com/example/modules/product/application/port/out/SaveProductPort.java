package com.example.modules.product.application.port.out;

import com.example.modules.product.domain.Product;

public interface SaveProductPort {
    public Product saveProduct(Product product);
}
