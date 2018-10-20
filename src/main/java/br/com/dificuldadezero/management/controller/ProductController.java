package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.dto.Product;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        //access database and assign result to productList
        List productList = null;
        return productList;
    }
}
