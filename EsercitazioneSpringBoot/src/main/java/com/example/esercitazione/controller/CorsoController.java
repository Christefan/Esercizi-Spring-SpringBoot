package com.example.esercitazione.controller;

import com.example.esercitazione.domain.Corso;
import com.example.esercitazione.repository.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CorsoController {
    @Autowired
    CorsoRepository corsoRepository;

    @PostMapping("/")
    public ResponseEntity<Corso> create(@RequestBody Corso corso){
            Corso course1 = corsoRepository.save(corso);
            return new ResponseEntity<>(course1, HttpStatus.CREATED);
    }
    @PostMapping("/corso")
    public ResponseEntity<Corso> createCorso(@RequestBody Corso corso){
        if(corso.getNomecorso().substring(0, 6).equals("corso_") && corso.getNomecorso().length() > 7){
            Corso course1 = corsoRepository.save(corso);
            return new ResponseEntity<>(course1, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/")
    public ResponseEntity<List<Corso>> mostra(){
        List<Corso> corsoList = corsoRepository.findAll();
        System.out.println(corsoRepository.findAll().toArray().length);
        return new ResponseEntity<List<Corso>>(corsoList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>    mostratramiteid(@PathVariable long id){
        List<Corso> corsoList = corsoRepository.findAll();
        for (Corso c: corsoList) {
            if (c.getId() == id){
                return new ResponseEntity<>(c,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Valore non trovato",HttpStatus.OK);
    }


    @GetMapping("/corso")public ResponseEntity<?> findAll() {
        List<Corso> corsi = corsoRepository.findAll();
        return new ResponseEntity<>(corsi, HttpStatus.OK);
    }
    @GetMapping("/checkNumeri")public ResponseEntity<?> getNum() {
        List<Corso> lista = corsoRepository.findAll();
        int i = lista.size();
        return new ResponseEntity<>(i , HttpStatus.OK);
    }
    @GetMapping("/campi")public ResponseEntity<?> getCampi() {
        List<Corso> lista = corsoRepository.findAll();
        String campiC = null;    String sc;
        for(Corso c: lista){
            sc = c.toString();
            campiC = campiC +sc;
        }
        return new ResponseEntity<>(campiC , HttpStatus.OK);
    }
    @GetMapping("/desc")public ResponseEntity<?> getCourses() {
        List<Corso> corsi = corsoRepository.findAll();
        List<Corso> corsi1 = new ArrayList<>();
        int i=0;
        for(Corso corso: corsi){
            if(corso.getDescrizione().length() > 20){
                corsi1.add(corso);
            }
        }
        return new ResponseEntity<>(corsi1 , HttpStatus.OK);
    }
    @GetMapping("/corsi_")public ResponseEntity<?> getCourses1(){
        List<Corso> corsi = corsoRepository.findAll();
        int conta = 0;
        for(Corso c : corsi){
            if(c.getNomecorso().substring(0,6).equals("corso_")){
                conta++;
            }
        }
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCorso(@PathVariable long id, @RequestBody  Corso corso) {
        List<Corso> lista = corsoRepository.findAll();
        boolean b = false;
        for(Corso c: lista){
            if(c.getId() == corso.getId())
            {       b = true;    }
        }
        if(b) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {    Corso corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCorso(@PathVariable long id){

        corsoRepository.deleteById(id);

        return new ResponseEntity<>("Eliminato", HttpStatus.OK);
    }



}
