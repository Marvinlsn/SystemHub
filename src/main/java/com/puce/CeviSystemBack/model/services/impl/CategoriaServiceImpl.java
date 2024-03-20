package com.puce.CeviSystemBack.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.puce.CeviSystemBack.model.entity.Categoria;
import com.puce.CeviSystemBack.model.repository.CategoriaRepository;
import com.puce.CeviSystemBack.model.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
    private  CategoriaRepository categoriaRepository;


    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada con ID: " + id));
    }
}
