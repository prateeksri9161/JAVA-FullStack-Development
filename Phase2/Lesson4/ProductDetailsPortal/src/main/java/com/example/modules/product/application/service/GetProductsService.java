package com.example.modules.product.application.service;

import com.example.modules.product.application.port.in.GetProductsUseCase;
import com.example.modules.product.application.port.out.GetProductPort;
import com.example.modules.product.domain.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements GetProductsUseCase {

    private final GetProductPort getProductPort;

    public GetProductsService(GetProductPort getProductPort) {
        this.getProductPort = getProductPort;
    }

    @Override
    public List<Product> getAll() {
        System.out.println("GetProductsService.getAll");
        return getProductPort.getAll();
    }
}
