package com.ndstudios.main.models.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class to hold github user details
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

	@JsonProperty("login")
	private String login;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("gists_url")
	private String gistsUrl;

	@JsonProperty("type")
	private String type;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getGistsUrl() {
		return gistsUrl;
	}

	public void setGistsUrl(String gistsUrl) {
		this.gistsUrl = gistsUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
