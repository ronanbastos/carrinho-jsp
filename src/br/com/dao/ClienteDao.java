package br.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entidade.Cliente;
public class ClienteDao extends Dao {
	
	public void adicionar(Cliente cliente) throws ClassNotFoundException {
		String sql = "insert into cliente " + "(nome,senha,email,datanasc,endereco,cidade,tel,cep,cpf,ativo)" + " values (?,?,?,?,?,?,?,?,?,?)";
		//String sql1="insert into admin" +"(nome,login,senha)" + " values (?,?,?)";

		try {
			// prepared statement para inserção
			open();
			stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSenha());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getDatanasc());
			stmt.setString(5, cliente.getEndereco());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getTel());
			stmt.setString(8, cliente.getCep());
			stmt.setString(9, cliente.getCpf());
			stmt.setString(10, cliente.getAtivo());
			// executa
			stmt.execute();
			
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Cliente> listarCliente(String email) throws ClassNotFoundException, SQLException {

		open();

		stmt = this.con.prepareStatement("select * from cliente where email = ?");
		stmt.setString(1, email);

		rs = stmt.executeQuery();
		List<Cliente> clientes = new ArrayList<Cliente>();

		while (rs.next()) {			// criando o objeto Cliente
			Cliente cliente = new Cliente();
			cliente.setIdcli(rs.getInt("idcli"));
			cliente.setNome(rs.getString("nome"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDatanasc(rs.getString("datanasc"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setTel(rs.getString("tel"));
			cliente.setCep(rs.getString("cep"));
			cliente.setCpf(rs.getString("cpf"));
		
			// adicionando o objeto à lista
			clientes.add(cliente);
		}
		
		return clientes;

	}
	
	//buscar cliente por Email
	
	public Cliente buscarCliente(String nome) throws SQLException, ClassNotFoundException {

		open();
		String sql = "SELECT * FROM cliente WHERE nome  = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, nome);
		Cliente cliente = null;
		rs = stmt.executeQuery();

		if (rs.next()) {
			cliente = new Cliente();
			cliente.setNome(rs.getString("nome"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDatanasc(rs.getString("datanasc"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setTel(rs.getString("tel"));
			cliente.setCep(rs.getString("cep"));
			cliente.setCpf(rs.getString("cpf"));
		
		}
		//close();
		return cliente;

	}
	public void editar(Cliente cliente) throws ClassNotFoundException {
		String sql = "update cliente set nome=?, senha=?, datanasc=?, endereco=?, cidade=?,tel=?,cep=?,cpf=? where email=?";

		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getSenha());
			//stmt.setString(3, cliente.getEmail());
			stmt.setString(3, cliente.getDatanasc());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getTel());
			stmt.setString(7, cliente.getCep());
			stmt.setString(8, cliente.getCpf());
						//stmt.setLong(6, cliente.getIdcliente());

			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public void excluir(Cliente cliente) throws ClassNotFoundException {

		try {
			open();
			stmt = con.prepareStatement("delete from cliente where email=?");
			stmt.setString(1, cliente.getCpf());
			stmt.execute();
			close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente login(String login, String senha) throws SQLException, ClassNotFoundException {
		open();
		String sql = "SELECT * FROM cliente WHERE email = ? AND senha = ?";
		//"SELECT * FROM cliente WHERE senha LIKE ? AND email LIKE ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, login);
		stmt.setString(2, senha);
		
		

		
		rs = stmt.executeQuery();
		Cliente cliente = null;
		
		if (rs.next()) {
			cliente = new Cliente();
			cliente.setIdcli(rs.getInt("idcli"));
			cliente.setNome(rs.getString("nome"));
			cliente.setSenha(rs.getString("senha"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDatanasc(rs.getString("datanasc"));
			cliente.setEndereco(rs.getString("endereco"));
			cliente.setCidade(rs.getString("cidade"));
			cliente.setTel(rs.getString("tel"));
			cliente.setCep(rs.getString("cep"));
			cliente.setCpf(rs.getString("cpf"));
		
		}
		close();
		return cliente;
	}


}
