package Lab4;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

//Lab 4 – Symmetric Key Encryption
public class Question1 {

	public static void main(String[] args) throws Exception {
		System.out.println("Question 1.");
//		Q1. (notes)
//		Write a Java program (notes) to
//		* encrypt some text with AES (TwoFish, Serpent)
//		* then decrypt it
		
		 String ALGORITHM = "AES" ; //block cypher, takes message and divides into blocks 128 bits , 16 bytes
		 KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		 SecretKey key = keygen.generateKey();
		 Cipher eCipher = Cipher.getInstance(ALGORITHM);
		 // Initialize the cipher for encryption
		 eCipher.init(Cipher.ENCRYPT_MODE, key);
		 String s = "This is just an example";
		 System.out.println("Clear text: " + s);
		 System.out.println("Clear text: " + s.length());
		 
		 byte[] cleartext = s.getBytes();
		 // Encrypt the cleartext
		 byte[] ciphertext = eCipher.doFinal(cleartext);
		 System.out.println("Cipher text: " + HexUtil.toString(ciphertext));
		 System.out.println("Cipher text length: " + ciphertext.length);
		 
		 
		// Decrypt the ciphertext
		 Cipher dCipher = Cipher.getInstance(ALGORITHM);
		 dCipher.init(Cipher.DECRYPT_MODE, key);
		 // Decrypt the ciphertext
		 byte[] clearText1 = dCipher.doFinal(ciphertext);
		 String text = new String(clearText1);
		 System.out.println("Decrypted text: " + text);
		 System.out.println(""); // space after qustion
		 




	}

}
