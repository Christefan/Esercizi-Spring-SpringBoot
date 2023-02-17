package com.ntt.esercizio1.controller;

import com.ntt.esercizio1.domain.Monitor;
import com.ntt.esercizio1.domain.MonitorUfficio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/monitorufficio")
public class ControllerMU {
    @GetMapping("/mostra")
    public ResponseEntity<MonitorUfficio> returnMonitorUfficio(){
        MonitorUfficio monitor = new MonitorUfficio();
        monitor.setColore("Rosso");
        monitor.setMarca("LG");
        monitor.setInput("Prova");
        Set<String> inputs = new HashSet<>();
        inputs.add("Ciao");
        monitor.setInputs(inputs);
        return new ResponseEntity<>(monitor, HttpStatus.OK);
    }
    @PutMapping("/modifica/{marca}")
    public ResponseEntity<?> modificaMonitorUfficio(@PathVariable String marca ,@RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = new MonitorUfficio();
        monitorUfficio1.setColore("Blu");
        monitorUfficio1.setMarca("LG");
        monitorUfficio1.setInput("Prova");
        Set<String> inputs = new HashSet<>();
        inputs.add("Ciao");
        monitorUfficio1.setInputs(inputs);
        if(monitorUfficio1.getMarca().equals(marca)){
            return new ResponseEntity<>(monitorUfficio,HttpStatus.OK);
        }
        return new ResponseEntity<>(monitorUfficio,HttpStatus.NO_CONTENT);
    }
    @PostMapping("/inserisci")
    public ResponseEntity<?> createMonitorUfficio(@RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = monitorUfficio;
        return new ResponseEntity<>(monitorUfficio1,HttpStatus.CREATED);
    }
    @DeleteMapping("/elimina/{marca}")
    public ResponseEntity<?> eliminaMonitorUfficio(@PathVariable String marca, @RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = monitorUfficio;
        System.out.println("Cancellato " + marca + " e " + monitorUfficio1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
