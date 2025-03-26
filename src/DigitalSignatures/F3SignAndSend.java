package DigitalSignatures;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class F3SignAndSend {
  static void writeToFile(String filename, Object object) throws Exception {
    FileOutputStream fout = new FileOutputStream(filename);
    ObjectOutputStream oout = new ObjectOutputStream(fout);
    oout.writeObject(object);
    oout.close();
  }

  public static void main(String[] args) {

    try {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		KeyPair pair = keyGen.generateKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();

		String message = "This is the data I am sending";

		Signature dsa = Signature.getInstance("SHA256withDSA");
		dsa.initSign(privateKey);
		dsa.update(message.getBytes());
		byte[] sig = dsa.sign();

		writeToFile("data/message", message);
		writeToFile("data/signature", sig);
		writeToFile("data/publicKey", publicKey);
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
}
