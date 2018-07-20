package com.ndstudios.main.models.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class to hold twitter bearer token values
 * @author ndate
 *
 */

public class TwitterBearerTokenModel {

	@JsonProperty("token_type")
	private String tokenType;
	
	@JsonProperty("access_token")
	private String accessToken;

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	
}
