package com.ndstudios.main.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndstudios.main.models.github.GitHubItemsContainer;
import com.ndstudios.main.models.github.GithubItem;

/**
 * Class containing all helper methods to fetch GitHub data
 * 
 * @author ndate
 *
 */
public class GitHubHelper {

	public static final String apiUrl = ConfigFileUtils.getValueForKey("github.search.url");

	/**
	 * method that returns all the recent github items
	 * @return {@link List} of {@link GithubItem}
	 */
	public static List<GithubItem> getGitHubRepositories() {

		HttpsURLConnection httpsConnection = null;
		try {
			URL url = new URL(apiUrl);
			httpsConnection = (HttpsURLConnection) url.openConnection();
			httpsConnection.setDoOutput(true);
			httpsConnection.setDoInput(true);
			httpsConnection.setRequestMethod("GET");
			httpsConnection.setRequestProperty("User-Agent", "GitHubTwitterMashupAPI");
			httpsConnection.setUseCaches(false);

			ObjectMapper mapper = new ObjectMapper();
			GitHubItemsContainer itemsContainer 
								= mapper.readValue(HttpsGatewayHelper.readResponse(httpsConnection), GitHubItemsContainer.class);
			return itemsContainer.getItems();

		} catch (IOException e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
			return Collections.emptyList();
		} finally {
			if (httpsConnection != null) {
				httpsConnection.disconnect();
			}
		}
	}
}
