package co.com.tauLabs.dto;

import java.io.Serializable;

public class SocialLoginDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String socialId;
	private String picture;

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
	
}
