import java.util.Arrays;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Lab3_Q1 {

    public static void main(String[] args) throws Exception {
    	
    	String message = "Hi There";
    	
        // Generate secret key
        KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
        SecretKey sk = kg.generateKey();
        
        //Get instance of Mac object and initialize it wih the above secret key
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(sk);
        
        //Calculate HMAC signature
        byte[] result = mac.doFinal(message.getBytes());
        System.out.println("MAC length: " + result.length);

        // Receiver
        Mac mac2 = Mac.getInstance("HmacSHA256");
        mac2.init(sk);
        byte[] result2 = mac2.doFinal(message.getBytes()); // Use mac2 here

        System.out.println("Check: " + Arrays.equals(result, result2));
    }
}
