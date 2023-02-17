package com.ntt.esercizio1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorUfficio extends Monitor{
    private String input;

    private Set<String> inputs = new HashSet<String>();
}
