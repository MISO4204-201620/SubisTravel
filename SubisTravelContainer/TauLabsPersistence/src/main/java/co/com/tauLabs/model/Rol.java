package co.com.tauLabs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol implements Serializable, IEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long id;

	private String estado;

	private String nombre;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="rol")
	private List<RolUsuario> rolUsuarios;

	public Rol() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolUsuario> getRolUsuarios() {
		return this.rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuario addRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().add(rolUsuario);
		rolUsuario.setRol(this);

		return rolUsuario;
	}

	public RolUsuario removeRolUsuario(RolUsuario rolUsuario) {
		getRolUsuarios().remove(rolUsuario);
		rolUsuario.setRol(null);

		return rolUsuario;
	}

}