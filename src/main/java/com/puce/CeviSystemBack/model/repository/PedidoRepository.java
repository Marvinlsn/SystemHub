package com.puce.CeviSystemBack.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puce.CeviSystemBack.model.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
