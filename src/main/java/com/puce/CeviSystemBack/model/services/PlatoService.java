package com.puce.CeviSystemBack.model.services;

import java.util.List;

import com.puce.CeviSystemBack.model.entity.Plato;

public interface PlatoService {

    Plato guardarPlato(Plato plato);
    List<Plato> obtenerTodosLosPlatos();
    Plato obtenerPlatoPorId(Long id);
    Plato actualizarPlato(Plato plato);
    void eliminarPlato(Long id);
    void cambioEstado(Long id, boolean estado);
    List<Plato> buscarClienteNombre(String nombre);
	
}
