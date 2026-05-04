package com.prueba.agenda.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogotelefono")
public class CatalogoTelefono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;


	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "contacto_id", referencedColumnName = "id", nullable = false)
	private Contacto contacto;




	public Long getId() {

		return id;
	}
	public void setId(Long id) {

		this.id = id;
	}
	public String getTipo() {

		return tipo;
	}
	public void setTipo(String tipo) {

		this.tipo = tipo;
	}


	public String getDescripcion() {

		return descripcion;
	}

	public void setDescripcion(String descripcion) {

		this.descripcion = descripcion;
	}

	public Contacto getContacto() {

		return contacto;
	}

	public void setContacto(Contacto contacto) {

		this.contacto = contacto;
	}
}
