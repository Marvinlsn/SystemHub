package com.puce.CeviSystemBack.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puce.CeviSystemBack.model.entity.Plato;

@Repository
public interface PlatosRepository extends JpaRepository<Plato, Long> {
	
	@Query(value = "SELECT * FROM plato p WHERE p.nombre LIKE %?1%", nativeQuery = true)
    List<Plato> findByNombre(String nombre);
}
