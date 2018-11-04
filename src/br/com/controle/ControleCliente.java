package br.com.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dao.AdminDao;
import br.com.dao.ClienteDao;
import br.com.entidade.Admin;
import br.com.entidade.Cliente;
import util.Crypt;


@WebServlet(name="/ControleCliente",urlPatterns= {"/cadastrarcliente.html",
		"/buscarcliente.html","/clienteconsultado.html","/editarcliente.html",
		"/confirmarcliente.html","/logarcliente.html"})
public class ControleCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControleCliente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarcliente(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarcliente(request,response);
	}
	protected void executarcliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/cadastrarcliente.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarcliente.html")) {
				editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarcliente.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/clienteconsultado.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarcliente.html")) {
				confirmar(request, response);
			
			
			}else if (url.equalsIgnoreCase("/logarcliente.html")) {
				logar(request, response, request);
				buscar(request, response);
			}else {
			throw new Exception("URL Inválida!!!");
		}
	} catch (Exception e) {
		response.sendRedirect("index.jsp");
		e.printStackTrace();
	}

}
	//cadastrar cliente
		protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Pegando os parâmetros passados pelo formulário
			String Nome = request.getParameter("nome");
			String Senha = Crypt.sha1(request.getParameter("senha").trim());
			String Email = request.getParameter("email");
			String ativo = "true";
		//	String Datanasc = request.getParameter("datanasc");
		//	String Endereco = request.getParameter("endereco");
		//	String Cidade = request.getParameter("cidade");
		//	String Tel = request.getParameter("tel");
		//	String Cep = request.getParameter("cep");
		//	String Cpf = request.getParameter("cpf");
			
	

			// Instanciando um Objeto do tipo Cliente
			Cliente cliente = new Cliente();
			cliente.setNome(Nome);
			cliente.setSenha(Senha);
			cliente.setEmail(Email);
			cliente.setAtivo(ativo);
		//	cliente.setDatanasc(Datanasc);
		//	cliente.setEndreco(Endereco);
		//	cliente.setCidade(Cidade);
		//	cliente.setTel(Tel);
	    //	cliente.setCep(Cep);
		//	cliente.setCpf(Cpf);
		
        
			// Instanciando um Objeto do tipo ClienteDao
			
			try {
				
				ClienteDao dao = new ClienteDao();
				dao.adicionar(cliente);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			

			} catch (Exception e) {
				e.printStackTrace();
				
			} 
		}
		// método buscar cliente
		public void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			try {
				String email = request.getParameter("login");
				ClienteDao pd = new ClienteDao();
				//Cliente cliente=new Cliente();

				List<Cliente> lista = pd.listarCliente(email);
				
				request.setAttribute("login", email); //Aqui é variável. Isso
				request.setAttribute("listaCliente", lista);
				request.getRequestDispatcher("buscacliente.jsp").forward(request, response);
				//Vai passar os dados da lista para o editaCliente.jsp ok
				//Peraí...
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//método editar cliente
		public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				// Capturando o Id do Cliente vindo do formulário
				
				String email = request.getParameter("login");
				Cliente cliente = new ClienteDao().buscarCliente(email);		
					request.setAttribute("cliente", cliente);
					//request.getSession().setAttribute("cliente", cliente);
					request.getRequestDispatcher("editarcliente.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		//confirmar cliente
		
		public void confirmar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {

				// Pegando os parâmetros passados pelo formulário
				String Nome = request.getParameter("nome");
				String Senha = Crypt.sha1(request.getParameter("senha").trim());
				String Email = request.getParameter("email");
				String Datanasc = request.getParameter("datanasc");
				String Endereco = request.getParameter("endereco");
				String Cidade = request.getParameter("cidade");
				String Tel = request.getParameter("tel");
				String Cep = request.getParameter("cep");
				String Cpf = request.getParameter("cpf");
				
				if (Cpf.equals("00000000000") || Cpf.equals("11111111111")
						|| Cpf.equals("22222222222") || Cpf.equals("33333333333")
						|| Cpf.equals("44444444444") || Cpf.equals("55555555555")
						|| Cpf.equals("66666666666") || Cpf.equals("77777777777")
						|| Cpf.equals("88888888888") || Cpf.equals("99999999999")
						|| (Cpf.length() != 11)) {
					   
						Cpf = null;
					
					}
			
				//long idCliente = Long.parseLong(request.getParameter("idcliente"));
				

				// Instanciando um Objeto do tipo Cliente
				Cliente cliente = new Cliente();
				cliente.setNome(Nome);
				cliente.setSenha(Senha);
				cliente.setEmail(Email);
				cliente.setDatanasc(Datanasc);
				cliente.setEndereco(Endereco);
				cliente.setCidade(Cidade);
				cliente.setTel(Tel);
				cliente.setCep(Cep);
				cliente.setCpf(Cpf);// Instanciando um Objeto do tipo ClienteDao
				//cliente.setIdCliente(new Integer(idCliente));

				// Gravando os dados no Banco de Dados

				ClienteDao pd = new ClienteDao();
				pd.editar(cliente);
				//request.getSession().setAttribute("cliente", cliente);
				//HttpSession sessao=request.getSession();
				//sessao.setAttribute("nome",nome);
				
				request.getRequestDispatcher("logadotrue.jsp").forward(request, response);
				

			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}

		}
		protected void logar(HttpServletRequest request, HttpServletResponse response, ServletRequest session)
				throws ServletException, IOException, ClassNotFoundException, SQLException {
			String login = request.getParameter("login");
			String senha = Crypt.sha1(request.getParameter("senha").trim());
		
			//String admin = "admin";
			Cliente cliente = new ClienteDao().login(login, senha);
			Admin admin = new AdminDao().consultarLoginSenha(login, senha);

			
			if (cliente != null) {

				//HttpSession user;
				//request.getSession().setAttribute("cliente", cliente);
				request.getSession().setAttribute("cliente", cliente);
				//response.sendRedirect("logadotrue.jsp");
				request.getRequestDispatcher("logadotrue.jsp").forward(request, response);
				
			} else {

				try {

					if (admin != null) {					
						request.getSession().setAttribute("admin", admin);
						request.getRequestDispatcher("PAdmin.jsp").forward(request, response);
						
						
					} else {
						
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}

				catch (Exception e) {
					e.printStackTrace();
					//request.setAttribute("msg", "Erro" + e.getMessage());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
		}

		
		
		}   				