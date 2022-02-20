package com.example.Raiffeisen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.Raiffeisen.service.SocksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SocksController {
    private final SocksService socksService;
    private static final Logger log = LoggerFactory.getLogger(SocksController.class);

    public SocksController(SocksService socksService) {

        this.socksService = socksService;
    }

    @GetMapping(value="/api/socks")
    public ResponseEntity<String> getCountSocks(
            @RequestParam(value = "color")  String color,
            @RequestParam(value= "operation")  String operation,
            @RequestParam(value= "cottonPart") int cottonPart ){
        if (color.equals("")){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Значение color не может быть пустым");
        }
        if (!isCorrectCottonPart(cottonPart)){
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ожидалось значение cottonPart от 0 до 100, принятое значение= "+cottonPart);
        }
        long countSocks = socksService.getPairsSocks(color,operation,cottonPart);
        return ResponseEntity.ok(String.valueOf(countSocks));
    }

    @PostMapping("/api/socks/income")
    public ResponseEntity<?> postIncomeSocks(
            @RequestParam(value = "color") String color,
            @RequestParam(value= "cottonPart")  int cottonPart,
            @RequestParam(value= "quantity")  int quantity ) {
       if (quantity<0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Значение quantity не может быть меньше 0");
         }
        if (color.equals("")){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Значение color не может быть пустым");
        }
         if (!isCorrectCottonPart(cottonPart)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ожидалось значение cottonPart от 0 до 100, принятое значение= "+cottonPart);
         }
        socksService.addSocks(color,cottonPart,quantity);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/api/socks/outcome")
    public ResponseEntity<?> postOutcomeSocks(
            @RequestParam(value = "color") String color,
            @RequestParam(value= "cottonPart") int cottonPart,
            @RequestParam(value= "quantity") int quantity ) {
        if (quantity<0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Значение quantity не может быть меньше 0");
        }
        if (color.equals("")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Значение color не может быть пустым");
        }
        if (!isCorrectCottonPart(cottonPart)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ожидалось значение cottonPart от 0 до 100, принятое значение= "+cottonPart);
        }
        socksService.outcomeSocks(color,cottonPart,quantity);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    private boolean isCorrectCottonPart(int cottonPart){
        return (cottonPart>=0)&&(cottonPart<=100);
    }
}
