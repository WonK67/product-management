package br.com.dificuldadezero.management.business;

import br.com.dificuldadezero.management.dao.LogDAO;
import br.com.dificuldadezero.management.dto.Log;
import br.com.dificuldadezero.management.dto.Product;
import br.com.dificuldadezero.management.enums.ChangeType;

public class LogBO {
    
    private static LogBO instance;

    public static LogBO getInstance() {
        if (instance == null) {
            instance = new LogBO();
        }
        return instance;
    }
    
    public void generateInsertLog(Product product){
        //create log
        Log log = new Log();
        log.setCategoria_log(product.getCategoria());
        log.setId_produto(product.getId_produto());
        log.setPreco(product.getPreco());
        log.setTags_log(product.getTags());
        log.setType_log(ChangeType.INSERT);
        //get dao
        LogDAO dao = LogDAO.getInstance();
        //persist log (DB)
        dao.persist(log);
        
    }
    
    public void generateUpdateLog(Product product){
        //create log
        Log log = new Log();
        log.setCategoria_log(product.getCategoria());
        log.setId_produto(product.getId_produto());
        log.setPreco(product.getPreco());
        log.setTags_log(product.getTags());
        log.setType_log(ChangeType.UPDATE);
        //get dao
        LogDAO dao = LogDAO.getInstance();
        //persist log
        dao.persist(log);
    }
    
    public void generateDeleteLog(long id_produto){
        //create log
        Log log = new Log();
        log.setId_produto(id_produto);
        log.setType_log(ChangeType.DELETE);
        //get dao
        LogDAO dao = LogDAO.getInstance();
        //persist log
        dao.persist(log);
    }
            
}
