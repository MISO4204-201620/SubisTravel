package co.com.tauLabs.dto;

import java.io.Serializable;

public class SocialLoginDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String socialId;
	private String picture;
	private String name;
	private String provider;
	private String email;

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
