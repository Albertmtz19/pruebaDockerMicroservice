package com.prueba.agenda.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contacto")
public class Contacto {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String email;

	@OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CatalogoTelefono> catalogoTelefonos;

	private String fecha_creacion;

	private boolean status;



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	public boolean isStatus() {
		return status;
	}

	public List<CatalogoTelefono> getTelefonos() {
		return catalogoTelefonos;
	}

	public void setTelefonos(List<CatalogoTelefono> catalogoTelefonos) {
		this.catalogoTelefonos = catalogoTelefonos;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
