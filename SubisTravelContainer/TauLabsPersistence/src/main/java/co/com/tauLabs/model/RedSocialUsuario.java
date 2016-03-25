package co.com.tauLabs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RED_SOCIAL_USUARIO", schema="SubisDB")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RedSocialUsuario implements Serializable, IEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_red_social_usuario")
	private Long id;

	private String identificador;

	@Column(name="id_red_social")
	private Long idRedSocial;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_red_social",insertable=false,updatable=false)
	private RedSocial redSocial;

	@Column(name="id_usuario")
	private Long idUsuario;
	
	@JsonIgnore
	@XmlTransient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario",insertable=false,updatable=false)
	private Usuario usuario;

	public RedSocialUsuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Long getIdRedSocial() {
		return idRedSocial;
	}

	public void setIdRedSocial(Long idRedSocial) {
		this.idRedSocial = idRedSocial;
	}

	public RedSocial getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(RedSocial redSocial) {
		this.redSocial = redSocial;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}