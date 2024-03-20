package com.puce.CeviSystemBack.model.entity;

import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedDate;

import com.puce.CeviSystemBack.security.Entity.User;

import jakarta.persistence.*;

@Entity
@Table(name = "Despacho")
public class Despacho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_id", referencedColumnName = "id")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User usuarios;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fecha;

	public Despacho() {

	}

	public Despacho(Long id, Pedido pedido, User usuarios) {

		this.id = id;
		this.pedido = pedido;
		this.usuarios = usuarios;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public User getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(User usuarios) {
		this.usuarios = usuarios;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}