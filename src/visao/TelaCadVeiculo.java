package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.ManipulaBD;


public class TelaCadVeiculo extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadVeiculo,btnVoltar,btnAlterar;
	JTextField campoplaca,campomodelo,campoano,campocor,campostatus,campoportas,campoar;
	int verificar = 0;
	ManipulaBD mbd = new ManipulaBD();
	
	public TelaCadVeiculo(){
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
		
		
		lblTitulo = new JLabel("Cadastrar Carro");
		lblTitulo.setBounds(120, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		
		lblTitulo = new JLabel("Placa:");
		lblTitulo.setBounds(10,60, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		campoplaca = new JTextField(10);
		campoplaca.setBounds(100,60,300,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campoplaca);
		
		
		lblTitulo = new JLabel("Modelo:");
		lblTitulo.setBounds(10,80, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		campomodelo = new JTextField(10);
		campomodelo.setBounds(100,80,300,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campomodelo);
		
		
		lblTitulo = new JLabel("Ano:");
		lblTitulo.setBounds(10,100, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		campoano = new JTextField(10);
		campoano .setBounds(100,100,300,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campoano );
		
		
		lblTitulo = new JLabel("Cor:");
		lblTitulo.setBounds(10,120, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		campocor = new JTextField(10);
		campocor.setBounds(100,120,300,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campocor);
		JComboBox<String>  box1 = new JComboBox<String>();
		
		box1.addItem("disponivel");
		box1.addItem("alocado");

		pnlPainel.add(box1);
		box1.setBounds(100, 140, 90, 30);

		lblTitulo = new JLabel("Status:");
		lblTitulo.setBounds(10,140, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		//campostatus = new JTextField(10);
	//	campostatus.setBounds(130,140,300,20);//60 continuação de 50 titulo
	//	pnlPainel.add(campostatus);
		
				
		lblTitulo = new JLabel("Portas:");
		lblTitulo.setBounds(10,180, 100, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		JComboBox<String>  box2 = new JComboBox<String>();
		
		box2.addItem("2");
		box2.addItem("4");

		pnlPainel.add(box2);
		box2.setBounds(100, 180, 90, 30);

		//campoportas = new JTextField(10);
		//campoportas.setBounds(130,160,300,20);//60 continuação de 50 titulo
		//pnlPainel.add(campoportas);
		
		
		lblTitulo = new JLabel("Ar:");
		lblTitulo.setBounds(50,220, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		JComboBox<String>  box3 = new JComboBox<String>();
		box3.addItem("sim");
		box3.addItem("nao");
		pnlPainel.add(box3);
		box3.setBounds(100, 220,90, 30);
		//campoportas = new JTextField(10);
		//campoportas.setBounds(130,180,300,20);//60 continuação de 50 titulo
		//pnlPainel.add(campoportas);
		
		lblTitulo = new JLabel("Preço: ");
		lblTitulo.setBounds(10,260, 300, 20);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		JTextField campopreco = new JTextField(10);
		campopreco.setBounds(100,260,300,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campopreco);
	
		btnCadVeiculo= new JButton("Cadastrar");
		btnCadVeiculo.setBounds(30, 320, 150, 30);
		btnCadVeiculo.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadVeiculo);
		
		
		btnCadVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vazio0 = campoplaca.getText();
				String vazio1 = campoano.getText();
				String vazio2 = campomodelo.getText();
				String vazio3 = campocor.getText();
				String vazio4 = campopreco.getText();
				
				if(vazio0.trim().equals(""))
				{
								
				JOptionPane.showMessageDialog(null, "O campo placa do carro esta vazio!!");
				
				
				}
			    if(vazio1.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "O campo ano do carro esta vazio!!");	
				}
				 if(vazio2.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "O campo modelo do carro esta vazio!!");	
				}
				if(vazio3.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "O campo cor do carro esta vazio!!");	
				}
			    if(vazio4.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null, "O campo preço do carro esta vazio!!");	
				}
				else
				{
				mbd.cadCarros(campoplaca.getText(), campomodelo.getText(),campoano.getText(),campocor.getText(), box1.getSelectedItem(),box2.getSelectedItem(), box3.getSelectedItem(), campopreco.getText());	
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
		
		btnAlterar = new JButton("Aterar status");
		btnAlterar.setBounds(300, 320, 150, 30);
		btnAlterar.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnAlterar);
		
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				verificar++;
				//System.out.println(verificar);
				String vazio = campoplaca.getText();
				if((verificar == 1)&&(vazio.trim().equals("")))
				{
								
				JOptionPane.showMessageDialog(null, "Porfavor coloque o nome da placa seu status alocado ou disponivel antes de usar o botão!!");
				
				
				}else {
					
					mbd.statusDispCarros(box1.getSelectedItem(),campoplaca.getText());
					
				}
				
			}
		});

	}
	
	

	
}
