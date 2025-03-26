package Lab4;

import java.io.Serializable;

public class Employee implements Serializable{

	private String name;
	private String address;
	private String telNo;
	
	public Employee(String name, String address, String telNo) {
		super();
		this.name = name;
		this.address = address;
		this.telNo = telNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public static void main(String[] args) {
		
		
//		Q2. (notes)
//		Write a Java class Employee with fields name, address telNo.
//		Write a Java program to
//		* instantiate an Employee object
//		* create a SealedObject containing the Employee object, encrypted with some Cipher
//		* //
//		* Extract the object from the SealedObject using another cipher (initialized for decryption)
//		* Print out the contents of the Employee object.

//		Q3a.
//		Write a Java program to
//		* instantiate an Employee object
//		* create a SealedObject containing an Employee object, encrypted with some Cipher
//		* save the SealedObject to a file (“data/sealedObject.dat”)
//		* save the Cipher key to a file (“data/secretKey”)
//		You can use
//		private static void writeToFile(String filename, Object object)
//		 throws Exception {
//		 FileOutputStream fout = new FileOutputStream(new File(filename));
//		 ObjectOutputStream oout = new ObjectOutputStream(fout);
//		 oout.writeObject(object);
//		 oout.close();
		
//		Q3b.
//		Write a second Java program to
//		* read the key from file
//		* read the SealedObject from file
//		* extract the Employee object from the SealedObject.
//		* print out the text stored in the Employee object.
//		static Object readFromFile(String filename) throws Exception {
//		 FileInputStream fin = new FileInputStream(filename);
//		 ObjectInputStream oin = new ObjectInputStream(fin);
//		 Object object = oin.readObject();
//		 oin.close();
//		 return object;
//		}
		
	}

}
