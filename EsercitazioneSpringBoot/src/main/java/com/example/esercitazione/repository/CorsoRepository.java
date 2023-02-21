package com.example.esercitazione.repository;

import com.example.esercitazione.domain.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}