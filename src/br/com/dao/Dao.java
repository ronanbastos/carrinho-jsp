package br.com.dao;

import java.sql.*;
public class Dao {
	protected Connection con;
	protected PreparedStatement stmt,stmt2;
	protected ResultSet rs;
	
	String URL   = "jdbc:mysql://localhost:3306/lojavirtual";
	String USER  = "root";
	String PASS  = "";
	
	protected void open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void close() {
		try {
			if(con != null) {
				con.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

}
}
