package com.iii.classpractice;

import java.sql.*;
// Insert one employee
public class InsertDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
		/*	//第一種解法
			Calendar now = Calendar.getInstance();
			int year=now.get(Calendar.YEAR);
			int month=now.get(Calendar.MONTH)+1;
			int date=now.get(Calendar.DATE);
			//pstmt.setString(3, year+"/"+month+"/"+date);
		*/	
		/*	//第二種解法    import java.text.*;
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			//pstmt.setString(3, df.format(new java.util.Date()));
		*/
		/*	//第三種解法   import java.sql.Date;
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			//pstmt.setString(3, df.format(new java.util.Date()));
		*/
		/*	//第四種解法   直接從sql下 大部分 datebase 和client端時區有可能不一樣  抓到的時間 DB抓的!=client抓的
			String insStmt = "INSERT INTO employee VALUES (?, ?, getdate(), ?, ?, ?)";
		*/
			
			String insStmt = "INSERt INTO employee VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insStmt);
			pstmt.setString(1, "1011");
			pstmt.setString(2, "Jean Tsao");
			pstmt.setString(3, "2008/10/10");
			pstmt.setString(4, "55000");
			pstmt.setString(5, "100");
			pstmt.setString(6, "senior engineer");
			
			int num = pstmt.executeUpdate();
			System.out.println("insert count = " + num);
			
			pstmt = conn.prepareStatement("SELECT * FROM employee");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename") + ", ");
				System.out.print("hiredate = " + rs.getString("hiredate") + ", ");
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			if(e.getErrorCode()==2627)
			System.err.println("Data duplicate!");
			//System.err.println("Vendor code:"+e.getErrorCode());
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class InsertDemo
