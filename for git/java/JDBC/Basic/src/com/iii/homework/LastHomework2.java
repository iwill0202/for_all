package com.iii.homework;

import java.io.*;
import java.sql.*;
import java.util.*;

public class LastHomework2 {
	public static void main(String[] args) {
		File file= new File(args[0]);
		String str;
		//int num =0;
		List<EmpData>data = new ArrayList<EmpData>();
		Connection conn = null;
			try {  
				BufferedReader in = new BufferedReader(new FileReader(file));
				while((str = in.readLine())!=null){
					String[] tokens=str.split(",");
					EmpData emp = new EmpData(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
					data.add(emp);
				}
				in.close();
				
				
				String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=jdbc";
				conn = DriverManager.getConnection(connUrl, "sa", "passw0rd");
				
				String insStmt= "INSERt INTO employee VALUES (?, ?, ?, ?, ?, ?)";;
				PreparedStatement pstmt = conn.prepareStatement(insStmt);
				for(int i=0;i<data.size();i++){
					pstmt.setString(1, (data.get(i)).getEmpno());
					pstmt.setString(2, (data.get(i)).getEname());
					pstmt.setString(3, (data.get(i)).getHiredate());
					pstmt.setString(4, (data.get(i)).getSalary());
					pstmt.setString(5, (data.get(i)).getDeptno());
					pstmt.setString(6, (data.get(i)).getTitle());
					pstmt.addBatch();
				}
				System.out.println(pstmt.executeBatch().length);
				pstmt.executeBatch();
							
				pstmt = conn.prepareStatement("SELECT * FROM employee");
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					System.out.print("No = " + rs.getString("empno") + ", ");
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
class EmpData{
	private String empno;
	private String ename;
	private String hiredate;
	private String salary;
	private String deptno;
	private String title;
	
	public EmpData(String empno, String ename, String hiredate, 
			String salary, String deptno, String title){
		this.empno=empno; 
		this.ename=ename;
		this.hiredate=hiredate;
		this.salary=salary;
		this.deptno=deptno;
		this.title=title;
	}

	public String getEmpno() {
		return empno;
	}

	public String getEname() {
		return ename;
	}

	public String getHiredate() {
		return hiredate;
	}

	public String getSalary() {
		return salary;
	}

	public String getDeptno() {
		return deptno;
	}

	public String getTitle() {
		return title;
	}
}
