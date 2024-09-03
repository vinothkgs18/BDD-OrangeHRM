package util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Helper {

	private static final Logger LOGGER = LogManager.getLogger(Helper.class);

	public static String generateRandomText() {
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(10);
		LOGGER.info("Generated Random text as "+randomAlphabetic);
		return randomAlphabetic;
	}

	public static int generateRandomNumbers() {
		Random r = new Random();
		int nextInt = r.nextInt(12);
		LOGGER.info("Generated random number as "+nextInt);
		return nextInt;
	}

	public static String generateRandomAlphaNumeric() {
		String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
		LOGGER.info("Generated random alpha numaric as "+alphanumeric);
		return alphanumeric;
	}
}
