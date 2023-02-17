package com.ntt.esercizio1.controller;

import com.ntt.esercizio1.domain.Canale;
import com.ntt.esercizio1.domain.MonitorUfficio;
import com.ntt.esercizio1.domain.Tv;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/monitorTv")
public class ControllerTv {
    @GetMapping("/mostra")
    public ResponseEntity<Tv> returnMonitorTv(){
        Tv monitortv = new Tv();
        monitortv.setId(1);
        monitortv.setColore("Rosso");
        monitortv.setMarca("LG");
        monitortv.setCanale(3);
        Canale canale1 = new Canale("Rai",1,false);
        Canale canale2 = new Canale("Rai2",2,false);
        Canale canale3 = new Canale("Rai3",3,false);
        ArrayList<Canale> canali = new ArrayList<>();
        canali.add(canale1);
        canali.add(canale2);
        canali.add(canale3);
        monitortv.setCanalitv(canali);
        return new ResponseEntity<>(monitortv, HttpStatus.OK);
    }
    @PutMapping("/modifica/{id}")
    public ResponseEntity<?> modificaMonitorTv(@PathVariable long id , @RequestBody Tv monitorTv){
        Tv monitortv1 = new Tv();
        monitortv1.setId(2);
        monitortv1.setColore("Blu");
        monitortv1.setMarca("LG");
        monitortv1.setCanale(3);
        Canale canale1 = new Canale("Rai",1,false);
        Canale canale2 = new Canale("Rai2",2,false);
        Canale canale3 = new Canale("Rai3",3,false);
        ArrayList<Canale> canali = new ArrayList<>();
        canali.add(canale1);
        canali.add(canale2);
        canali.add(canale3);
        monitortv1.setCanalitv(canali);
        if(monitortv1.getId() == id){
            return new ResponseEntity<>(monitorTv,HttpStatus.OK);
        }
        return new ResponseEntity<>(monitorTv,HttpStatus.NO_CONTENT);
    }
    @PostMapping("/inserisci")
    public ResponseEntity<?> createMonitorTv(@RequestBody Tv monitorTv){
        Tv monitorTv1 = monitorTv;
        return new ResponseEntity<>(monitorTv1,HttpStatus.CREATED);
    }
    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> eliminaMonitorTv(@PathVariable long id, @RequestBody Tv monitorTv){
        Tv monitorTv1 = monitorTv;
        System.out.println("Cancellato " + id + " e " + monitorTv1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
