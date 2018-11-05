package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.business.LogBO;
import br.com.dificuldadezero.management.dao.ProductDAO;
import br.com.dificuldadezero.management.dto.Product;
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
        ProductDAO productDAO = ProductDAO.getInstance();
        return new ResponseEntity<>(productDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        ProductDAO dao = ProductDAO.getInstance();
        Product product = dao.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/produto")
    public ResponseEntity<Product> postProduct(@RequestBody Product product) {
        ProductDAO dao = ProductDAO.getInstance();
        LogBO logBO = LogBO.getInstance();
        dao.persist(product);
        logBO.generateInsertLog(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/produto")
    public ResponseEntity<Product> putProduct(@RequestBody Product product) {
        ProductDAO dao = ProductDAO.getInstance();
        LogBO logBO = LogBO.getInstance();
        dao.merge(product);
        logBO.generateUpdateLog(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping(value = "/produto/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        ProductDAO dao = ProductDAO.getInstance();
        LogBO logBO = LogBO.getInstance();
        dao.removeById(id);
        logBO.generateDeleteLog(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
