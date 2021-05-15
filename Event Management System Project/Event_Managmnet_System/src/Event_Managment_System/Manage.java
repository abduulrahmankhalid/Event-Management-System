package Event_Managment_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Manage {
    static Connection c ;
    static Statement ss;
    static String query;
    @SuppressWarnings("null")   
    
        //delete customer by  admin

    public static void add_customer(){
                conn c1 = new conn();
        try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            Customer customer = new Customer();
            System.out.print("Please Enter customer First Name = ");
            String fname = input.nextLine();
            customer.setCustomerFname(fname);
            System.out.print("Please Enter customer Last Name = ");
            String lname = input.nextLine();
            customer.setCustomerLname(lname);
            System.out.print("Please Enter customer Email = ");
            String email = input.nextLine();
            customer.setCustomerEmail(email);
            System.out.print("Please Enter customer Password = ");
            String pass = input.nextLine();
            customer.setCustomerPass(pass);
            int id=customer.getID();
            query="insert into Customer (Email,Fname,Lname,ID_User,Pass) values('"+email+"','"+fname+"','"+lname+"','"+id+"','"+pass+"')";
            ss.execute(query);
            System.out.println("done; the customer have added ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }       
    }
    
    
    //delete customer by  admin
    public static void delete_customer()
{
      int id;
      conn c1 = new conn();
        try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            System.err.print("delete customer who id =  ");
            id=input.nextInt();
            query=  "delete from Customer where ID_User='"+id+"'"
                   +"delete from Request where req_id_user='"+id+"'";
            ss.execute(query);
            System.out.println("done; the customer have deleted ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }   
}
 public static void update_customer(){
  int new_eid;   
  int id;
      conn c1 = new conn();
        try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            System.err.print("id of customer who will have update =  ");
            id=input.nextInt();
            System.err.print("enter new event id: ");
            new_eid=input.nextInt();
           
            query=  "update Customer set ID_Event='"+new_eid+"' where ID_User='"+id+"'"
                   +"update Request set req_id_event='"+new_eid+"' where req_id_user='"+id+"'";
            ss.execute(query);
            
            // SP Request Send To PM
                    
            Service_Provider.SP_sendRequest_PM();
            
            System.out.println("done; the customer have edit ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    } 
 static String query1;
 static  PreparedStatement query2;
 public static void add_sp(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

           Scanner input = new Scanner(System.in);
           System.out.print("Enter new Service_Provider name name");
           String sp_name = input.nextLine();
          query1="insert into Service_Provider (Name) values('"+sp_name+"')"; 
          query2  =c.prepareStatement(query1);
          query2.execute();
           System.out.println("done; new Service_Provider addeed");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    } 
  public static void add_pm(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

           Scanner input = new Scanner(System.in);
           System.out.print("Enter new Project_Manager  name:");
           String pm_name = input.nextLine();
          query1="insert into Project_Managers (pname) values('"+pm_name+"')"; 
          query2  =c.prepareStatement(query1);
          query2.execute();
           System.out.println("done;Project_Manager has addeed");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    } 
  public static void add_ad(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

           Scanner input = new Scanner(System.in);
           System.out.print("Enter new admin name name:");
           String ad_name = input.nextLine();
          query1="insert into Admin (AdminName) values('"+ad_name+"')"; 
          query2  =c.prepareStatement(query1);
          query2.execute();
           System.out.println("done;new admin addeed");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }
  
   public static void update_pm(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

     Scanner input = new Scanner(System.in);
           System.out.print("enter the Project_Manager_ssn which will be updated:");
                         int PM_ssn=input.nextInt();
                        String pm_name="";
           System.out.println("Enter new pm name name");
                         pm_name = input.next();
          query1="update Project_Managers set pname='"+pm_name+"' where pm_ssn="+PM_ssn; 
          query2  =c.prepareStatement(query1);
          query2.executeUpdate();
           System.out.println("done;Project_Manager updated");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  

    }
   
      public static void update_sp(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

     Scanner input = new Scanner(System.in);
           System.out.print("enter the Service_Provider_ssn which will be updated:");
                         int sp_ssn=input.nextInt();
                        String sp_name="";
           System.out.print("Enter new Service_Provider name:");
                         sp_name = input.next();
          query1="update Service_Provider set Name='"+sp_name+"' where sp_ssn="+sp_ssn; 
          query2  =c.prepareStatement(query1);
          query2.executeUpdate();
           System.out.println("done; Service_Provider updated");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }
            
        public static void update_ad(){
 
         conn c1 = new conn();
      
        try{
          c= c1.connect();

     Scanner input = new Scanner(System.in);
           System.out.print("enter the Admin_ssn which will be updated");
                         int ad_ssn=input.nextInt();
                        String ad_name="";
           System.out.print("Enter new Admin name name : ");
                         ad_name = input.next();
          query1="update Admin set AdminName='"+ad_name+"' where admin_ssn="+ad_ssn; 
          query2  =c.prepareStatement(query1);
          query2.executeUpdate();
           System.out.println("done;admin updated");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }
                
        public static void delete_admin()
        {   
            int id;
            conn c1 = new conn();
            try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            System.err.print("delete admin who ssn =  ");
            int ssn=input.nextInt();
            query="delete from Admin where admin_ssn='"+ssn+"'";
            ss.execute(query);
            System.out.println("done; the admin have deleted ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }   
     
    public static void delete_sp()
        {
            int id;
            conn c1 = new conn();
             try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            System.err.print("delete Service_Provider who ssn =  ");
            int ssn=input.nextInt();
            query="delete from Service_Provider where sp_ssn='"+ssn+"'";
            ss.execute(query);
            System.out.println("done; the Service_Provider have deleted ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }
        
        public static void delete_pm()
        {
            int id;
            conn c1 = new conn();
            try{
            c= c1.connect();
            ss=c.createStatement();
            Scanner input = new Scanner(System.in);
            System.err.print("delete Project_Manager who ssn =  ");
            int ssn=input.nextInt();
            query="delete from Project_Managers where pm_ssn='"+ssn+"'";
            ss.execute(query);
            System.out.println("done; the Project_Manager have deleted ");
//            System.out.println("ok");
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }  
    }
        
}

