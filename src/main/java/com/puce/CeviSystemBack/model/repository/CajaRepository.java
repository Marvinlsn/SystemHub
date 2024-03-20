package com.puce.CeviSystemBack.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puce.CeviSystemBack.model.entity.Caja;

@Repository
public interface CajaRepository extends JpaRepository<Caja, Long> {

}
