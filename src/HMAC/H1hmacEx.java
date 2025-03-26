package HMAC;

import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class H1hmacEx {
	public static void main(String[] args) {

		try {
			String message = "Hi There" ;
			
			// Generate secret key
			KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = kg.generateKey();

			// Get instance of Mac object and initialize it with the above secret key
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(sk);
			
			// Get the hmac signature
			byte[] hmacSignature = mac.doFinal(message.getBytes());
			System.out.println(hmacSignature.length);

			/// Receiver
			Mac mac2 = Mac.getInstance("HmacSHA256");
			mac2.init(sk);
			// Get the hmac signature
			byte[] hmacSignature2 = mac2.doFinal(message.getBytes());

			// CHeck equality of the two signatures
			System.out.println("Check: " + Arrays.equals(hmacSignature, hmacSignature2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
