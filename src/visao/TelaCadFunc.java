package visao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.ManipulaBD;

public class TelaCadFunc extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadCli,btnVoltar,btnalterar,btnexcluir;
	JTextField campousuario,camponome,camposenha;


	public TelaCadFunc(){
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
		
		
		lblTitulo = new JLabel("Cadastro de função");
		lblTitulo.setBounds(90, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		pnlPainel.add(lblTitulo);
		

		lblTitulo = new JLabel("Nome: ");
		lblTitulo.setBounds(10,94, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD,  14));
		pnlPainel.add(lblTitulo);
		camponome = new JTextField(25);
		camponome.setBounds(100,95,220,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(camponome);
		
		
		lblTitulo = new JLabel("Usuario: ");
		lblTitulo.setBounds(10, 114, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD,  14));
		pnlPainel.add(lblTitulo);
		campousuario = new JTextField(25);
		campousuario.setBounds(100,115,220,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(campousuario);
		
		lblTitulo = new JLabel("Senha: ");
		lblTitulo.setBounds(10,134, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(lblTitulo);
		camposenha = new JTextField(10);
		camposenha.setBounds(100,135,220,20);//60 continuação de 50 titulo
		pnlPainel.add(lblTitulo);//adicionar titulo
		pnlPainel.add(camposenha);
		
		btnCadCli= new JButton("Cadastrar");
		btnCadCli.setBounds(60, 250, 130, 30);
		btnCadCli.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadCli);
		
		btnexcluir= new JButton("Excluir usuario");
		btnexcluir.setBounds(200, 250, 190, 30);
		btnexcluir.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnexcluir);
		
		btnCadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManipulaBD mbd = new ManipulaBD();
				mbd.cadastrarUsuario(campousuario.getText(),camposenha.getText(),camponome.getText());
				
			}
		});
		
		btnexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManipulaBD mbd = new ManipulaBD();
				
				mbd.excluifunc(campousuario.getText());
				
			}
		});

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(200, 250, 90, 30);
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}