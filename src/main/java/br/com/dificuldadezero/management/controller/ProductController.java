package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.dao.ProductHibernateDAO;
import br.com.dificuldadezero.management.dto.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(value = "/produto")
    public ResponseEntity<List<Product>> getAllProducts() {
        ProductHibernateDAO productDAO = ProductHibernateDAO.getInstance();
        return new ResponseEntity<>(productDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        ProductHibernateDAO dao = ProductHibernateDAO.getInstance();
        Product product = dao.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/produto")
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        ProductHibernateDAO dao = ProductHibernateDAO.getInstance();
        dao.persist(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/produto")
    public ResponseEntity<Product> putProduct(@RequestBody Product product) {
        ProductHibernateDAO dao = ProductHibernateDAO.getInstance();
        dao.merge(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/produto/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        ProductHibernateDAO dao = ProductHibernateDAO.getInstance();
        dao.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
