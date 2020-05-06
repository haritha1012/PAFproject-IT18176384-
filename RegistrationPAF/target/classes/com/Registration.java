package com;

import java.sql.*;

public class Registration {
	
	
		private Connection connect()
		{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");

				
				con = DriverManager.getConnection("jdbc:mysql//localhost:3306/Registration", "root", "");
			}
			catch (Exception e)
			{e.printStackTrace();}
			return con;
		} 
		

		
		public String readReg()
		{
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{
					return "Error.!";
				}
				
				output = "<table border='1'><tr><th>UserID</th> <th>First Name</th><th>Last Name</th><th>Address</th><th>Date Of Birth</th><th>Phone No.</th><th>Email</th></tr>";
				String query = "select * from user";
				Statement statement = con.createStatement();
				ResultSet result = statement.executeQuery(query);
				
				while (result.next())
				{
					String No = Integer.toString(result.getInt("No"));
					String userid = result.getString("userid");
					String fname = result.getString("fname");
					String lname = result.getString("lname");
					String address = result.getString("address");
					String DoB = result.getString("DoB");
					String phone = result.getString("phone");
					String email = result.getString("email");

					
					output += "<tr><td><input id='hidNoUpdate'name='hidNoUpdate' type='hidden'value='" + userid + "'>" + fname + "</td>";output += "<td>" + lname + "</td>";output += "<td>" + address + "</td>";output += "<td>" + DoB + "</td>";output += "<td>" + phone + "</td>";output += "<td>" + email + "</td>"; 
				}
				con.close();
				
				output += "</table>";
			}
			catch (Exception e)
			{
				output = "Error.!";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		public String insertReg(int No, String userid, String fname,String lname, String address, String DoB, String phone, String email)
		{
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{
					return "Error.!";
				}
				
				String query = " insert into user('No',`userid`,`fname`,`lname`,`address`,`DoB`,'phone','email')"+ " values (?, ?, ?, ?, ?, ?,?,?)";
				PreparedStatement prestate = con.prepareStatement(query);
				
				prestate.setInt(1, 0);
				prestate.setString(2, userid);
				prestate.setString(3, fname);
				prestate.setString(4, lname);
				prestate.setString(5, address);
				prestate.setString(6, DoB);
				prestate.setString(7, phone);
				prestate.setString(8, email);
				
				prestate.execute();
				
				 System.out.print("Inserted Successfully :)");
				 
				con.close();
				String newReg = readReg();
				output = "{\"status\":\"success\", \"data\": \"" + newReg + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Can't insert data :(\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}

		
		public String updateReg(String No, String userid, String fname, String lname,String address, String DoB, String phone, String email)
		{
			String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
				{
					return "Error.!";
				}
				
				String query = "UPDATE user SET userid=?,fname=?,lname=?,address=?,DoB=?,phone=?,email=? WHERE No=?";
				PreparedStatement prestate = con.prepareStatement(query);
				
				prestate.setString(1, userid);
				prestate.setString(2, fname);
				prestate.setString(3, lname);
				prestate.setString(4, address);
				prestate.setString(5, DoB);
				prestate.setString(6, phone);
				prestate.setString(7, email);
				
				prestate.execute();
				con.close();
				String newReg = readReg();
				output = "{\"status\":\"success\", \"data\": \"" + newReg + "\"}";
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Can't update any data :(\"}";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		public String deleteReg(String No) {
			
			String output = "";
			
			try {
				Connection con = connect();
				if (con == null) {
					return "Error.!";
				}
				
				String query = "delete from user where No=?";
				PreparedStatement prestate = con.prepareStatement(query);
				
				prestate.setInt(1, 0);
				
				prestate.execute();
				con.close();
				
				String newReg = readReg();
				output = "{\"status\":\"success\", \"data\": \"" + newReg + "\"}";
			} catch (Exception e) {
			
				output = "{\"status\":\"error\", \"data\":\"Can't delete any user :(";
				
				System.err.println(e.getMessage());
			}
			return output;
		}

}
