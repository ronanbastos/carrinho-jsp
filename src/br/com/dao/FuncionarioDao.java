package br.com.dao;

import java.sql.*;

import java.util.*;


import br.com.entidade.Funcionario;

public class FuncionarioDao extends Dao {
	public void adicionar(Funcionario funcionario) throws ClassNotFoundException {
		String sql = "insert into funcionario " + "(nomefuncionario,cargo,cpf,login,senha)" + " values (?,?,?,?,?)";
		String sql1="insert into admin" +"(nome,login,senha)" + " values (?,?,?)";

		try {
			// prepared statement para inserção
			open();
			stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, funcionario.getNomefuncionario());
			stmt.setString(2, funcionario.getCargo());
			stmt.setString(3, funcionario.getLogin());
			stmt.setString(4, funcionario.getSenha());
			stmt.setString(5, funcionario.getCpf());
			
			stmt2 = con.prepareStatement(sql1);
			stmt2.setString(1, funcionario.getNomefuncionario());
			stmt2.setString(2, funcionario.getLogin());
			stmt2.setString(3, funcionario.getSenha());
			

			// executa
			stmt.execute();
			stmt2.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Funcionario> listafuncionario(String cpf) throws ClassNotFoundException, SQLException {

		open();

		stmt = this.con.prepareStatement("select * from funcionario where cpf = ?");
		stmt.setString(1, cpf);

		rs = stmt.executeQuery();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		while (rs.next()) {			// criando o objeto Cliente
			Funcionario funcionario = new Funcionario();
			funcionario.setCodfuncionario(rs.getInt("codfuncionario"));
			funcionario.setNomefuncionario(rs.getString("nomefuncionario"));
			funcionario.setCargo(rs.getString("cargo"));
			funcionario.setLogin(rs.getString("login"));
			funcionario.setSenha(rs.getString("senha"));
			funcionario.setCpf(rs.getString("cpf"));

			// adicionando o objeto à lista
			funcionarios.add(funcionario);
		}
		
		return funcionarios;

	}
	public Funcionario buscarFuncionario(String cpf) throws SQLException, ClassNotFoundException {

		open();
		String sql = "SELECT * FROM cliente WHERE cpf  = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, cpf);
		Funcionario funcionario = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			funcionario = new Funcionario(rs.getInt("codfuncionario"), rs.getString("nomefuncionario"), rs.getString("cargo"),
					rs.getString("login"), rs.getString("senha"), rs.getString("cpf"));
		}
		//close();
		return funcionario;

	}
	public void editar(Funcionario funcionario) throws ClassNotFoundException {
		String sql = "update funcionario set nomefuncionario=?, cargo=?, login=?, senha=? where cpf=?";

		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getNomefuncionario());
			stmt.setString(2, funcionario.getCargo());
			stmt.setString(4, funcionario.getLogin());
			stmt.setString(5, funcionario.getSenha());
			stmt.setString(6, funcionario.getCpf());
			stmt.setInt(7, funcionario.getCodfuncionario());

			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
