package com.ayush.user_info;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is a domain class representing Category.
 * @author ayush
 */
@Entity
public class User_Details implements Serializable {
    /**
     * It refers to a unique category Id.
     * Here it is simply generated using current time,
     * but in real time app it should be generated using some professional strategy or algorithm. 
     */
	@Id
   private Long user_id = System.currentTimeMillis();
   /**
    * First name of user.
    */
   private String first_name;
   private String last_name;
   private int age;
   private String DOB;
   
   public User_Details(String first_name,String last_name,int age,String DOB){
       this.first_name = first_name;
       this.last_name = last_name;
       this.age = age;
       this.DOB = DOB;
   }
   
   public User_Details(){
       
   }
    public Long getUserId() {
        return user_id;
    }

    public void setCategoryId(Long userId) {
        this.user_id = userId;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
}

