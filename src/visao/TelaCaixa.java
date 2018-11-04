package visao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.ManipulaBD;


public class TelaCaixa extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel pnlPainel;
	JLabel lblTitulo;
	JButton btncafinaliza, btnVoltar,btnlimpar,btncaixa,btnpesquisar;
	JTextField campostatus,campostadia,camposaida,campototal,campoplaca,campoatraso;
	ManipulaBD mbd = new ManipulaBD();

public TelaCaixa() {
	super("Sisteminha - v0.9");
	this.setSize(500, 500);
	this.setLocationRelativeTo(null);
	this.setVisible(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	Adiciona();
	this.setContentPane(pnlPainel);
	this.pack();
}

public void Adiciona() {
	
	pnlPainel = new JPanel();
	pnlPainel.setBackground(new Color(255,255,255));
	pnlPainel.setPreferredSize(new Dimension(500, 500));
	pnlPainel.setLayout(null);
	
	lblTitulo = new JLabel("Tela Saida");
	lblTitulo.setBounds(160, 20, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);

	lblTitulo = new JLabel("Placa: ");
	lblTitulo.setBounds(10,100, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);
	campoplaca = new JTextField(10);
	campoplaca.setBounds(100,110,220,20);//60 continuação de 50 titulo
	pnlPainel.add(lblTitulo);//adicionar titulo
	pnlPainel.add(campoplaca);
	
	lblTitulo = new JLabel("saida: ");
	lblTitulo.setBounds(10,130, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);
	camposaida = new JTextField(10);
	camposaida.setBounds(100,140,220,20);//60 continuação de 50 titulo
	pnlPainel.add(lblTitulo);//adicionar titulo
	pnlPainel.add(camposaida);
	
	lblTitulo = new JLabel("Atraso: ");
	lblTitulo.setBounds(10,160, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);
	campoatraso = new JTextField(10);
	campoatraso.setBounds(110,170,220,20);//60 continuação de 50 titulo
	pnlPainel.add(lblTitulo);//adicionar titulo
	pnlPainel.add(campoatraso);
	
	lblTitulo = new JLabel("Status: ");
	lblTitulo.setBounds(10,210, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);
	campostatus = new JTextField(10);
	campostatus.setBounds(110,220,220,20);//60 continuação de 50 titulo
	pnlPainel.add(lblTitulo);//adicionar titulo
	pnlPainel.add(campostatus);
	
	/*lblTitulo = new JLabel("Total: ");
	lblTitulo.setBounds(10,260, 300, 30);
	lblTitulo.setFont(new Font("Verdana", Font.BOLD, 25));
	pnlPainel.add(lblTitulo);
	campototal = new JTextField(10);
	campototal.setBounds(110,270,220,20);//60 continuação de 50 titulo
	pnlPainel.add(lblTitulo);//adicionar titulo
	pnlPainel.add(campototal);*/
	
	btnVoltar = new JButton("Voltar ");
	btnVoltar.setBounds(180, 370, 100, 30);
	btnVoltar.setFont(new Font("Verdana", Font.BOLD, 14));
	pnlPainel.add(btnVoltar);
	
	btncafinaliza = new JButton("Finalizar ");
	btncafinaliza.setBounds(10, 370, 150, 30);
	btncafinaliza.setFont(new Font("Verdana", Font.BOLD, 14));
	pnlPainel.add(btncafinaliza);
	
	btnlimpar = new JButton("Limpar");
	btnlimpar.setBounds(280, 370, 100, 30);
	btnlimpar.setFont(new Font("Verdana", Font.BOLD, 14));
	pnlPainel.add(btnlimpar);
	
	btncaixa = new JButton("Caixa");
	btncaixa.setBounds(380, 370, 100, 30);
	btncaixa.setFont(new Font("Verdana", Font.BOLD, 14));
	pnlPainel.add(btncaixa);
	
	btnpesquisar = new JButton("Verificar placa");
	btnpesquisar.setBounds(280, 300, 150, 30);
	btncaixa.setFont(new Font("Verdana", Font.BOLD, 14));
	pnlPainel.add(btnpesquisar);
		
	
	btncafinaliza.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
			//int valor = Integer.parseInt(campoatraso.getText());
		
			//mbd.controlesaida(campoplaca.getText(),camposaida.getText(),campoatraso.getText(),campostatus.getText(),4*mbd.ent+valor*4);
		}
	});
	
	btnVoltar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
				setVisible(false);
			
		}
	});
	
	btnpesquisar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			//mbd.puxadados(campoplaca.getText());
			
		}
	});
	
}
}

