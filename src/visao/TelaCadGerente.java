package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaCadGerente extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadVei,btnVoltar,btnGerar;
	
	public TelaCadGerente(){
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
		pnlPainel.setPreferredSize(new Dimension(500, 500)) ;
		pnlPainel.setLayout(null);
		lblTitulo = new JLabel("Menu Gerente");
		lblTitulo.setBounds(150, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		btnCadVei= new JButton("Cadastrar Veiculo");
		btnCadVei.setBounds(150, 180, 230, 30);
		btnCadVei.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadVei);
		
	
		btnCadVei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadVeiculo tV = new TelaCadVeiculo();
				tV.getClass();
				tV.setVisible(true);
			}
		});
		
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(150, 250, 230, 30);
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}
