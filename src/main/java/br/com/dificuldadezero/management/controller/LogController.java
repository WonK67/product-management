package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.business.LogBO;
import br.com.dificuldadezero.management.dao.LogHibernateDAO;
import br.com.dificuldadezero.management.dao.ProductHibernateDAO;
import br.com.dificuldadezero.management.dto.Log;
import br.com.dificuldadezero.management.dto.Product;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    @GetMapping(value = "/change/last_id={id_log}")
    public ResponseEntity<List<Log>> getAllChanges(@PathVariable long id_log) {
        //INITIALIZE
        LogBO filterBO = LogBO.getInstance();
        //return only log com >= id_log
        return new ResponseEntity<>(HttpStatus.OK); //change this
    }
}
