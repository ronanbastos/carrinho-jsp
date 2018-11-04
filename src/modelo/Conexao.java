package modelo;
import java.sql.*;



public class Conexao {

 
public static void main(String[] args) {
	
	

}
	public Connection con = null;
	String caminho = "jdbc:mysql://localhost:3306/caixinha"; //no usbw usa localhost:3307.
	String usuario = "root";
	String senha = "";
	
	public void Conecta() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(caminho,usuario,senha);
			System.out.println("coneção ativa");
			
			
		}catch(SQLException|ClassNotFoundException err) {
			System.out.println("Erro ao conectar:"+ err);
		}
	}
	public void Desconecta() {
		
	}
}
