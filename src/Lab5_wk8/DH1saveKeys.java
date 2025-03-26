package Lab5_wk8;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.spec.DHParameterSpec;

public class DH1saveKeys {

  static Object readFromFile(String filename) throws Exception {
    FileInputStream fin = new FileInputStream(filename);
    ObjectInputStream oin = new ObjectInputStream(fin);
    Object object = oin.readObject();
    oin.close();
    return object;
  }

  static void writeToFile(String filename, Object object) throws Exception {
    FileOutputStream fout = new FileOutputStream(filename);
    ObjectOutputStream oout = new ObjectOutputStream(fout);
    oout.writeObject(object);
    oout.close();
  }

  public static void main(String[] args) throws Exception {
    String PARTY = args[0];

    // get DH parameters
    String valuesInStr = (String) readFromFile("data/dhParams");
    String[] values = valuesInStr.split("----");
    BigInteger p = new BigInteger(values[0]);
    BigInteger g = new BigInteger(values[1]);
    int l = Integer.parseInt(values[2]);
    DHParameterSpec dhSpec = new DHParameterSpec(p, g, l);

    // Use the values to generate a key pair
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
    keyGen.initialize(dhSpec);
    KeyPair keypair = keyGen.generateKeyPair();

    // Save the private key
    PrivateKey privateKey = keypair.getPrivate();
    writeToFile("data/" + PARTY + "Private", privateKey) ;

    // Save the public key
    PublicKey publicKey = keypair.getPublic();
    writeToFile("data/" + PARTY + "Public", publicKey) ;
    
  }
}
