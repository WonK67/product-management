package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.dao.ProductDAO;
import br.com.dificuldadezero.management.dao.ProductHibernateDAO;
import br.com.dificuldadezero.management.dto.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(value="/produtos", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        //access database and assign result to productList
        ProductHibernateDAO productDAO = ProductHibernateDAO.getInstance();
        /*Product product = new Product();
        product.setA_venda(true);
        product.setCategoria("Fantasia coala");
        product.setCondicao("novo");
        product.setDesconto(0.2);
        product.setDescricao("Vestido legal");
        String photo1 = "foto1";
        String photo2 = "foto2";
        List<String> photoList = new ArrayList<>();
        photoList.add(photo1);
        photoList.add(photo2);
        product.setFoto(photoList);
        product.setFrete("Para São Paulo, R$50,00");
        product.setId_comprador(-1);
        product.setId_vendedor(1);
        product.setMarca("Golden");
        product.setNome("Vestido de renda");
        product.setPreco(100.0);
        product.setQtde_curtidas(120);
        String tag1 = "tag1";
        String tag2 = "tag2";
        List<String> tagList = new ArrayList<>();
        tagList.add(tag1);
        tagList.add(tag2);
        product.setTags(tagList);
        product.setTamanho("P");
        productDAO.persist(product);*/
        return productDAO.findAll();
    }
    
    @RequestMapping(value="/produtos/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable long id){
        ProductHibernateDAO dao = ProductHibernateDAO.getInstance();
        return dao.getById(id);
    }
}
