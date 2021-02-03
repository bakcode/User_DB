package com.ayush.user_info;

import java.util.ArrayList;
import java.util.List;

public class Repository {
	public List<User_Details> detailsList = new ArrayList();
   
    public List<User_Address> addressList = new ArrayList();
    
    private static Repository repository;
    
    private Repository(){        
    }
  
    public static Repository getRepository(){
        if(repository==null){
            repository = new Repository();
        }
        return repository;
    }
}
