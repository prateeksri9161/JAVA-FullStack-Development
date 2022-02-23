package com.example.modules.product.adapter.out.persistence;

import com.example.modules.product.application.port.out.DeleteProductPort;
import com.example.modules.product.application.port.out.GetProductPort;
import com.example.modules.product.application.port.out.SaveProductPort;
import com.example.modules.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductPersistenceAdapter implements SaveProductPort, GetProductPort, DeleteProductPort {

    private ProductDao productDao;

    public ProductPersistenceAdapter(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product saveProduct(Product product) {
        System.out.println("ProductPersistenceAdapter.saveProduct");
        return productDao.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productDao.get();
    }

    @Override
    public void deleteProduct(int id) {
        System.out.println("ProductPersistenceAdapter.deleteProduct");
        productDao.delete(id);
    }
}
