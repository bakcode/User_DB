package com.ayush.user_info;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Service {
	private Scanner in = new Scanner(System.in);
	private int choice;
	private Repository repo = Repository.getRepository();
	
    public void showMenu(){
    while(true){
        printMenu();
        switch(choice){
            case 1:
                onUser_Details();
                pressAnyKeyToContinue();
                break;
            case 2:
                onShowDatabase();
                pressAnyKeyToContinue();
                break;
            case 0:
                onExit();
                break;
        }
        
    }
}

	public void printMenu(){
        System.out.println("----------PEM Menu-----------");
        System.out.println("1. Add Details");
        System.out.println("2. Show Databse");
        System.out.println("0. Exit");
        System.out.println("-----------------------------");
        System.out.print("Enter your choice: ");
        choice = in.nextInt();
    }
	private void onUser_Details(){
        in.nextLine();
        System.out.print("Enter First Name: ");
        String fName = in.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = in.nextLine();
        System.out.print("Enter Age: ");
        int a = in.nextInt();
        in.nextLine();
        System.out.print("Enter Date(DD/MM/YYYY): ");
        String dob = in.nextLine();     
        System.out.print("Enter Address Line 1: ");
        String add1 = in.nextLine();
        System.out.print("Enter Address Line 2: ");
        String add2 = in.nextLine();
        System.out.print("Enter Postal Code: ");
        int pc = in.nextInt();
        in.nextLine();
        System.out.print("Enter City: ");
        String cty = in.nextLine();
        System.out.print("Enter Country: ");
        String cntry = in.nextLine();
        User_Details fd = new User_Details(fName,lName,a,dob);
        User_Address fad = new User_Address(add1,add2,pc,cty,cntry);
        
        repo.detailsList.add(fd);
        repo.addressList.add(fad);
        System.out.println("Success, Details Added...");
    }
	private void onShowDatabase(){
        System.out.println("Database");
        List<User_Details> dlist = repo.detailsList;
        for(int i = 0;i<dlist.size();i++){
            User_Details d = dlist.get(i);
            System.out.println((i+1)+"."+d.getUserId()+","+d.getFirstName()+","+d.getLast_name()+","+d.getAge()+","+d.getDOB());
        }
        List<User_Address> alist = repo.addressList;
        for(int i = 0;i<alist.size();i++){
            User_Address ad = alist.get(i);
            System.out.println((i+1)+"."+ad.getadd_line1()+","+ad.getadd_line2()+","+ad.getpostal_Code()+","+ad.getcity()+","+ad.getcountry());
        }
    }
	

    private void persistRepository() {
        serialize("user_details.ser", repo.detailsList);
        serialize("user_address.ser", repo.addressList);
    }
    public void serialize(String file,Object obj){
        try {
           FileOutputStream fos = new FileOutputStream(file);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(obj); 
           oos.close();
           fos.close();
       } catch (Exception ex) {
          //ex.printStackTrace();
            System.out.println("No existing data present");
       }
    }
    public Object dser(String file){
       try {
           FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Object obj = ois.readObject(); //Deserialized object
           return obj;
       } catch (Exception ex) {
          // ex.printStackTrace();
           System.out.println("No existing data present");
           return null;
       }
    }

    private void restoreRepository() {
       List<User_Details> detailsList = (List<User_Details>) dser("user_details.ser");
        List<User_Address> addressList = (List<User_Address>) dser("user_address.ser");
        if(detailsList!=null){
            repo.detailsList = detailsList;
        }
        if(addressList!=null){
            repo.addressList = addressList;
        }
    }
	public void pressAnyKeyToContinue(){
        try{
        System.out.println("Press Any Key To Continue...");
        System.in.read();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
	public void onExit(){
        persistRepository();
        System.exit(0);
    }
}
