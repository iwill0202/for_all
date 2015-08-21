package com.iii.homework;

import java.io.*;
import java.sql.*;
//import java.util.*;
// Insert one employee
public class LastHomework {
	public static void main(String[] args) {
		File file= new File(args[0]);
		String str;
		int num =0;
		//List<StringBuilder>data = new ArrayList<StringBuilder>();
		Connection conn = null;
			try {   
				String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
				conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
				
				String insStmt= "INSERt INTO employee VALUES (?, ?, ?, ?, ?, ?)";;
				PreparedStatement pstmt = conn.prepareStatement(insStmt);
				BufferedReader in = new BufferedReader(new FileReader(file));
				while((str = in.readLine())!=null){
					String[] tokens = str.split(",");
					pstmt.setString(1, tokens[0]);
					pstmt.setString(2, tokens[1]);
					pstmt.setString(3, tokens[2]);
					pstmt.setString(4, tokens[3]);
					pstmt.setString(5, tokens[4]);
					pstmt.setString(6, tokens[5]);
					num += pstmt.executeUpdate();
					
				}
				in.close();
				System.out.println("insert count = " + num);
				
				pstmt = conn.prepareStatement("SELECT * FROM employee");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.print("name = " + rs.getString("ename") + ", ");
					System.out.print("hiredate = " + rs.getString("hiredate") + ", ");
					System.out.println("salary = " + rs.getDouble("salary"));
				}
			}catch(IOException io){
				System.err.println("File in error");
			}catch (SQLException sql) {
				if(sql.getErrorCode()==2627)
				System.err.println("Data duplicate!");
				//System.err.println("Vendor code:"+e.getErrorCode());
			} 
			
	}// end of main()
}// end of class InsertDemo