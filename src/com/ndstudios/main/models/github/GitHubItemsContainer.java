package com.ndstudios.main.models.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model class containing github items list
 * 
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubItemsContainer {

	@JsonProperty("items")
	private List<GithubItem> items;

	public List<GithubItem> getItems() {
		return items;
	}

	public void setItems(List<GithubItem> items) {
		this.items = items;
	}
}
