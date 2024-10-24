package com.vicentemorales.modelos;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artistas")
public class Artistas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=5, message="Por favor proporciona el nombre")
	private String nombre;
	@Column
	@Size(min=3, message="Por favor proporciona el apellido del artista")
	private String apellido;
	@Column
	@Size(min=3, message="Por favor proporciona una biografia valida")
	private String biografia;
	@Column
	private LocalDateTime fechaCreacion;
	@Column
	private LocalDateTime fechaActualizacion;
	
	@OneToMany(mappedBy = "artistas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cancion> canciones;

	public Artistas(Long id, @Size(min = 5, message = "Por favor proporciona el nombre") String nombre,
			@Size(min = 3, message = "Por favor proporciona el apellido del artista") String apellido,
			@Size(min = 3, message = "Por favor proporciona una biografia valida") String biografia,
			LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion, List<Cancion> canciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.biografia = biografia;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.canciones = canciones;
	}
	public Artistas() {
	}
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
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	public List<Cancion> getCanciones() {
		return canciones;
	}
	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	@PrePersist
	protected void onCrete() {
		fechaCreacion = LocalDateTime.now();
		fechaActualizacion = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		fechaActualizacion = LocalDateTime.now();
	}
}
