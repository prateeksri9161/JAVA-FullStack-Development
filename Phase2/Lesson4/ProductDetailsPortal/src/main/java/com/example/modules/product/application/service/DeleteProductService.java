package com.example.modules.product.application.service;

import com.example.modules.product.application.port.in.DeleteProductUseCase;
import com.example.modules.product.application.port.out.DeleteProductPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductService implements DeleteProductUseCase {

    private final DeleteProductPort deleteProductPort;

    public DeleteProductService(DeleteProductPort deleteProductPort) {
        this.deleteProductPort = deleteProductPort;
    }

    @Override
    public void deleteProduct(int id) {
        System.out.println("DeleteProductService.deleteProduct="+deleteProductPort);
        deleteProductPort.deleteProduct(id);
    }
}
