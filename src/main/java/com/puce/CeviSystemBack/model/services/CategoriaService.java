package com.puce.CeviSystemBack.model.services;

import java.util.List;

import com.puce.CeviSystemBack.model.entity.Categoria;

public interface CategoriaService {
	
    Categoria guardarCategoria(Categoria categoria);
    List<Categoria> obtenerTodasLasCategorias();
    Categoria obtenerCategoriaPorId(Long id);
   
}
