package com.ndstudios.main.models.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ndstudios.main.models.twitter.TwitterStatus;

/**
 * Model class containing github item properties
 * @author ndate
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubItem {

	@JsonProperty("name")
	private String name;

	@JsonProperty("full_name")
	private String fullName;

	@JsonProperty("html_url")
	private String htmlUrl;

	@JsonProperty("description")
	private String description;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("updated_at")
	private String updatedAt;

	@JsonProperty("size")
	private String size;

	@JsonProperty("stargazers_count")
	private int stars;

	@JsonProperty("owner")
	private Owner owner;

	@JsonProperty("tweets")
	private List<TwitterStatus> tweets;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public List<TwitterStatus> getTweets() {
		return tweets;
	}

	public void setTweets(List<TwitterStatus> tweets) {
		this.tweets = tweets;
	}
}
