package Event_Managment_System;

import java.util.*;
import java.sql.*;
import java.sql.PreparedStatement;

    class Project_Manager {
    
    static Connection c ;
    static Statement sss;
    static String query , query1;
    static PreparedStatement ss , ss1,ssp;

    
    public static void PM_FeedBack(){
        
        conn c1 = new conn();
        try{
            c= c1.connect();
            String pm_response = "We Glad To Hear Your Opinion And We Will Answer You Soon";
            String query1 = "insert into Feed_Back (PM_response) VALUES ('" + pm_response + "')";
            ss1=c.prepareStatement(query1); 

            ss1.executeUpdate();
           
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }
        
    }
        
        public static void PM_DB_MOD(){
        
        conn c1 = new conn();
        try{
            c= c1.connect();
            
      
                query1=   "update Event set Ebill=2000  WHERE eventID = 1"
                        + "update Event set Ebill=1500  WHERE eventID = 2"
                        + "update Event set Ebill=1000  WHERE eventID = 3";
                
                ss=c.prepareStatement(query1);
                ss.execute();
           
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }
        
    }
        
    public static boolean numberOrNot (String input)
    {
        try{
            Integer.parseInt(input);
            return true ;
        }catch(NumberFormatException ex)
        {
            System.out.println("Wrong Input Please Try Again");
            return false ;
        }
    }    
        
public static void Feed_Back() throws SQLException{
            Scanner input = new Scanner(System.in);
        conn c1 = new conn();
    try { 
            // SQL Connection
                    c = c1.connect(); 
            sss = c.createStatement();
    
    
    Customer customer = new Customer();

    System.out.println("please enter your feedback here "); 

    String feedBack=""; 

    feedBack = input.nextLine(); 

    String query = "insert into Feed_Back (customer_response) VALUES ('" + feedBack + "')"; 

    ssp = c.prepareStatement(query); 

    ssp.executeUpdate();

    // PM Feed Back

    Project_Manager.PM_FeedBack();

    // Show Feed Back

    query = "SELECT PM_response FROM Feed_Back"; 

    Statement stmt = c.createStatement(); 

    ResultSet rset = stmt.executeQuery(query); 

    int rowCount = 0; 

    String LastRow = ""; 

    while (rset.next()) { 

        LastRow = rset.getString("PM_response"); 

    } 

    System.out.println(LastRow);
    
}
    catch (SQLException ee ) { 
                System.out.println(ee.getMessage()); 
            }

}    
} 
