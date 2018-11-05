package br.com.dificuldadezero.management.business;

import br.com.dificuldadezero.management.dao.LogHibernateDAO;
import br.com.dificuldadezero.management.dto.Product;

public class LogBO {
    
    private static LogBO instance;

    public static LogBO getInstance() {
        if (instance == null) {
            instance = new LogBO();
        }
        return instance;
    }
    
    public void generateInsertLog(Product product){

    }
    
    public void generateUpdateLog(Product product){
        
    }
    
    public void generateDeleteLog(long id_produto){
        
    }
            
}
