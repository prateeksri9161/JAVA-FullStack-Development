package com.example.modules.product.application.service;


import com.example.modules.product.adapter.out.persistence.ProductDao;
import com.example.modules.product.application.port.in.CreateProductUseCase;
import com.example.modules.product.application.port.out.SaveProductPort;
import com.example.modules.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final SaveProductPort saveProductPort;

    public CreateProductService(SaveProductPort saveProductPort) {
        this.saveProductPort = saveProductPort;
    }

    @Override
    public Product create(Product product) {

        System.out.println("CreateProductService.create");
        Product newProd = saveProductPort.saveProduct(product);
        return newProd;
    }

}
