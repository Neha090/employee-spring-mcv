package com.baeldung.freemarker.dto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import com.baeldung.freemarker.model.*;
import com.baeldung.freemarker.properties.Properties;

public class AddEmployee {

	public static void add(Employee emp) {
		try {
			Properties prop=new Properties();
			Class.forName(prop.getDatabseClass());
			Connection con = DriverManager.getConnection(prop.getDatabaseName(),prop.dbName(),prop.dbPass());
			
			CallableStatement csmt = con.prepareCall(prop.getAdd());
			csmt.setString(1, emp.getName());
			csmt.setInt(2, emp.getSalary());
			csmt.execute();

			csmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
