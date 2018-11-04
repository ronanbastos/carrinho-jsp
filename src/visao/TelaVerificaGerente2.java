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




public class TelaVerificaGerente2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadVei,btnVoltar;
	JScrollPane scroll = new JScrollPane();
	String[] valor = new String[100];
	String[] placa = new String[100];
	String[] status = new String[100];
	String[] id = new String[100];
   	int [] idlocacao = new int[100];
	String[] nome = new String[100];
	String[] cpf = new String[100];
	String[] entrada	 = new String[100];
	double[] total = new double[100];
	String[] atraso = new String[100];
	String[] saida = new String[100];
	int x = 1;
	int moveTxty = 0;
	int moveTxtx = 50;
	JComboBox<String> box = new JComboBox<String>();
	
	public TelaVerificaGerente2(){
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
		pnlPainel.setPreferredSize(new Dimension(1024, 600)) ;
		pnlPainel.setLayout(null);
		lblTitulo = new JLabel("Ordem de Serviço");
		lblTitulo.setBounds(450, 10, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		
		Carregaplacas();
		
		for(int y=0; y<nome.length;y++) {
			 moveTxty = moveTxty + 50;
			 
			if(nome[y]==null) {
				
			}else {
				if(idlocacao[y] == 0) {
					lblTitulo = new JLabel("id");
					lblTitulo.setBounds(10,moveTxty, 300, 30);
					lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
					pnlPainel.add(lblTitulo);
					
				}
				else
				{
				lblTitulo = new JLabel(Integer.toString(idlocacao[y]));
				lblTitulo.setBounds(10,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				}
				lblTitulo = new JLabel((String)placa[y]);
				lblTitulo.setBounds(50,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)nome[y]);
				lblTitulo.setBounds(150,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)cpf[y]);
				lblTitulo.setBounds(250,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)	entrada[y]);
				lblTitulo.setBounds(450,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)	status[y]);
				lblTitulo.setBounds(620,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)	atraso[y]);
				lblTitulo.setBounds(730,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
				lblTitulo = new JLabel((String)	saida[y]);
				lblTitulo.setBounds(800,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
			  
				lblTitulo = new JLabel((String)valor[y]);
				lblTitulo.setBounds(950,moveTxty, 300, 30);
				lblTitulo.setFont(new Font("Verdana", Font.BOLD, 15));
				pnlPainel.add(lblTitulo);
				
			}
		}
	
	}
	
	
	public void Carregaplacas() {
		idlocacao[0] = 0;
		nome[0] = "Nome";
		placa[0] = "placa";
		cpf[0] = "cpf";
		entrada[0] = "Entrada";
		status[0] = "Status";
		atraso[0] = "Atraso";
		saida[0] = "Saida";
		valor[0] = "Total";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caixinha","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `locacao`");
			while (rs.next()) {
				idlocacao[x] = rs.getInt("idlocacao");
				nome[x] = rs.getString("nome");
				placa[x] = rs.getString("placa");
				cpf[x] = rs.getString("cpf");
				entrada[x] = rs.getString("entrada");
				status[x] = rs.getString("status");
				atraso[x] = rs.getString("atraso");
				saida[x] = rs.getString("saida");
				valor[x] = rs.getString("total");
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
