package com.ndstudios.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndstudios.main.helpers.ConfigFileUtils;
import com.ndstudios.main.helpers.GitHubHelper;
import com.ndstudios.main.helpers.TwitterHelper;
import com.ndstudios.main.models.github.GithubItem;

/**
 * class to get the GitHub and Twitter API mashup
 * 
 * @author ndate
 *
 */
public class ApiMashup {

	public static void main(String[] args) {

		List<GithubItem> gitHubProjectList = GitHubHelper.getGitHubRepositories();
		gitHubProjectList.stream().forEach(item -> {
			try {
				item.setTweets(TwitterHelper.fetchMentionsData(item.getName()));
			} catch (IOException e) {
				// TODO: handle exception
			}
		});

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(ConfigFileUtils.getValueForKey("json.output.file")), gitHubProjectList);
		} catch (IOException e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
		}
	}
}
