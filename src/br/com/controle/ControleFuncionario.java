package br.com.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.dao.FuncionarioDao;

import br.com.entidade.Funcionario;

@WebServlet(name="/ControleFuncionario",urlPatterns= {"/cadastrarfuncionario.html","/buscarfuncionario.html","/funcionarioconsultado.html"})
public class ControleFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleFuncionario() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarfuncionario(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarfuncionario(request,response);
		
	}
	protected void executarfuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String url = request.getServletPath();
			if (url.equalsIgnoreCase("/cadastrarfuncionario.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarfuncionario.html")) {
				//editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarfuncionario.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/funcionarioconsultado.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarfuncionario.html")) {
				//confirmar(request, response);
			}else if (url.equalsIgnoreCase("/excluirfuncionario.html")) {
				//excluir(request, response);
			}else if (url.equalsIgnoreCase("/logarfuncionario.html")) {
				//logar(request, response);
			}else {
			throw new Exception("URL Inválida!!!");
		}
	} catch (Exception e) {
		response.sendRedirect("menu.jsp");
		e.printStackTrace();
	}
	
	
	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nomefuncionario = request.getParameter("nomefuncionario");
		String cargo = request.getParameter("cargo");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String cpf = request.getParameter("cpf");

		
		Funcionario funcionario = new Funcionario();
		funcionario.setNomefuncionario(nomefuncionario);
		funcionario.setCargo(cargo);
		funcionario.setLogin(login);
		funcionario.setSenha(senha);
		funcionario.setCpf(cpf);// Instanciando um Objeto do tipo ClienteDao
		
		try {
			FuncionarioDao dao = new FuncionarioDao();
			dao.adicionar(funcionario);
			request.getRequestDispatcher("adicionarfuncionario.jsp").forward(request, response);
			

		} catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
	public void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String cpf = request.getParameter("cpf");
			FuncionarioDao pd = new FuncionarioDao();
			//Cliente cliente=new Cliente();

			List<Funcionario> lista = pd.listafuncionario(cpf);
			
			request.setAttribute("cpf", cpf); //Aqui é variável. Isso
			request.setAttribute("listafuncionario", lista);
			request.getRequestDispatcher("funcionarioconsultado.jsp").forward(request, response);
			//Vai passar os dados da lista para o editaCliente.jsp ok
			//Peraí...
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
