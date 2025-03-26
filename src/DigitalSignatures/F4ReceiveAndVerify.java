package DigitalSignatures;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

public class F4ReceiveAndVerify {

	static Object readFromFile(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Object object = oin.readObject();
		oin.close();
		return object;
	}

	public static void main(String[] args)  {
		

		try {
			PublicKey publicKey = (PublicKey) readFromFile("data/publicKey");
			byte[] sig = (byte[]) readFromFile("data/signature");
			String message = (String) readFromFile("data/message");

			Signature dsa = Signature.getInstance("SHA256withDSA");
			dsa.initVerify(publicKey);
			dsa.update(message.getBytes());
			boolean verifies = dsa.verify(sig);
			System.out.println("signature verifies: " + verifies);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
