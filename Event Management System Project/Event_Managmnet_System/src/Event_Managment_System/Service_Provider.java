package Event_Managment_System;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
   

public class Service_Provider {
       
    
//    public static void main(String[] args) {
//        
//        // Service Provider Database modification
//            
//            SP_DB_MOD();
//            
//        // Customer Request Send To Admin
//            
//            CST_sendRequest_AD();
//            
//        // Admin Request Send To PM
//            
//            SP_sendRequest_PM();  
//                      
//    }
    
    // SQL Variables    
    
    static Connection c;
    static Statement ss;
    static PreparedStatement s;
    static String query;
    static ResultSet r ;

        public static void SP_DB_MOD(){
        
        conn c1 = new conn();
        try{
            c= c1.connect();
            
      
                query=    "update Event set Edate='31/1/2021' WHERE eventID = 1"
                        + "update Event set Edate='30/1/2021' WHERE eventID = 2"
                        + "update Event set Edate='29/1/2021' WHERE eventID = 3";
                
                s=c.prepareStatement(query);
                s.execute();
           
        }catch(SQLException ee)
        {
            System.out.println(ee.getMessage());
        }
        
    }    

    
    
    
// Customer Request Send To Admin
        public static void CST_sendRequest_AD( int id_user , int booking ){

            conn c1 = new conn();

            try{
                c= c1.connect();


                query= "insert into Request (req_id_user,req_id_event) values (?,?)";

                s=c.prepareStatement(query);
                s.setInt(1,id_user);
                s.setInt(2,booking);
                s.execute();

                System.out.println("Request Database Modification From Customer OK");


            }catch(SQLException ee){
                System.out.println(ee.getMessage());
            }

        }
                
// SP Request Send To PM

    public static void SP_sendRequest_PM(){

        conn c1 = new conn();

        try{
            c= c1.connect();

            query=   "update Request set req_bill = 2000 , req_date = '31/1/2021' WHERE req_id_event = 1"
                   + "update Request set req_bill = 1500 , req_date = '30/1/2021' WHERE req_id_event = 2"
                   + "update Request set req_bill = 1000 , req_date = '29/1/2021' WHERE req_id_event = 3";

            s=c.prepareStatement(query);
            s.execute();

            System.out.println("Request Database Modification From SP OK\n");


        }catch(SQLException ee){
            System.out.println(ee.getMessage());
        }
    }


}



