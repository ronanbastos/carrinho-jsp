
package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TelaAdmin extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadfunc,btnCadgerente;
	
	
	TelaCadFunc tcf = new TelaCadFunc();
	
	
	public TelaAdmin() {
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
		
		
		lblTitulo = new JLabel("Administrador");
		lblTitulo.setBounds(120, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		
		btnCadfunc = new JButton("Cadastrar Funcionario");
		btnCadfunc.setBounds(120, 100, 230, 30);
		btnCadfunc.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadfunc);
		
		
		btnCadfunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tcf.getClass();
				tcf.setVisible(true);
			}
		});
		
		btnCadgerente = new JButton("Cadastrar Gerente");
		btnCadgerente .setBounds(120, 150, 230, 30);
		btnCadgerente .setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadgerente);
		
		JButton btnVoltar = new JButton("Sair");
		btnVoltar.setBounds(200, 250, 90, 30);
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnVoltar);
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		btnCadfunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcf.getClass();
				tcf.setVisible(true);
			}
		});
		
		btnCadgerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tcf.getClass();
				tcf.setVisible(true);
			}
		});
		
	
		
	}
}