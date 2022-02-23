package com.example.modules.product.adapter.in.web;

import com.example.modules.product.application.port.in.CreateProductUseCase;
import com.example.modules.product.application.port.in.DeleteProductUseCase;
import com.example.modules.product.application.port.in.GetProductsUseCase;
import com.example.modules.product.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private CreateProductUseCase createProductUseCase;
    private GetProductsUseCase getProductsUseCase;
    private DeleteProductUseCase deleteProductUseCase;

    public ProductController(CreateProductUseCase createProductUseCase, GetProductsUseCase getProductsUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.getProductsUseCase = getProductsUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @RequestMapping("registerProduct")
    public String showRegisterProduct(@ModelAttribute("productCommand") Product product, Model map) {
        System.out.println("showRegisterProduct:");

        return "registerProduct";
    }


    @RequestMapping("dashboard")
    public String showDashBoard(Model model) {

        List<Product> productList = getProductsUseCase.getAll();

        model.addAttribute("products", productList);

        return "dashboard";

    }

    @RequestMapping(value = "addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product, ModelMap map) {
        System.out.println("addProduct:" + product);
        map.addAttribute("product", product);
        createProductUseCase.create(product);
        return "success";
    }

    @RequestMapping("deleteProduct")  // default GET
    public String deletePProduct(@RequestParam String id) {
        System.out.println("deletePProduct");
        System.out.println("%%%% id=" + id);

        deleteProductUseCase.deleteProduct(Integer.parseInt(id));

        return "redirect:/dashboard";
    }


}
