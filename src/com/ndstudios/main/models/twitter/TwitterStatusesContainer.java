package com.ndstudios.main.models.twitter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class containing twitter list of tweets/statuses 
 * 
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterStatusesContainer {
	
	@JsonProperty("statuses")
	List<TwitterStatus> statuses;

	public List<TwitterStatus> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<TwitterStatus> statuses) {
		this.statuses = statuses;
	}
}
