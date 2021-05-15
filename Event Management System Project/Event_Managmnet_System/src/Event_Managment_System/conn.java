package Event_Managment_System;

// Connection Class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conn {

    private String uri="jdbc:sqlserver://localhost:1433;databaseName=Event_Managment_System;user=akt;password=123";
    public Connection connect() throws SQLException{
      
        Connection r=DriverManager.getConnection(uri);
        return r;
        
    }
}    
