package com.example.modules.product.adapter.out.persistence;

import com.example.modules.product.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ProductDao {
    private static List<Product> products = null;


    public ProductDao() {
        if (products == null) {
            products = new ArrayList<>();
        }
    }

    public Product add(Product product) {
        System.out.println("ProductDao.add");
        product.setId(products.size()+1);
        products.add(product);
        return product;
    }

    public List<Product> get() {
        System.out.println("ProductDao.get.products="+products);

        List<Product> result = new ArrayList<>();

        products.forEach(p-> {
            Product pResult = new Product();
            pResult.setId(p.getId());
            pResult.setCategory(p.getCategory());
            pResult.setName(p.getName());
            pResult.setPrice(p.getPrice());
            result.add(pResult);
        });
        return result;
    }

    public Optional<Product> get(int id) {
        Optional<Product> product = products.stream().filter(p->p.getId() == id).findFirst();

        return product;
    }

    public void delete(int id) {
        products.removeIf(p->p.getId() == id);
    }


}
