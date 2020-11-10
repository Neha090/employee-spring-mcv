package com.baeldung.freemarker.properties;

public class Properties {

	private String databaseClass = "oracle.jdbc.driver.OracleDriver";
	private String databaseName = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String dbName = "system";
	private String dbPass = "sysadmin";;
	private String showAll = "{call AllData(?)}";
	private String update = "{call update_employee(?,?,?)}";
	private String delete = "{call delete_employee(?)}";
	private String add = "{call Create_employee(?,?)}";
	
	public Properties(){}

	public String getDatabseClass() {
		return this.databaseClass;
	}

	public void getDatabseClass(String databaseClass) {
		this.databaseClass = databaseClass;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void getDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getShowAll() {
		return this.showAll;
	}

	public void getShowAll(String showAll) {
		this.showAll = showAll;
	}

	public String dbName() {
		return this.dbName;
	}

	public void dbName(String dbName) {
		this.dbName = dbName;
	}

	public String dbPass() {
		return this.dbPass;
	}

	public void dbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public String getUpdate() {
		return this.update;
	}

	public void setUpdate(String update) {
		this.update = update;
	}

	public String getDelete() {
		return this.delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getAdd() {
		return this.add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

}
