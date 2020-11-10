
package com.baeldung.freemarker.dto;
import com.baeldung.freemarker.properties.Properties;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import com.baeldung.freemarker.model.Employee;

public class UpdateEmployee {
	public static void update(int id,Employee emp) {
		try {
			
			Properties prop=new Properties();

			Class.forName(prop.getDatabseClass());
			Connection con = DriverManager.getConnection(prop.getDatabaseName(),prop.dbName(),prop.dbPass());

			CallableStatement csmt = con.prepareCall(prop.getUpdate());
			csmt.setString(2, emp.getName());
			csmt.setInt(3, emp.getSalary());
			csmt.setInt(1, id);
			csmt.execute();

			csmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
}
