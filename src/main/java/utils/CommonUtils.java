package utils;

import java.util.Random;

public class CommonUtils {
	
	 public static String getRandomEmail() {
	        return "user" + getRandomNumber() + "@example.com";
	    }

	    private static int getRandomNumber() {
	        return new Random().nextInt(9000) + 1000;
	    }

}
