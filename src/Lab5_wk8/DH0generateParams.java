package Lab5_wk8;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;

import javax.crypto.spec.DHParameterSpec;

public class DH0generateParams {
  
  static void writeToFile(String filename, Object object) throws Exception {
    FileOutputStream fout = new FileOutputStream(filename);
    ObjectOutputStream oout = new ObjectOutputStream(fout);
    oout.writeObject(object);
    oout.close();
  }
  
  public static void main(String[] args) throws Exception {

    // Create the parameter generator for a 1024-bit DH key pair
    AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator
        .getInstance("DH");
    paramGen.init(1024);

    // Generate the parameters
    AlgorithmParameters params = paramGen.generateParameters();
    //params.getEncoded() ;
    DHParameterSpec dhSpec = params.getParameterSpec(DHParameterSpec.class);
    
    String s = dhSpec.getP() + "----" + dhSpec.getG() + "----" + dhSpec.getL();
    // System.out.println(s);
  
    System.out.println(dhSpec.getP());
    System.out.println();
    System.out.println(dhSpec.getG());
    System.out.println();
    System.out.println(dhSpec.getL());
    
    writeToFile("data/dhParams", s) ;
  }
}

 