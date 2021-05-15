package Event_Managment_System;

import java.sql.*; 
import java.sql.PreparedStatement;
import java.util.Scanner; 
import java.sql.SQLException;

public class Customer { 

    public String Email; 

    public String Fname; 

    public String Lname; 

    public final int ID; 

    public  String Pass; 

    public int Id_Event; 

public Customer(){ 

    this.Email=""; 

    this.Fname=""; 

    this.Lname=""; 

    this.ID=(int) (Math.random()*250)+1; 

    this.Pass = ""; 

} 

public int getID(){ 

    return this.ID ; 

} 

public void setCustomerFname(String Fname ){ 

    this.Fname=Fname; 

} 

public void setCustomerLname(String Lname){ 

    this.Lname=Lname; 

} 

public void setCustomerEmail(String Email){ 

    this.Email=Email; 

} 

public String getCustomerEmail(){ 

    return this.Email ; 

} 

public String getCustomerFname(){ 

    return this.Fname ; 

} 

public String getCustomerLname(){ 

    return this.Lname ; 

} 

public void setCustomerPass(String pass){ 

    this.Pass=pass; 

} 

public void setEventId(int eID){ 

    this.Id_Event=eID; 

} 

public String getPass(){ 

    return this.Pass ; 

} 
 
             
    static Connection c; 
    static Statement ss; 
    static String query; 
    static ResultSet r; 
    static PreparedStatement ssp,spm; 


public static void CreateAccount() throws SQLException{
        
    Scanner input = new Scanner(System.in);
    conn c1 = new conn();
    
    Customer customer = new Customer(); 
        try { 
            // SQL Connection
                    c = c1.connect(); 
            ss = c.createStatement();
        System.out.print("Please Enter Your First Name =  "); 

                    String fname = input.nextLine(); 

                    customer.setCustomerFname(fname); 

                    System.out.print("Please Enter Your Last Name = "); 

                    String lname = input.nextLine(); 

                    customer.setCustomerLname(lname); 

                    System.out.print("Please Enter Your Email = "); 

                    String email = input.nextLine(); 

                    customer.setCustomerEmail(email); 

                    System.out.print("Please Enter Your Password = "); 

                    String pass = input.nextLine(); 

                    customer.setCustomerPass(pass);
                    
                    int id = customer.getID();
                    
                    query = "insert into Customer (Email,Fname,Lname,ID_User,Pass) values('" + email + "','" + fname + "','" + lname + "','" + id + "','" + pass + "')";

                    ssp=c.prepareStatement(query); 

                    ss.execute(query); 

                    System.out.println("Your Regestration Has Been Succesfully");                 
                    
                    System.out.println("Your ID = " + id);                                       
                    
                    System.out.println("");
        
        
        }catch (SQLException ee ) { 
                System.out.println(ee.getMessage()); 
            }  

}

public static void Book_Event() throws SQLException{

        Scanner input = new Scanner(System.in);
        conn c1 = new conn();
        Customer customer = new Customer();
        
        try { 
            // SQL Connection
                    c = c1.connect(); 
            ss = c.createStatement();

            System.out.println("\nChoose The Event ID You Want To Book"); 

            System.out.println(""); 

            System.out.println("ID" + "\t\t\t" + "Bill" + "\t\t\t" + "Date" + "\t\t\t" + "Name"); 

            System.out.println("-----------------------------------------------------------------------------------"); 

            query = "select * from Event"; 

            r = ss.executeQuery(query); 

            // Show Event DB 

            while (r.next()) { 

                System.out.print(r.getInt("eventID") + "\t\t\t"); 

                System.out.print(r.getInt("Ebill") + "\t\t\t"); 

                System.out.print(r.getString("Edate") + "\t\t\t"); 

                System.out.print(r.getString("Name") + "\t\t\t"); 

                System.out.println(""); 

            } 

            System.out.println("-----------------------------------------------------------------------------------"); 

            int booking = input.nextInt();

            customer.setEventId(booking);

            System.out.println("\nEnter Your ID = "); 

            int id_user = input.nextInt(); 

            // Update DB of Customer --> update Event_ID through ID_User 

            query = "update Customer set ID_Event = '"+booking+"' where ID_User ='"+id_user+"'"; 

            ss.execute(query);
            
            // Customer Request Send To Admin
                    
                    Service_Provider.CST_sendRequest_AD(id_user,booking);                   
                    
                    // SP Request Send To PM
                    
                    Service_Provider.SP_sendRequest_PM();
                                                              
                    
                    // Show Pass from Customer DB through ID_User 
                    
                    query="select Pass from Customer where ID_User = '"+id_user+"'";    

                    r=ss.executeQuery(query); 

                    ResultSetMetaData rm = r.getMetaData(); 

                    int columnNumber = rm.getColumnCount(); 

                    while(r.next()){ 

                        for(int i = 1;i<=columnNumber;i++){ 

                            if(i>1){ 
                                System.out.println(" "); 
                            } 

                            String columnValue = r.getString(i); 

                            System.out.println(rm.getColumnName(i)+" = " + columnValue);        

                        }
                                           
                        System.out.println("");                       
                    }
                    
            }catch (SQLException ee ) { 
                System.out.println(ee.getMessage()); 
            }     

}


public static void Manage_Event() throws SQLException{
        
        Scanner input = new Scanner(System.in);
        conn c1 = new conn();
        Customer customer = new Customer();
        
        try { 
            // SQL Connection
                    c = c1.connect(); 
            ss = c.createStatement();
    
        System.out.println("Enter your ID "); 

        int iduser = input.nextInt(); 

        System.out.println("1- choose another event \n2- delete your booking"); 

        int dataChosen; 

        dataChosen = input.nextInt(); 

        switch (dataChosen) { 

            case 1: // Update On A Customer

                int idEvent; 

                Statement stmt = c.createStatement(); 

                String query2 = "SELECT ID_Event FROM Customer where ID_User=" + iduser; 

                ResultSet rs = stmt.executeQuery(query2); 

                ResultSetMetaData rsmd = rs.getMetaData(); 

                int columnsNumber = rsmd.getColumnCount(); 

                while (rs.next()) { 

                    for (int i = 1; i <= columnsNumber; i++) { 

                        if (i > 1) { 

                            System.out.print(",  "); 

                        } 

                        String columnValue = rs.getString(i); 

                        System.out.print(columnValue + " " + rsmd.getColumnName(i)); 

                    } 

                    System.out.println(""); 

                } 

                System.out.print("Choose The Event ID You Want To Book"); 

                System.out.println(""); 

                System.out.println("ID" + "\t\t\t" + "Bill" + "\t\t\t" + "Date" + "\t\t\t" + "Name"); 

                System.out.println("-----------------------------------------------------------------------------------"); 

                query = "select * from Event"; 

                r = ss.executeQuery(query); 

                // Show Event DB 

                while (r.next()) { 

                    System.out.print(r.getInt("eventID") + "\t\t\t"); 

                    System.out.print(r.getInt("Ebill") + "\t\t\t"); 

                    System.out.print(r.getString("Edate") + "\t\t\t"); 

                    System.out.print(r.getString("Name") + "\t\t\t"); 

                    System.out.println(""); 

                } 

                System.out.println("-----------------------------------------------------------------------------------"); 

                idEvent = input.nextInt(); 

                query =  "update Customer set ID_Event=" + idEvent + " where ID_User=" + iduser
                        +"update Request set req_id_event=" + idEvent + " where req_id_user=" + iduser; 

                ssp = c.prepareStatement(query);

                ssp.executeUpdate();

                // SP Request Send To PM

                Service_Provider.SP_sendRequest_PM();

                System.out.println("Your Event Has Been Updated"); 

                break; 

            case 2: // Delete A Customer

                query =  "DELETE FROM Request WHERE req_id_user =" + iduser
                        +"DELETE FROM Customer WHERE ID_User =" + iduser; 

                ssp = c.prepareStatement(query); 

                ssp.executeUpdate(); 

                break; 

            default: 

                System.out.println("you entered wrong input"); 

        }
        
            }catch (SQLException ee ) { 
                System.out.println(ee.getMessage()); 
            }
}
}