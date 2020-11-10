
 package com.baeldung.freemarker.dto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.baeldung.freemarker.properties.Properties;

public class DeleteEmployee {
    
	public static void delete(int id)
     {
    	 try
    	 {
    		 Properties prop=new Properties();
    		 Class.forName(prop.getDatabseClass());
 			Connection con = DriverManager.getConnection(prop.getDatabaseName(),prop.dbName(),prop.dbPass());
 		
 		CallableStatement csmt = con.prepareCall(prop.getDelete());
 		csmt.setInt(1,id);
 		csmt.execute();
 		
 		csmt.close();
 		}
 		catch(Exception e)
 		{
 			System.out.println(e);
 		}
     }
}
