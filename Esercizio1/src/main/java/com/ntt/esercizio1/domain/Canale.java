package com.ntt.esercizio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Canale {
    private String name;
    private int numerocan;
    private boolean stato;
}
