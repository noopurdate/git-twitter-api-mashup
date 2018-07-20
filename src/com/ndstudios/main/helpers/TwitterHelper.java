package com.ndstudios.main.helpers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndstudios.main.models.twitter.TwitterBearerTokenModel;
import com.ndstudios.main.models.twitter.TwitterStatus;
import com.ndstudios.main.models.twitter.TwitterStatusesContainer;

/**
 * Class holds helper methods for twitter Api's
 * @author ndate
 *
 */
public class TwitterHelper {

	private static String bearerToken = null;

	/**
	 * Constructs the request for requesting a bearer token and returns that
	 * token as a string
	 * 
	 * @param apiUrl
	 *            {@link String} url
	 * @return {@link String} token for given consumer key and consumer secret
	 * @throws IOException
	 */

	public static String requestBearerToken(String apiUrl) throws IOException {
		HttpsURLConnection httpsConnection = null;
		String encodedCredentials = HttpsGatewayHelper.encodeKeys(ConfigFileUtils.getConsumerKey(),
				ConfigFileUtils.getConsumerSecret());

		try {
			URL url = new URL(apiUrl);
			httpsConnection = (HttpsURLConnection) url.openConnection();
			httpsConnection.setDoOutput(true);
			httpsConnection.setDoInput(true);
			httpsConnection.setRequestMethod("POST");
			httpsConnection.setRequestProperty("User-Agent", "GitHubTwitterMashupAPI");
			httpsConnection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
			httpsConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			httpsConnection.setUseCaches(false);

			HttpsGatewayHelper.writeToRequest(httpsConnection, "grant_type=client_credentials");
			String responseString = HttpsGatewayHelper.readResponse(httpsConnection);

			ObjectMapper mapper = new ObjectMapper();

			TwitterBearerTokenModel bearerTokenModel = mapper.readValue(responseString, TwitterBearerTokenModel.class);
			if (bearerTokenModel != null) {
				String tokenType = bearerTokenModel.getTokenType();
				String token = bearerTokenModel.getAccessToken();

				return ((tokenType.equals("bearer")) && (token != null)) ? token : "";
			}
			return new String();

		} catch (MalformedURLException e) {
			throw new IOException("Invalid API URL specified.", e);
		} finally {
			if (httpsConnection != null) {
				httpsConnection.disconnect();
			}
		}
	}

	/**
	 * Fetches the first tweet from a given user's timeline
	 * 
	 * @param searchKey
	 *            String search string to search for mentions in tweets
	 * @return {@link List} of {@link TwitterStatus}
	 * @throws IOException
	 *             throws {@link IOException} if URL is wrong/malformed
	 */
	public static List<TwitterStatus> fetchMentionsData(String searchKey) throws IOException {

		String apiUrl = ConfigFileUtils.getValueForKey("twitter.search.url", new String[] { searchKey });

		if (Objects.isNull(bearerToken)) {
			bearerToken = requestBearerToken(ConfigFileUtils.getValueForKey("twitter.token.url"));
		}

		HttpsURLConnection httpsConnection = null;
		try {
			URL url = new URL(apiUrl);
			httpsConnection = (HttpsURLConnection) url.openConnection();
			httpsConnection.setDoOutput(true);
			httpsConnection.setDoInput(true);
			httpsConnection.setRequestMethod("GET");
			httpsConnection.setRequestProperty("User-Agent", "GitHubTwitterMashupAPI");
			httpsConnection.setRequestProperty("Authorization", "Bearer " + bearerToken);
			httpsConnection.setUseCaches(false);

			ObjectMapper mapper = new ObjectMapper();

			TwitterStatusesContainer statuses = mapper.readValue(HttpsGatewayHelper.readResponse(httpsConnection),
					TwitterStatusesContainer.class);
			return statuses.getStatuses();
		} catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		} finally {
			if (httpsConnection != null) {
				httpsConnection.disconnect();
			}
		}
	}
}
