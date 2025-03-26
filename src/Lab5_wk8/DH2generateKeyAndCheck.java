package Lab5_wk8;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DH2generateKeyAndCheck {

   static Object readFromFile(String filename) throws Exception {
      FileInputStream fin = new FileInputStream(filename);
      ObjectInputStream oin = new ObjectInputStream(fin);
      Object object = oin.readObject();
      oin.close();
      return object;
   }

   public static void main(String[] args) throws Exception {

      // read both keypairs
      PrivateKey privateKey1 = (PrivateKey) readFromFile("data/AlicePrivate");
      PrivateKey privateKey2 = (PrivateKey) readFromFile("data/BobPrivate");
      PublicKey publicKey1 = (PublicKey) readFromFile("data/AlicePublic");
      PublicKey publicKey2 = (PublicKey) readFromFile("data/BobPublic");
   
      
      // AlicePrivate and BobPublic
      KeyAgreement ka = KeyAgreement.getInstance("DH");
      ka.init(privateKey1);
      ka.doPhase(publicKey2, true);
      byte[] rawValue = ka.generateSecret();
      System.out.println(rawValue.length);
      
      SecretKey secretKey1 = new SecretKeySpec(rawValue, 0, 16, "AES");

      String encodedKey = Base64.getEncoder().encodeToString(secretKey1.getEncoded());
      System.out.println("Base64 encoded secret key 1 " + encodedKey);

      // AlicePublic and BobPrivate
      ka.init(privateKey2);
      ka.doPhase(publicKey1, true);
      byte[] rawValue2 = ka.generateSecret();
      SecretKey secretKey2 = new SecretKeySpec(rawValue2, 0, 16, "AES");
            
      String encodedKey2 = Base64.getEncoder().encodeToString(secretKey2.getEncoded());
      System.out.println("Base64 encoded secret key 2 " + encodedKey2);

   }
}
