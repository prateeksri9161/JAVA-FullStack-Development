package com.example.modules.product.application.port.out;

import com.example.modules.product.domain.Product;

import java.util.List;

public interface GetProductPort {
    public List<Product> getAll();
}
