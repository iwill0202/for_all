package com.iii.advance;

import java.sql.*;
import java.util.*;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
			conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");

			// find all employee numbers
			List<EmpRec> emps = new ArrayList<EmpRec>();
			String qryStmt = "SELECT empno, salary FROM employee";
			PreparedStatement pstmt = conn.prepareStatement(qryStmt);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpRec emp = new EmpRec(rs.getString(1),rs.getDouble(2));
				emps.add(emp);
			}

			conn.setAutoCommit(false);
			// Raise every employee salary 5%
			String upd_stmt = "UPDATE employee SET salary = ? WHERE empno = ?";
			pstmt = conn.prepareStatement(upd_stmt);
			double currentSalary;
		/*
			for (int i = 0; i < emps.size(); i++) {
				currentSalary = (emps.get(i)).getSalary() * 1.05;
				pstmt.setDouble(1, currentSalary);
				pstmt.setString(2, (emps.get(i)).getEmpno());
				pstmt.executeUpdate();
			}
		*/
			for (EmpRec emp:emps) {  // for each 
				currentSalary = emp.getSalary() * 1.05;
				pstmt.setDouble(1, currentSalary);
				pstmt.setString(2, emp.getEmpno());
				pstmt.executeUpdate();
			}
			
			conn.commit();

			// reset total salary in department
			upd_stmt = "UPDATE department SET totalsalary=0";
			pstmt = conn.prepareStatement(upd_stmt);
			pstmt.executeUpdate();
			conn.commit();

			// update total salary in department
			pstmt = conn.prepareStatement("SELECT deptno FROM department");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				upd_stmt = "UPDATE department SET totalsalary = "
						+ "(SELECT SUM(salary) FROM employee WHERE deptno = department.deptno) "
						+ " WHERE deptno = ?";
				pstmt = conn.prepareStatement(upd_stmt);
				pstmt.setString(1, rs.getString("deptno"));
				pstmt.executeUpdate();
			}
			conn.commit();

			conn.setAutoCommit(true);

			pstmt = conn.prepareStatement("SELECT * FROM department");
			rs = pstmt.executeQuery();

			System.out.printf("%10s %20s %20s %n", "deptno", "dname",
					"total salary");
			while (rs.next()) {
				System.out.printf("%10s %20s %20.1f %n",
						rs.getString("deptno"), rs.getString("dname"),
						rs.getDouble("totalsalary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				System.err.println("Transaction is being rolled back");
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}// end of main()
}// end of class TransactionDemo
