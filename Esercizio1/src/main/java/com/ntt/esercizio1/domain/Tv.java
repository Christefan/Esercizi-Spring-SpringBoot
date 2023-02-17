package com.ntt.esercizio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tv extends Monitor{
    private int canale;
    private long id;
    private ArrayList<Canale> canalitv = new ArrayList<Canale>();
}
