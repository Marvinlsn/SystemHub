package com.puce.CeviSystemBack.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puce.CeviSystemBack.model.entity.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
