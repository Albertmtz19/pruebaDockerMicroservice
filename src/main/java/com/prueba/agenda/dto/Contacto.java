package com.prueba.agenda.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	@Column(unique = true, nullable = false)
	private String email;

	@JsonManagedReference
	@OneToMany(mappedBy = "contacto", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CatalogoTelefono> telefonos;

	private String fecha_creacion;

	private String fecha_actualizacion;

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

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFecha_actualizacion() {
		return fecha_actualizacion;
	}

	public void setFecha_actualizacion(String fecha_actualizacion) {
		this.fecha_actualizacion = fecha_actualizacion;
	}

	public List<CatalogoTelefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<CatalogoTelefono> telefonos) {
		telefonos = telefonos;
	}
}
