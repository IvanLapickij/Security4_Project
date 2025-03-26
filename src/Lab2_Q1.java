import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Lab2_Q1{

	public static void main(String[] args) {
		
		String password = "12345";//laterr change 1 char 
		//also try long string, change 1 char in string and see
		//how much the message digest chargest
		
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		//algorithm.reset();
		algorithm.update(password.getBytes());
		byte[] messageDigest = algorithm.digest();
		System.out.println("length " + messageDigest.length);
		
		String encodedDigest = Base64.getEncoder().encodeToString(messageDigest);
		System.out.println("Base64 encoded message digest" + encodedDigest);
	}

}
