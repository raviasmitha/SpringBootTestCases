package com.stackroute.SpringBootTask.controller;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.services.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MuzixController {

    MuzixService muzixService;

    @Autowired
    public MuzixController(MuzixService muzixService){
        this.muzixService = muzixService;
    }


    @PostMapping("/muzix")

    public ResponseEntity<?> saveMusix(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        muzixService.saveMusix(muzix);
        responseEntity= new ResponseEntity("Successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    /* This method will retrive musix by using Query parameter */

    @GetMapping("/muzix")

    public ResponseEntity<List<Muzix>> getMusixs() {

        List<Muzix> musixes = muzixService.getMusix();
        return new ResponseEntity<List<Muzix>>(musixes, HttpStatus.CREATED);


    }

    @GetMapping("/muzix/{id}")

    public ResponseEntity<?> getById(@PathVariable int id)  {

        Muzix muzix = null;
        muzix = muzixService.getById(id);

        return new ResponseEntity<Muzix>(muzix, HttpStatus.OK);
    }

    /*
     This method will delete data by id
     */

    @DeleteMapping("/muzix/{id}")
    public String deleteMuzix(@PathVariable int id) {
        muzixService.deleteById(id);
        return "Data deleted";
    }

    /*
    This method will update data by id
     */

    @PutMapping("/muzix/{id}")
    public ResponseEntity<Muzix> updateMusix(@RequestBody Muzix muzix, @PathVariable int id) {

        if (muzixService.updateById(muzix, id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Muzix>> getByname(@PathVariable String name) {
        List<Muzix> musix = muzixService.getBYName(name);
        return new ResponseEntity<List<Muzix>>(musix, HttpStatus.OK);
    }



}

