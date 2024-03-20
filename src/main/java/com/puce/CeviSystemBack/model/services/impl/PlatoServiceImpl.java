package com.puce.CeviSystemBack.model.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.puce.CeviSystemBack.model.entity.Plato;
import com.puce.CeviSystemBack.model.repository.PlatosRepository;
import com.puce.CeviSystemBack.model.services.PlatoService;

@Service
public class PlatoServiceImpl implements PlatoService {

	@Autowired
    private  PlatosRepository platoRepository;

    @Override
    public Plato guardarPlato(Plato producto) {
        return platoRepository.save(producto);
    }

	@Override
	public List<Plato> obtenerTodosLosPlatos() {
		return platoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Plato obtenerPlatoPorId(Long id) {
        return platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado con ID: " + id));
	}

	@Override
	public Plato actualizarPlato(Plato plato) {
        if (!platoRepository.existsById(plato.getId())) {
            throw new RuntimeException("No se puede actualizar. Producto no encontrado con ID: " + plato.getId());
        }
        return platoRepository.save(plato);
	}

	@Override
	public void eliminarPlato(Long id) {
		platoRepository.deleteById(id);
		
	}

	@Override
	public void cambioEstado(Long id, boolean estado) {
		Plato producto = platoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));
        producto.setEstado(estado);
        platoRepository.save(producto);
		
	}

	@Override
	public List<Plato> buscarClienteNombre(String nombre) {
		return platoRepository.findByNombre(nombre);
	}

}
