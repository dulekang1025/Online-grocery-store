package com.pika.Onlinegrocerystore.Controller;

import com.pika.Onlinegrocerystore.Services.ManagerService;
import com.pika.Onlinegrocerystore.Services.ProductService;
import com.pika.Onlinegrocerystore.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/products")
@RestController
public class managerController {

    private ManagerService managerService;

    private ProductService productService;

    public managerController(ManagerService managerService, ProductService productService) {
        this.productService = productService;
        this.managerService = managerService;
    }

    @RequestMapping("findAll")
    @ResponseBody
    public List<Product> getAllProducts(){
        System.out.println("Here.");
        return productService.findAll();
    }

}
