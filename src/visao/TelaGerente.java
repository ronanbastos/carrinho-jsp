package visao;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class TelaGerente extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btnCadVeiculo,btnCadfunc,btnverifica,btnAlocar,btnCadGerente,btnGeraServiço;
	
	
	TelaCadVeiculo tcv = new TelaCadVeiculo();
	TelaCadFunc tcf = new TelaCadFunc();
	
	
	public TelaGerente() {
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
		
		
		lblTitulo = new JLabel("Tela Gerente");
		lblTitulo.setBounds(120, 1, 300, 30);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
		pnlPainel.add(lblTitulo);
		
		
		
		btnCadVeiculo= new JButton("Cadastrar Veiculo");
		btnCadVeiculo.setBounds(120, 50, 230, 30);
		btnCadVeiculo.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadVeiculo);
		
		
		btnCadVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadVeiculo tV2 = new TelaCadVeiculo();
				tV2.getClass();
				tV2.setVisible(true);
			}
		});
		

		btnverifica = new JButton("Verificar situaçao");
		btnverifica.setBounds(120, 100, 230, 30);
		btnverifica.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnverifica);
		
		
		btnverifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVerificaGerente tVg2 = new TelaVerificaGerente();
				tVg2.getClass();
				tVg2.setVisible(true);
			}
		});
		
		
		btnGeraServiço = new JButton("Ordem de serviço");
		btnGeraServiço .setBounds(120, 300, 230, 30);
		btnGeraServiço .setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnGeraServiço );
		
		btnGeraServiço.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVerificaGerente2 tV2 = new TelaVerificaGerente2();
				tV2.getClass();
				tV2.setVisible(true);					
			}
		});
		
		
		
		btnCadfunc = new JButton("Cadastrar Funcionario");
		btnCadfunc.setBounds(120, 200, 230, 30);
		btnCadfunc.setFont(new Font("Verdana", Font.BOLD, 14));
		pnlPainel.add(btnCadfunc);
		
		
		btnCadfunc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tcf.getClass();
				tcf.setVisible(true);
			}
		});
		
	
		
		
	}
	
}
