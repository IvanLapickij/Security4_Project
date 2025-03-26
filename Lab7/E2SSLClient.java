package certificateEx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class E2SSLClient {
	public static void main(String[] args) {
		try {
			System.setProperty("javax.net.ssl.trustStore", "cacerts");
			System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
			
			SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
			SSLSocket socket = (SSLSocket)factory.createSocket("localhost", 443);
			
			socket.startHandshake();
			
			OutputStream o = socket.getOutputStream();
			PrintWriter p = new PrintWriter(o) ;
			p.println("paul") ;
			p.flush() ;
			
			InputStream in = socket.getInputStream();
			BufferedReader r = new BufferedReader(new InputStreamReader(in)) ;
			String reply = r.readLine();
			
			System.out.println("From Server " + reply);

   
			p.close();
		} catch(SSLHandshakeException e) {
			System.out.println("Client - Handshake Failed"); ;   
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
