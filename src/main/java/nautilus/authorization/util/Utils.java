package nautilus.authorization.util;

import java.util.Base64;

public class Utils {

	public static String decrypt (String encodedString) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		return new String(decodedBytes);
	}
	
}
