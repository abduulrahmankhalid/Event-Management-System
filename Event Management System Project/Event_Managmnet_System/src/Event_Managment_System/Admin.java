package Event_Managment_System;

import java.sql.*;
import java.util.*;

public class Admin {
  
public static void AD_Menu() throws SQLException {
  
conn c1=new conn();
c1. connect();
int i;
int x;//no of action
Scanner input=new Scanner(System.in);
do{
  System.out.println
        ("\n\n^_^WELCOME IN ADMIN^_^\n\n1-add_customer\n2-add_Project_Manager\n3-add_Service_Provider\n4-add_admin\n\n"
          + "5-delete_customer\n6-delete_Project_Managers\n7-delete_Service_Provider\n8-delete_admin\n\n"
          + "9-update_customer\n10-update_Project_Manager\n11-update_Service_Provider\n12-update_admin\n\n");
    System.out.print("\nEnter the number of opration:");
    x=input.nextInt();
switch(x)
{
    
case 1:
Manage.add_customer();
break;
case 2:
Manage.add_pm();
break;
case 3:
Manage.add_sp();
break;
case 4:
Manage.add_ad();    
break;
case 5:
Manage.delete_customer();    
break;
case 6:
Manage.delete_pm();    
break;
case 7:
Manage.delete_sp();    
break;
case 8:
Manage.delete_admin();    
break;
case 9:
Manage.update_customer();    
break; 
case 10:
Manage.update_pm();    
break; 
case 11:
Manage.update_sp();    
break; 
case 12:
Manage.update_ad();
break;

}   

    System.out.print("press(1) to another opration or press (0) to Exit: ");
    i=input.nextInt();
    
}while(i==1);
}

}
    

