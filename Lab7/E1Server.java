package certificateEx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

public class E1Server {
  public static void main(String[] args) {

    try {

      char[] KSPASSWORD = "kkkk".toCharArray();
      char[] PASSWORD = "1234".toCharArray();

      KeyStore keyStore = KeyStore.getInstance("JKS");
      keyStore.load(new FileInputStream("keystore"), KSPASSWORD);

      KeyManagerFactory keyManagerFactory = KeyManagerFactory
          .getInstance("SunX509");
      keyManagerFactory.init(keyStore, PASSWORD);

      SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

      ServerSocketFactory ssFactory = sslContext.getServerSocketFactory();

      int port = 443;
      ServerSocket ss = ssFactory.createServerSocket(port);
      Socket socket = ss.accept();

      // Create streams to securely send and receive data to the client
      InputStream in = socket.getInputStream();
      BufferedReader r = new BufferedReader(new InputStreamReader(in));
      String name = r.readLine();

      OutputStream o = socket.getOutputStream();
      PrintWriter p = new PrintWriter(o);
      p.println("Hello " + name);
      p.close();
    } catch (SSLHandshakeException e) {
      System.out.println("Server - Handshake Failed");
      ;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
