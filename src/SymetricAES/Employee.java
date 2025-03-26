package SymetricAES;

import java.io.Serializable;

public class Employee implements Serializable {

   private String name ;
   private String address ;
   private String telNo ;

   public Employee(String name, String address, String telNo) {
      super();
      this.name = name;
      this.address = address;
      this.telNo = telNo;
   }

   public String getName() {
      return name;
   }

   public void setName(String text) {
      this.name = text;
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

}

