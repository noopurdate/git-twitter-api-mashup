package com.ndstudios.main.models.twitter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class to hold twitter user details
 * 
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterUser {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("screen_name")
	private String screenName;
	
	@JsonProperty("url")
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
