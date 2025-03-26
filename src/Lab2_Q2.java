

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class Lab2_Q2 {

	public static void main(String[] args) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			InputStream fin = new FileInputStream("data/test.txt");
			byte[] buffer = new byte[64];
			
			int bytesRead = 0;
			while ((bytesRead = fin.read(buffer)) > 0) {
				algorithm.update(buffer, 0 , bytesRead);
				}
				fin.close();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
