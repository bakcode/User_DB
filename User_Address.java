package com.ayush.user_info;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_Address implements Serializable{
		
	   private Long user_id = System.currentTimeMillis();
	
	   private String add_line1;
	   private String add_line2;
	   private String city;
	   private String country;
	   private int postal_code;
	   
	   public User_Address(String add_line1,String add_line2,int postal_code,String city, String country){
	       this.add_line1 = add_line1;
	       this.add_line2 = add_line2;
	       this.postal_code = postal_code;
	       this.city = city;
	       this.country = country;
	   }
	   
	   public User_Address(){
	       
	   }
	public String getadd_line1() {
		return add_line1;
	}
	public void setadd_line1(String add_line1) {
		this.add_line1 = add_line1;
	}
	public String getadd_line2() {
		return add_line2;
	}
	public void setadd_line2(String add_line2) {
		this.add_line2 = add_line2;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}
	public int getpostal_Code() {
		return postal_code;
	}
	public void setpostal_Code(int postal_Code) {
		this.postal_code = postal_Code;
	}
	   

}
