
package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import modelo.ManipulaBD;

public class TelaGeraLocacao extends JFrame{
	
		private static final long serialVersionUID = 1L;
		JPanel pnlPainel;
		JLabel lblTitulo;
		String[] lista = new String[10];
		String[] valor = new String[10];
		int x = 1;
		
		JComboBox<String> box = new JComboBox<String>();
		JComboBox<String> boxstatus = new JComboBox<String>();
		JButton btncadastrar, btnVoltar,btnpesquisar;
		JTextField nome,placa,cpf,entrada,status,atraso,saida,total;
		
		ManipulaBD mbd = new ManipulaBD();
		
		public TelaGeraLocacao() {
			super(" RVS Corporation System - v0.9");
			this.setSize(500, 500);
			this.setLocationRelativeTo(null);
			this.setVisible(false);
			Adiciona();
			this.setContentPane(pnlPainel);
			this.pack();
			pnlPainel.setBackground(new Color(238,233,233));
		}
		
		public void Adiciona() {
			pnlPainel = new JPanel();
			pnlPainel.setBackground(new Color(238,233,233));
			pnlPainel.setPreferredSize(new Dimension(500, 500));
			pnlPainel.setLayout(null);
			
			
			lblTitulo = new JLabel("Cadastro de veiculos");
			lblTitulo.setBounds(115, 1, 300, 30);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
			pnlPainel.add(lblTitulo);
			
			pnlPainel = new JPanel();
			pnlPainel.setBackground(new Color(255,255,255));
			pnlPainel.setPreferredSize(new Dimension(500, 500));
			pnlPainel.setLayout(null);
			
			
			lblTitulo = new JLabel("Alocar carro");
			lblTitulo.setBounds(120, 1, 300, 30);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
			pnlPainel.add(lblTitulo);
			
			
			lblTitulo = new JLabel("Placa:");
			lblTitulo.setBounds(150,40, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			pnlPainel.add(lblTitulo);
			
			lblTitulo = new JLabel("Nome:");
			lblTitulo.setBounds(10,80, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			nome = new JTextField(10);
			nome.setBounds(150,80,150,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(nome);
			
			
			lblTitulo = new JLabel("Cpf:");
			lblTitulo.setBounds(10,100, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			cpf = new JTextField(10);
			cpf.setBounds(150,100,150,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(cpf);
			
			
			lblTitulo = new JLabel("Entrada:");
			lblTitulo.setBounds(10,120, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			
			JTextField entradadia = new JTextField(10);
			entradadia.setBounds(150,120,50,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(entradadia);
			
			JTextField entradames = new JTextField(10);
			entradames.setBounds(200,120,50,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(entradames);
			
			JTextField entradaAno = new JTextField(10);
			entradaAno.setBounds(250,120,50,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(entradaAno);

			lblTitulo = new JLabel("Status:");
			lblTitulo.setBounds(10,140, 100, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			
				boxstatus.addItem("alocado");
				boxstatus.addItem("disponivel");
			
			pnlPainel.add(boxstatus);
			boxstatus.setBounds(150, 140, 90, 30);
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(boxstatus);
					
			lblTitulo = new JLabel("Atraso:");
			lblTitulo.setBounds(10,180, 100, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			pnlPainel.add(lblTitulo);
			atraso = new JTextField(10);
			atraso.setBounds(150,180,150,20);//60 continuação de 50 titulo
			pnlPainel.add(atraso);
			
			
			lblTitulo = new JLabel("Saida:");
			lblTitulo.setBounds(10,200, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			pnlPainel.add(lblTitulo);
		    
			JTextField saidadia = new JTextField(10);
			saidadia.setBounds(150,200,50,20);//60 continuação de 50 titulo
			pnlPainel.add(saidadia);
			pnlPainel.add(lblTitulo);
			
			JTextField saidames = new JTextField(10);
			saidames.setBounds(200,200,50,20);//60 continuação de 50 titulo
			pnlPainel.add(saidames);
			pnlPainel.add(lblTitulo);
		    
			JTextField saidaAno = new JTextField(10);
			saidaAno.setBounds(250,200,50,20);//60 continuação de 50 titulo
			pnlPainel.add(saidaAno);
			
			lblTitulo = new JLabel("Dias: ");
			lblTitulo.setBounds(10,220, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			JTextField dias = new JTextField(10);
			dias.setBounds(150,220,150,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(dias);
			
			lblTitulo = new JLabel("Total: ");
			lblTitulo.setBounds(10,240, 300, 20);
			lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
			total = new JTextField(10);
			total.setBounds(150,240,150,20);//60 continuação de 50 titulo
			pnlPainel.add(lblTitulo);//adicionar titulo
			pnlPainel.add(total);
			
			btncadastrar= new JButton("Cadastrar");
			btncadastrar.setBounds(30, 320, 150, 30);
			btncadastrar.setFont(new Font("Verdana", Font.BOLD, 14));
			pnlPainel.add(btncadastrar);
			
			
			btncadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int valormesentrada = Integer.parseInt(entradames.getText());
					int valormessaida = Integer.parseInt(saidames.getText());
					@SuppressWarnings("unused")
					int valorentrada = Integer.parseInt(entradadia.getText());
					@SuppressWarnings("unused")
					int valorsaida = Integer.parseInt(saidadia.getText());
					int valortotal = Integer.parseInt(total.getText());
					int totaldias = Integer.parseInt(dias.getText());
					int	valorfulltotal = totaldias*valortotal;
					if(valorfulltotal <= 0)
					{
						 
					JOptionPane.showMessageDialog(null, "Erroo,Valores invalidos!! ");	
							
					}
					else if((totaldias < 0)||(totaldias == 0))
					{
						
					valorfulltotal = valortotal;	
					mbd.alocacao(box.getSelectedItem(),nome.getText(),cpf.getText(),entradadia.getText()+'/'+entradames.getText()+'/'+entradaAno.getText(),boxstatus.getSelectedItem(),atraso.getText(),saidadia.getText()+'/'+saidames.getText()+'/'+saidaAno.getText(),valorfulltotal);
					JOptionPane.showMessageDialog(null,"locação feita com sucesso!");
					}
					else if(valormesentrada >=13 )				
					{ 
						valormesentrada = 12;
						
					
						  
						
						 JOptionPane.showMessageDialog(null,"Erro,não existe mes 13!");
						
					
						
					}
					else if(valormessaida >= 13)				
					{
						
						 JOptionPane.showMessageDialog(null,"Erro,não existe mes 13!");
						
					 
					}
					else if(valorfulltotal == 0)
					{
					valorfulltotal = valortotal;
					mbd.alocacao(box.getSelectedItem(),nome.getText(),cpf.getText(),entradadia.getText()+'/'+entradames.getText()+'/'+entradaAno.getText(),boxstatus.getSelectedItem(),atraso.getText(),saidadia.getText()+'/'+saidames.getText()+'/'+saidaAno.getText(),valorfulltotal);
					JOptionPane.showMessageDialog(null,"locação feita com sucesso!");
					
					}else
					{
					
				
					 
					mbd.alocacao(box.getSelectedItem(),nome.getText(),cpf.getText(),entradadia.getText()+'/'+entradames.getText()+'/'+entradaAno.getText(),boxstatus.getSelectedItem(),atraso.getText(),saidadia.getText()+'/'+saidames.getText()+'/'+saidaAno.getText(),valorfulltotal);
					JOptionPane.showMessageDialog(null,"locação feita com sucesso!");
						String pl = ((String)box.getSelectedItem());
							
						mbd.statusDispCarros(boxstatus.getSelectedItem(),pl);
					 }
					}
				 
						});

			btnVoltar = new JButton("Voltar ");
			btnVoltar.setBounds(190, 320, 100, 30);
			btnVoltar.setFont(new Font("Verdana", Font.BOLD, 14));
			pnlPainel.add(btnVoltar);
			
			
			btnVoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			
			btnpesquisar = new JButton("Verificar placa");
			btnpesquisar.setBounds(290, 320, 150, 30);
			btnpesquisar.setFont(new Font("Verdana", Font.BOLD, 14));
			pnlPainel.add(btnpesquisar);
			
			btnpesquisar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					mbd.puxadados((String)box.getSelectedItem(),(String)box.getSelectedItem());
					
				}
			});
			
			CarregaBox();
			for(int y=0; y<lista.length;y++) {
				 
				 
				if(lista[y]==null) {
					
				}else {
					box.addItem((String)lista[y]);

					
						
				}
				pnlPainel.add(box);
				box.setBounds(230, 40,100, 30);
			
			
		}
	}
		

	public void CarregaBox() {
		lista[0] = "Null";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/caixinha","root","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `carros` WHERE `status` LIKE '%disponivel%' ");
			while (rs.next()) {
				lista[x] = rs.getString("placa");
				valor[x] = rs.getString("status");
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




