package SymetricAES;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class E1encryption {
	public static void main(String[] args) throws Exception {

		String ALGORITHM = "AES";
//    String ALGORITHM = "Serpent";

		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		
		Cipher eCipher;
		eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		String s = "This is an important message";
		System.out.println("Clear text: " + s);
		byte[] cleartext = s.getBytes();
		System.out.println("Length of clear text " + cleartext.length);

		// Encrypt the cleartext
		byte[] ciphertext = eCipher.doFinal(cleartext);
		System.out.println("Length of cipher text " + ciphertext.length);

		String encodedCipherText = Base64.getEncoder().encodeToString(ciphertext);
		System.out.println("Base64 encoded ciphertext " + encodedCipherText);

		/////////////////////////////////////////////////
		// Decrypt

		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// Decrypt the ciphertext
		byte[] clearText1 = dCipher.doFinal(ciphertext);

		String text = new String(clearText1);
		System.out.println("Decrypted text: " + text);

	}
}
