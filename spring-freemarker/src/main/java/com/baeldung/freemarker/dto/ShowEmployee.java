package com.baeldung.freemarker.dto;

import com.baeldung.freemarker.controller.SpringController;
import com.baeldung.freemarker.model.Employee;
import com.baeldung.freemarker.properties.Properties;

import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

public class ShowEmployee {

	public static List<Employee> display() {

		try {
			Properties prop=new Properties();
			Class.forName(prop.getDatabseClass());
			Connection con = DriverManager.getConnection(prop.getDatabaseName(),prop.dbName(),prop.dbPass());
			CallableStatement csmt = (CallableStatement) con.prepareCall(prop.getShowAll());
			csmt.registerOutParameter(1, OracleTypes.CURSOR);

			csmt.execute();
			OracleResultSet rs = (OracleResultSet) csmt.getObject(1);
			SpringController.setEmpList(new ArrayList());
			while (rs.next()) {
				SpringController.getEmpList().add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

			csmt.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return SpringController.getEmpList();
	}
}
