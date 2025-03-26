package DigitalSignatures;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class F1Authenticate {
  public static void main(String[] args) {
    try {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		KeyPair pair = keyGen.generateKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();
		
		// sending the data
		Signature dsa = Signature.getInstance("SHA256withDSA");
		dsa.initSign(privateKey);
		String message = "Important Message";
		dsa.update(message.getBytes());
		byte[] sig = dsa.sign();
		
		 // receiving the data and verifying 
		dsa.initVerify(publicKey);
		dsa.update(message.getBytes());
		boolean verifies = dsa.verify(sig);
		System.out.println("signature verifies: " + verifies);
		
	} catch (Exception e) {
		e.printStackTrace();
	}

  }
}
