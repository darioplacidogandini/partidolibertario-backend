package com.dariogandini.partidolibertariobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dariogandini.partidolibertariobackend.model.Afiliados;

@Repository
public interface AfiliadosRepository extends JpaRepository<Afiliados, Long> {}
