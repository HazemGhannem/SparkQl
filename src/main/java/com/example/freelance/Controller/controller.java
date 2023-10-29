package com.example.freelance.Controller;
import com.example.freelance.Entity.Contrat;
import com.example.freelance.Service.freelanceService;
import com.example.freelance.Tool.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {

    @Autowired
    private freelanceService service ;

    @GetMapping("/test")
    public ResponseEntity<?> executeSparqlQuery() {
        return new ResponseEntity<>( service.getDeliverable(), HttpStatus.OK);
    }




    @GetMapping("/sparql")
    public ResponseEntity<?> executeSparqlQuffery() {
        return new ResponseEntity<>( service.getContrat(), HttpStatus.OK);
    }

}
