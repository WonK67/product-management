package br.com.dificuldadezero.management.controller;

import br.com.dificuldadezero.management.dao.LogDAO;
import br.com.dificuldadezero.management.dto.Log;
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
        LogDAO dao = LogDAO.getInstance();
        List<Log> logList = dao.findRecentLogs(id_log); //return only logs with id > id_log
        return new ResponseEntity<>(logList,HttpStatus.OK);
    }
}
