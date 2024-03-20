package com.puce.CeviSystemBack.controllers;

import com.puce.CeviSystemBack.model.entity.Plato;
import com.puce.CeviSystemBack.model.services.PlatoService;

import io.jsonwebtoken.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*")
public class PlatoController {

    @Autowired
    private PlatoService platoService;


  
	@PostMapping(consumes = { "multipart/form-data" })
	public ResponseEntity<Plato> guardarPlato(@RequestPart("plato") Plato plato,
			@RequestPart(name = "imagen") MultipartFile imagen) throws IOException, java.io.IOException {

		if (imagen != null && !imagen.isEmpty()) {
			byte[] imagenBytes = imagen.getBytes();
			plato.setImagenProducto(imagenBytes);
		}

		Plato platoGuardado = platoService.guardarPlato(plato);
		return ResponseEntity.status(HttpStatus.CREATED).body(platoGuardado);
	}

    @GetMapping
    public ResponseEntity<List<Plato>> obtenerTodosLosPlatos() {
        List<Plato> platos = platoService.obtenerTodosLosPlatos();
        return ResponseEntity.status(HttpStatus.OK).body(platos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> obtenerPlatoPorId(@PathVariable Long id) {
        Plato plato = platoService.obtenerPlatoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(plato);
    }


   
	@PutMapping("/{id}")
	public ResponseEntity<Plato> actualizarPlato(@PathVariable Long id,
			@RequestPart("plato") Plato plato,
			@RequestPart(name = "imagen", required = false) MultipartFile imagen) throws java.io.IOException {

		plato.setId(id);

		if (imagen != null && !imagen.isEmpty()) {
			try {
				byte[] imagenBytes = imagen.getBytes();
				plato.setImagenProducto(imagenBytes);
			} catch (IOException e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
			}
		}

		Plato pedidoActualizado = platoService.actualizarPlato(plato);
		return ResponseEntity.status(HttpStatus.OK).body(pedidoActualizado);
	}
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPlato(@PathVariable Long id) {
        platoService.eliminarPlato(id);
        return ResponseEntity.noContent().build();
    }


 
    @PostMapping("/cambiar-estado/{id}/{estado}")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id, @PathVariable boolean estado) {
        try {
        	platoService.cambioEstado(id, estado);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Plato>> buscarPlatoPorNombre(@PathVariable String nombre) {
        List<Plato> platos = platoService.buscarClienteNombre(nombre);
        return ResponseEntity.status(HttpStatus.OK).body(platos);
    }
}
