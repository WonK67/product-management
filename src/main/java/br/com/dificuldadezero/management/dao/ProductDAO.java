package br.com.dificuldadezero.management.dao;

import br.com.dificuldadezero.management.dto.Product;
import br.com.dificuldadezero.management.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDAO {

    private static ProductDAO productDAO;

    private ProductDAO() {
    }

    public ProductDAO getInstance() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public Product getProduct(long id) throws Exception {
        Connection conn = ConnectionFactory.open();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE id=" + id);
        Product product = null;
        if (rs.next()) {
            product = new Product();
            //product.setId( rs.getInt("id") );
            //product.setName( rs.getString("name") );
            //product.setBilitikiwiki( rs.getString("NOO") );
            //product.setBrand( rs.getInt("age") );
        }
        rs.close();
        stmt.close();
        conn.close();
        return product;
    }
}
