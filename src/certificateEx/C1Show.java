package certificateEx;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class C1Show {

  public static void main(String[] args) throws Exception {
    String keystoreFilename = "keystore";
    // String keystoreFilename = "paulWexford.cer";

    char[] password = "file".toCharArray();
    String alias = "ivan";

    FileInputStream fIn = new FileInputStream(keystoreFilename);
    KeyStore keystore = KeyStore.getInstance("JKS");

    keystore.load(fIn, password);

    Certificate cert = keystore.getCertificate(alias);

    System.out.println(cert);
  }
}