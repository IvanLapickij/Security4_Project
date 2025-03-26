package HMAC;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class H3hmacAndVerify {

	static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		oin.close();
		return object;
	}

	public static void main(String[] args) {

		try {
			// read secret key
			SecretKey sk = (SecretKey) readFromFile("data/secretKey");
			byte[] sentHmac = (byte[]) readFromFile("data/hmac");
			String message = (String) readFromFile("data/message");

			// calculate hmac
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(sk);
			byte[] myHmac = mac.doFinal(message.getBytes());

			// check hmac
			System.out.println("Check: " + Arrays.equals(sentHmac, myHmac));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
