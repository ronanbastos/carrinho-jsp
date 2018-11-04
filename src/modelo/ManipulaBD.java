package modelo;

import java.sql.*;

import javax.swing.JOptionPane;

import visao.*;

public class ManipulaBD  {
	Conexao cn = new Conexao();
	public boolean logado = false;
	private double ent;
	
	private String gerente;
	private int idplaca;
	private String modelo;
	private String use;
	
	public void cadCarros(String placa,String modelo,String ano,String cor,Object status,Object porta,Object ar,String preco ) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
            Statement st = cn.con.createStatement(); //paramento do banco
            st.executeUpdate("INSERT INTO carros(placa,modelo,ano,cor,status,portas,ar,preco) VALUES" +
            "('"+ placa +"','"+ modelo +"','"+ano+"','"+cor+"','"+status+"','"+porta+"','"+ar+"','"+preco+"')");
            
           
            JOptionPane.showConfirmDialog(null,"Entrada efetuada Sucesso!!");
                    st.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }
	
	public void statusDispCarros(Object status,String p) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
        	Statement st2 = cn.con.createStatement(); //paramento do banco
    		ResultSet rs = st2.executeQuery("SELECT idcarros FROM  carros WHERE placa='"+ p +"';");
      		
    		while(rs.next()) 
    		{
    		 idplaca = rs.getInt("idcarros");	  			
    			
    		
    		}
        	Statement st1 = cn.con.createStatement(); //paramento do banco
            String sql ="UPDATE `carros` SET `status` = '" + status + "' WHERE `carros`.`idcarros` = '" + idplaca +"';";
    		if(p.trim().equals(""))
    		{
    			int cont = 0;
    			if(cont == 1)
    			{
    			JOptionPane.showMessageDialog(null, "Nada foi alterado no banco,aqui esta as placas disponivel para mudar para alocadas!");
    			TelaVerificaGerente tvp = new TelaVerificaGerente();
				tvp.getClass();
				tvp.setVisible(true);
				
    			}
    			
    			{
    			cont++;
    			TelaVerificaGerente tvp = new TelaVerificaGerente();
				tvp.getClass();
				tvp.setVisible(true);
    			}
    		}else {
            st1.executeUpdate(sql);
    		JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
    		}
            st1.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }

	public void excluifunc(String us) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
        	Statement st2 = cn.con.createStatement(); //paramento do banco
    		ResultSet rs = st2.executeQuery("SELECT idusuario FROM  usuario WHERE usu='"+ us +"';");
      		
    		while(rs.next()) 
    		{
    		 use = rs.getString("idusuario");	  			
    			
    		
    		}
        	Statement st1 = cn.con.createStatement(); //paramento do banco
            String sql ="DELETE FROM `usuario` WHERE `usuario`.`idusuario` = "+ use+";";
    		if(us.trim().equals(""))
    		{
    			int cont = 0;
    			if(cont == 1)
    			{
    			JOptionPane.showMessageDialog(null, "Nada foi alterado no banco");
    			
    			}
    			
    			{
    			cont++;
      			}
    		}else {
            st1.executeUpdate(sql);
    		JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
    		}
            st1.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }

	
	public void alocacao(Object placa,String nome,String cpf,String entrada,Object status,String atraso,String saida,int total) {
        cn.Conecta();


        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
            Statement st = cn.con.createStatement(); //paramento do banco
            st.executeUpdate("INSERT INTO locacao(nome,placa,cpf,entrada,status,atraso,saida,total) VALUES" +
            "('"+ nome +"','"+ placa +"','"+ cpf +"','"+entrada+"','"+status+"','"+atraso+"','"+saida+"','"+total+"')");

           
            JOptionPane.showConfirmDialog(null,"Cadastro efetuada Sucesso!!");
            st.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }
	
	public void cadastrarUsuario(String us,String se,String no) {
        cn.Conecta();
        //executeQuery so serve para select e preciso um resultSet
        //Para todos as outro use o update sem requerimento do resultSet
        // Os outro inset into,delete,update
        // O execute query retorna um array
        // O execute update retorna inteiro 
        try {
            Statement st = cn.con.createStatement(); //paramento do banco
            st.executeUpdate("INSERT INTO usuario(usu,sen,nome) VALUES" +
            "('"+ us +"','"+ se +"','"+no+"')");

           
            JOptionPane.showConfirmDialog(null,"Entrada efetuada Sucesso!!");
            st.close();
            cn.Desconecta();
        }catch(SQLException err){
            System.out.println("Erro,login:" + err);

        }

     }

	public void Login(String u,String s) {
		
		TelaAdmin tA = new TelaAdmin();
		TelaGerente tG = new TelaGerente();
		cn.Conecta();
		//executeQuery so serve para select e preciso um resultSet
		//Para todos as outro use o update sem requerimento do resultSet
		// Os outro inset into,delete,update
		// O execute query retorna um array
		// O execute update retorna inteiro 
		try {
		Statement st = cn.con.createStatement(); //paramento do banco
		ResultSet rs = st.executeQuery("SELECT*FROM  usuario WHERE usu='"+ u +"' AND sen='"+ s +"';");
		while(rs.next()) {
			logado = true;
			JOptionPane.showMessageDialog(null,"Usuario Logado!!!");
			String user = rs.getString("usu");	 	
			String admin = "admin";
			gerente = "gerente";
			if(user.trim().equals(gerente))
			{
				tG.getClass();
				tG.setVisible(true);
				
			}
			else if(user.trim().equals(admin))
			{
				tA.getClass();
				tA.setVisible(true);
				
			}else
			{
			TelaGeraLocacao tgl = new TelaGeraLocacao();
			tgl.getClass();
			tgl.setVisible(true);
			}
		}
		st.close();
		rs.close();
		}catch(SQLException e){
		System.out.println("Erro,login:" + e);
	
	}
 }

	public void puxadados(String p,String m) {
		cn.Conecta();
		
		
		//executeQuery so serve para select e preciso um resultSet
		//Para todos as outro use o update sem requerimento do resultSet
		// Os outro inset into,delete,update
		// O execute query retorna um array
		// O execute update retorna inteiro 
		
		try {
		
		
		Statement st = cn.con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM  carros WHERE placa='"+ p +"';");
		
		Statement st2 = cn.con.createStatement();//paramento do banco
		String sql="SELECT * FROM  carros WHERE placa='"+ m +"';";
		ResultSet rs1 = st2.executeQuery(sql);
		
		while( (rs.next()) && ( rs1.next()) ) 
		{
		modelo=rs1.getString("modelo"); 
		ent = rs.getDouble("preco");
		String port;
		port = rs.getString("portas");
		String ar;
		ar = rs1.getString("ar");
		JOptionPane.showMessageDialog(null,"A locação deste carro tem o valor de :"+ ent +" ,\n seu modelo é:  "+ modelo+"  ,\n este modelo tem "+ port +" portas,\n o carro "+ar+" tem ar instalado!");		
		
		}
		
		st.close();
		rs.close();
		}catch(SQLException e){
		System.out.println("Erro,em verificar:Esta placa não existe!" + e);
	
	}
 }

	

	

	

}