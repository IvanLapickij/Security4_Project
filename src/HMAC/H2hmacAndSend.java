package HMAC;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class H2hmacAndSend {
	static void writeToFile(String filename, Object object) throws Exception {
		FileOutputStream fout = new FileOutputStream(filename);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(object);
		oout.close();
	}

	public static void main(String[] args) {

		try {

			// write secret key, (in practise this has been done previously)
			KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = kg.generateKey();
			writeToFile("data/secretKey", sk);

			// write message
			String message = "This is the data I am sending";
			writeToFile("data/message", message);

			// write hmac
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(sk);
			byte[] hmac = mac.doFinal(message.getBytes());
			writeToFile("data/hmac", hmac);

			System.out.println(hmac.length);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
