import java.lang.Object;
import java.util.Random;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Hex;

public class Lab1 {

	public static void main(String[] args) {
		
		
		/*Q1.
		Write a Java program to print three random numbers beteen 0 and 1 using
		Math.random(). Run it twice. Is the output the same?*/
		System.out.println("\n");
        System.out.println("Question 1.");
		System.out.println("Math.random() 0-1: " + Math.random());
		System.out.println("Math.random() 0-1: " + Math.random());
		
		/*Q2.
		Write a Java program to print three random numbers beteen 0 and 1 using
		java.util.Random. Run it twice. Is the output the same? How do you make the output
		the same?*/
		System.out.println("\n");
        System.out.println("Question 2.");
		// Create an instance of Random
        Random random = new Random();
        
     // Generate a random integer (can be any valid int)
        int randomInt = random.nextInt();
        System.out.println("Random integer (any int): " + randomInt);
        System.out.println("Random integer (any int): " + randomInt);
        System.out.println("Random integer (any int): " + randomInt);
		
       	
      /*
       * Q3.
		Write a Java program using java.util.Random to print
			• A random integer
			• A random double between 0 and 1.
			• A random integer between 0 and 100

       */
        System.out.println("\n");
        System.out.println("Question 3.");
        
        System.out.println("Random integer 0-1: " + randomInt);
        double randomDouble = random.nextDouble();
        System.out.println("Random Double : " + randomDouble);
        
        
     // Choose a random seed from 0 to 100 (inclusive)
        Random seedGenerator = new Random();
        int seed = seedGenerator.nextInt(101); // 101 because bound is exclusive
        
        // Now use that seed to create a new Random instance
        Random randomSeed = new Random(seed);
        System.out.println("Random Seed integer 0-100: " + randomSeed.nextInt(100));
        
        /*
         * Q4.
			Write a Java program using java.security.SecureRandom to print
				• a random integer between 0 and 1000
				• a 20 byte seed value obtained from SecureRandom
					Use Hex.encodeHexString() in the Apache Commons Codec Library
(					http://commons.apache.org/codec/) to print the Hex representation of this seed
         */
        
        System.out.println("\n");
        System.out.println("Question 4.");
        
        SecureRandom secureRandom = new SecureRandom();
        System.out.println(secureRandom.nextInt(1000));
        
        // Generate a 20-byte random seed
        byte[] seedBytes = new byte[20];
        secureRandom.nextBytes(seedBytes);
        
     // Convert the seed bytes to a hex string using Apache Commons Codec
        String hexSeed = Hex.encodeHexString(seedBytes);
        System.out.println("20-byte seed (Hex): " + hexSeed);
        
        /*
         * Q5.
         * Aswers is No.
         */
        
        /*
         * Q6.
         * Aswers is in Lab 0 notes.
         * 
         */
        
        /*
         * Q7.
         * Aswers is in Lab 0? implementation of secure random.
         * 
         */
	}

}
