package com.Generalmethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import SPRautomation.StudentPeerReview.basePage;

public class Databaseconnection extends basePage{

	public String name, name1,name2;
	public Connection con;
	public Statement stmt;
	public static String studentinviteid;

	public Databaseconnection() {
		try {
			// Connection string
			String Url = prop.getProperty("DataBaseUrl");

			// connect to DB 
			con = DriverManager.getConnection(Url, prop.getProperty("Username"), prop.getProperty("Password"));

			// Establish the connection
			stmt = con.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//OTP from table
	public String sprotp(String UserEmail) throws SQLException {
		try {
			// Query execute
			ResultSet rs = stmt.executeQuery("SELECT * FROM manage_otp WHERE email='" + UserEmail + "';");
			rs.next();
			name = rs.getString(3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			

		}
		return name;
	}

	//Manage Password ID from table
	public String ManagePwId(String UserEmail) throws SQLException {
		try {
			// Query execute
			ResultSet rs = stmt.executeQuery(
					"select max(id) manage_password_id from manage_password where user_id=(select user_id from user where email like '"+UserEmail+"');");

			rs.next();

			name1 = rs.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name1;
	}
	
	//Manage Password ID from table
	public String InviteLink(String UserEmail,String CourseID) throws SQLException {
		try {
			// Query execute
			ResultSet rs = stmt.executeQuery(
					"select max(course_invite_id) course_invite_id from course_invite where email = '"+UserEmail+"' and status_id=5 and course_id=(select coalesce(course_id,0) from course where course_display_id='"+CourseID+"');");

			rs.next();

			name2 = rs.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name2;
	}



}
