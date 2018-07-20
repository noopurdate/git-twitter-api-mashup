package com.ndstudios.main.helpers;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * This class contains different methods to read values from properties file
 * 
 * @author ndate
 *
 */
public class ConfigFileUtils {

	private static ResourceBundle rb = ResourceBundle.getBundle("com.ndstudios.main.application");

	/**
	 * 
	 * @return consumer key value from properties file
	 */
	public static String getConsumerKey() {
		return getValueForKey("consumer.key");
	}

	/**
	 * 
	 * @return consumer key value from properties file
	 */
	public static String getConsumerSecret() {
		return getValueForKey("consumer.secret");
	}

	/**
	 * Returns value for key passed
	 * 
	 * @param key
	 *            {@link String} for which value is required from properties
	 *            file
	 * @return {@link String} value found for key
	 */
	public static String getValueForKey(String key) {
		try {
			return rb.getString(key);
		} catch (Exception e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
			return new String();
		}
	}

	public static String getValueForKey(String key, Object[] params) {
		try {
			return MessageFormat.format(rb.getString(key), params);
		} catch (Exception e) {
			// TODO after integrating logger log the message to console
			System.out.println(e.getMessage());
			return new String();
		}
	}
}
