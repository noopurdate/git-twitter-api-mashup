package com.ndstudios.main.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

/**
 * This class contains methods to call diff http methods GET/ POST
 * 
 * @author ndate
 *
 */
public class HttpsGatewayHelper {

	/**
	 * Writes a request to a connection
	 * 
	 * @param connection  {@link HttpsURLConnection} object
	 * @param textBody  {@link String} text as body
	 * @return {@link Boolean} is writing to request was successful 
	 */
	public static boolean writeToRequest(HttpsURLConnection connection, String textBody) {
		try {
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			wr.write(textBody);
			wr.flush();
			wr.close();

			return true;
		} catch (IOException e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Reads a response for a given connection and returns it as a string.
	 * 
	 * @param connection {@link HttpsURLConnection} object from which response is supposed to be read
	 * @return {@link String} representation of response
	 */
	public static String readResponse(HttpsURLConnection connection) {
		try {
			StringBuilder builder = new StringBuilder();

			BufferedReader buffReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while ((line = buffReader.readLine()) != null) {
				builder.append(line + System.getProperty("line.separator"));
			}
			return builder.toString();
		} catch (IOException e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
			return new String();
			
		}
	}
	
	/**
	 * Encodes the consumer key and secret to create the basic authorization key
	 * 
	 * @param consumerKey {@link String} api consumer key
	 * @param consumerSecret {@link String} api consumer secret
	 * @return {@link String} representation of encoded key
	 */
	public static String encodeKeys(String consumerKey, String consumerSecret) {
		try {
			String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
			String encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");
			
			String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
			byte[] encodedBytes = Base64.getEncoder().encode(fullKey.getBytes());
			return new String(encodedBytes);  
		}
		catch (UnsupportedEncodingException e) {
			return new String();
		}
	}

}
