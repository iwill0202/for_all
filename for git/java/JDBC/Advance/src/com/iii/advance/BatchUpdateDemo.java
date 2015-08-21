package com.iii.advance;

import java.sql.*;
import java.util.*;

public class BatchUpdateDemo {
	
	public static void main(String[] args) {
		Connection conn = null;

		try {     
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
			
			List<EmpRec> emps = new ArrayList<EmpRec>();
			String qryStmt = "SELECT empno, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpRec emp = new EmpRec(rs.getString(1),rs.getDouble(2));
				emps.add(emp);
			}
		
			String updateStmt = "UPDATE employee SET salary = ? WHERE empno = ?";
			pstmt = conn.prepareStatement(updateStmt);
			double currentSalary;
			for (int i = 0; i < emps.size(); i++) {
    			currentSalary = (emps.get(i)).getSalary() * 1.1;
   				pstmt.setDouble(1, currentSalary);
				pstmt.setString(2, (emps.get(i)).getEmpno());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
	
			qryStmt = "SELECT ename, salary FROM employee";
			pstmt = conn.prepareStatement(qryStmt);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("name = " + rs.getString("ename"));
				System.out.println("salary = " + rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class BatchUpdateDemo

	

