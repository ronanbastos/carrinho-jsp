package br.com.dao;

import br.com.entidade.Admin;

import java.sql.*;


public class AdminDao extends Dao {
	public Admin consultarLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException{
		open();
		String sql = "select * from admin where login = ? and senha = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);
	
		
		rs = stmt.executeQuery();
		
		Admin admin = null;
		
		if(rs.next()){
			admin = new Admin(rs.getString("login"), 
							  rs.getString("senha"));
							 			
		}
		close();
		return admin;
	}

	public Admin login(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}
}
