package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class TelaVerificaGerente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadVei,btnVoltar;
	String[] lista = new String[100];
	String[] valor = new String[100];
	String[] ano = new String[100];
	String[] dispon = new String[100];
	int x = 1;
	int moveTxty = 20;
	
	
	public TelaVerificaGerente(){
	super(" RVS Corporation System - v0.9");
	this.setSize(500, 500);
	
	this.setLocationRelativeTo(null);
	this.setVisible(false);
	Adiciona();
	this.setContentPane(pnlPainel);
	this.pack();
	
}
	public void Adiciona() {
		pnlPainel = new JPanel();
		pnlPainel.setBackground(new Color(255,255,255));
		pnlPainel.setPreferredSize(new Dimension(700, 1024)) ;
		pnlPainel.setLayout(null);
		lblTitulo = new JLabel("Verifica Placas");
		lblTitulo.setBounds(150, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		Carregaplacas();
		for(int y=0; y<lista.length;y++) {
			 moveTxty = moveTxty + 25;
			 
			if(lista[y]==null) {
				
			}else {
			 
				lblTitulo = new JLabel((String)lista[y]);
				lblTitulo.setBounds(10,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
			
				lblTitulo = new JLabel((String)valor[y]);
				lblTitulo.setBounds(150,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)ano[y]);
				lblTitulo.setBounds(310,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)dispon[y]);
				lblTitulo.setBounds(380,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
			}
		}
		
		
		
		
	}
	public void Carregaplacas() {
		lista[0] = "Placa no sistema:";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caixinha","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `carros`");
			while (rs.next()) {
				lista[x] = rs.getString("placa");
				valor[x] = rs.getString("modelo");
				ano[x] = rs.getString("ano");
				dispon[x] = rs.getString("Status");
				x++;
			}
			st.close();
			rs.close();
			con.close();
		}catch(SQLException | ClassNotFoundException err) {
			System.out.println("Erro CarregaBox: " + err);
		}
	}
}
