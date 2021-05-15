package Event_Managment_System; 

import java.sql.*; 
import java.sql.PreparedStatement;
import java.util.Scanner; 


class EventManagmentSystem {
   

    static Connection c; 
    static Statement ss; 
    static String query; 
    static ResultSet r; 
    static PreparedStatement ssp,spm; 

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
          
        conn c1 = new conn(); 

        try { 
            
            // SQL Connection
            
            c = c1.connect(); 
            ss = c.createStatement();
            
            // Customer or Admin ? For Admin Enter 0000 
            
            System.out.println("\n\nWelcome To Event Managment System");
            System.out.println("To Procced As User Enter (1) ");
            System.out.println("To Procced As Admin Enter The Code ");
            String or = ""; 

            or = input.nextLine();
            
            switch(or){
                
                case "1" :
                    
            //Start As Customer

            System.out.println("1-Create Account\n2-Book an Event\n3-Manage Booking\n4-Contact With Manager\n5-Exit"); 

            String x = ""; 

            x = input.nextLine();

            Customer customer = new Customer(); 

            switch (x) { 

                case "1": // Create Account 
                    
                    Customer.CreateAccount();
                    
                break; 

                case "2": 

                    // Book An Event 
                    
                    //PM_Send Date
                    
                    Project_Manager.PM_DB_MOD();
                    
                    //SP_Send Date
                    
                    Service_Provider.SP_DB_MOD();
                    
                    //Book Event
                    
                    Customer.Book_Event();                    

                    break; 

                case "3": 

                    // Manage Event 

                    Customer.Manage_Event();

                    break; 

                case "4": 

                    // Customer Feedback 
                    
                    Project_Manager.Feed_Back();

                    break;

                    case "5":System.exit(0); break;

                    default: System.out.println("You Entered A Wrong Choice");

            }    
                       
                break;
                
                case "0000" :
                
                //Start As Admin                        
                
                Admin.AD_Menu();                 
                
                break;
                
                default: System.out.println("You Entered A Wrong Choice");
    
            }
      
            }catch (SQLException ee ) { 
                System.out.println(ee.getMessage()); 
            }            
    } 
} 
