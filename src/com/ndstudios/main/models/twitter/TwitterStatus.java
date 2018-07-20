package com.ndstudios.main.models.twitter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class containing twitter tweet properties
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterStatus {
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("text")
	private String text;
	
	@JsonProperty("user")
	private TwitterUser user;

}
