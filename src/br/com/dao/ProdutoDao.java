package br.com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import br.com.entidade.Produto;


public class ProdutoDao extends Dao {
	
	// método adicionar produto
	
	public void cadastrarproduto(Produto produto) throws SQLException {
			open();
			String sql = "insert into produto(nome,descricao ,foto1,foto2,foto3,foto4,qtdprod,preco)" + "values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getFoto1());
			stmt.setString(4, produto.getFoto2());
			stmt.setString(5, produto.getFoto3());
			stmt.setString(6, produto.getFoto4());
			stmt.setInt(7, produto.getQtdprod());
			stmt.setDouble(8, produto.getPreco());
			
			stmt.execute();
			close();
		}

	// método buscar produto

	public Produto buscarprodutoporid(int idproduto) throws SQLException {
			open();
			String sql = "select * from produto where idprod = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idproduto);
			
			Produto produto = null;
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				produto = new Produto(rs.getInt("idprod"),
						  rs.getString("nome"),
						  rs.getString("descricao"),
						  rs.getString("foto1"),
						  rs.getString("foto2"),
						  rs.getString("foto3"),
						  rs.getString("foto4"),
						  rs.getInt("qtdprod"),
						  rs.getDouble("preco")			  
						);
			}
			close();
			return produto;
		}

	// método listar produto

	public List<Produto> buscarproduto(String nomeproduto) throws SQLException{
			open();
			String sql = "select * from produto where nome like ?"; 
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nomeproduto+"%");
			
			//Objeto que recebe a lista completa do stmt, para seleção dos dados		
			rs = stmt.executeQuery();
			List<Produto> lista = new ArrayList<Produto>();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("idprod"),
						  rs.getString("nome"),
						  rs.getString("descricao"),
						  rs.getString("foto1"),
						  rs.getString("foto2"),
						  rs.getString("foto3"),
						  rs.getString("foto4"),
						  rs.getInt("Qtdprod"),
						  rs.getDouble("Preco")				  
						);
				lista.add(produto);
			}
			
			close();
			return lista;
			
		}
	
	
	
	public Produto addprodutoporid(int idproduto) throws SQLException {
		open();
		String sql = "select * from produto where idprod = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idproduto);
		
		Produto produto = null;
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			produto = new Produto(rs.getInt("idprod"),
					  rs.getString("nome"),
					  rs.getString("descricao"),
					  rs.getString("foto1"),
					  rs.getString("foto2"),
					  rs.getString("foto3"),
					  rs.getString("foto4"),
					  rs.getInt("Qtdprod"),
					  rs.getDouble("Preco")			  
					);		
			}
		close();
		return produto;
	}


	// método editar produto

	public void atualizarproduto(Produto produto) throws SQLException {
			open();
			String sql = "UPDATE produto set nome = ?, preco = ?, qtdprod = ?,descricao = ? where idprod = ?";
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getIdprod());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setString(4, produto.getFoto1());
			stmt.setString(5, produto.getFoto2());
			stmt.setString(6, produto.getFoto3());
			stmt.setString(7, produto.getFoto4());
			stmt.setInt(8, produto.getQtdprod());
			stmt.setDouble(9, produto.getPreco());
			stmt.executeUpdate();
			close();
			
			
		}

	// método excluir produto

	public void excluirproduto(int idproduto) throws SQLException {
			open();
			String sql = "delete from produto where idproduto = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, idproduto);
			stmt.execute();
			close();
		}
	


}