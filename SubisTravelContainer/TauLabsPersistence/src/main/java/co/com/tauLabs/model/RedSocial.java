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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RED_SOCIAL", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RedSocial implements Serializable, IEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red_social")
	private Long id;

	private String nombre;

	@JsonIgnore
	@XmlTransient
	@OneToMany(fetch=FetchType.LAZY,mappedBy="redSocial")
	private List<RedSocialUsuario> redesSocialesUsuarios;

	public RedSocial() {

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

	public List<RedSocialUsuario> getRedesSocialesUsuarios() {
		return redesSocialesUsuarios;
	}

	public void setRedesSocialesUsuarios(List<RedSocialUsuario> redesSocialesUsuarios) {
		this.redesSocialesUsuarios = redesSocialesUsuarios;
	}
	
}