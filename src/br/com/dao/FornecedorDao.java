package br.com.dao;
import java.sql.*;

import java.util.*;


import br.com.entidade.Fornecedor;


public class FornecedorDao extends Dao {
	public void adicionar(Fornecedor fornecedor) throws ClassNotFoundException {
		String sql = "insert into fornecedor " + "(nomefornecedor,cnpj,telefone,email,endereco)" + " values (?,?,?,?,?)";
		

		try {
			// prepared statement para inserção
			open();
			stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, fornecedor.getNomefornecedor());
			stmt.setString(2, fornecedor.getCnpj());
			stmt.setString(3, fornecedor.getTelefone());
			stmt.setString(4, fornecedor.getEmail());
			stmt.setString(5, fornecedor.getEndereco());
			
		
			

			// executa
			stmt.execute();
			
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Fornecedor> listafornecedores(String cnpj) throws ClassNotFoundException, SQLException {

		open();

		stmt = this.con.prepareStatement("select * from fornecedor where cnpj = ?");
		stmt.setString(1, cnpj);

		rs = stmt.executeQuery();
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

		while (rs.next()) {			// criando o objeto Cliente
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setIdfornecedor(rs.getInt("idfornecedor"));
			fornecedor.setNomefornecedor(rs.getString("nomefornecedor"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setEmail(rs.getString("email"));
			fornecedor.setEndereco(rs.getString("endereco"));

			// adicionando o objeto à lista
			fornecedores.add(fornecedor);
		}
		
		return fornecedores;

	}
	public Fornecedor buscarfornecedor(String cnpj) throws SQLException, ClassNotFoundException {

		open();
		String sql = "SELECT * FROM fornecedor WHERE cnpj  = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, cnpj);
		Fornecedor fornecedor = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			fornecedor = new Fornecedor(rs.getInt("idfornecedor"), rs.getString("nomefornecedor"), rs.getString("cnpj"),
					rs.getString("telefone"), rs.getString("email"), rs.getString("endereco"));
		}
		//close();
		return fornecedor;

	}

	public void editar(Fornecedor fornecedor) throws ClassNotFoundException {
		String sql =
"update fornecedor set nomefornecedor=?, telefone=?, email=?, endereco=? where cnpj=?";

		try {
			open();
			stmt = con.prepareStatement(sql);
			fornecedor.setNomefornecedor(rs.getString("nomefornecedor"));
			fornecedor.setCnpj(rs.getString("cnpj"));
			fornecedor.setTelefone(rs.getString("telefone"));
			fornecedor.setEmail(rs.getString("email"));
			fornecedor.setEndereco(rs.getString("endereco"));

			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void excluir(Fornecedor fornecedor) throws ClassNotFoundException {

		try {
			open();
			stmt = con.prepareStatement("delete from fornecedor where cnpj=?");
			stmt.setString(1, fornecedor.getCnpj());
			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
