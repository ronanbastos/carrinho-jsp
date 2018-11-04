package br.com.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.dao.FornecedorDao;
import br.com.entidade.Fornecedor;


@WebServlet(name="/ControleFornecedor",urlPatterns= {"/cadastrarfornecedor.html","/buscarfornecedor.html","/fornecedorconsultado.html","/editarfornecedor.html"})
public class ControleFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControleFornecedor() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarfornecedor(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarfornecedor(request,response);
		
	}
	protected void executarfornecedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			String url = request.getServletPath();
			if (url.equalsIgnoreCase("/cadastrarfuncionario.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarfornecedor.html")) {
				editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarfornecedor.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/fornecedorconsultado.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarfornecedor.html")) {
				confirmar(request, response);
			}else if (url.equalsIgnoreCase("/excluirfornecedor.html")) {
				excluir(request, response);
			}else if (url.equalsIgnoreCase("/logarsistema.html")) {
			//	logar(request, response);
			}else {
			throw new Exception("URL Inválida!!!");
		}
	} catch (Exception e) {
		response.sendRedirect("menufornecedor.jsp");
		e.printStackTrace();
	}
	
	
	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nomefornecedor = request.getParameter("nomefornecedor");
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");

		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNomefornecedor(nomefornecedor);
		fornecedor.setCnpj(cnpj);
		fornecedor.setTelefone(telefone);
		fornecedor.setEmail(email);
		fornecedor.setEndereco(endereco);// Instanciando um Objeto do tipo ClienteDao
	
		
		try {
			FornecedorDao dao = new FornecedorDao();
			dao.adicionar(fornecedor);
			request.getRequestDispatcher("adicionarfornecedor.jsp").forward(request, response);
			response.sendRedirect("menufornecedor.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("menufornecedor.jsp");
		} 
	}
	public void buscar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String cnpj = request.getParameter("cnpj");
			FornecedorDao pd = new FornecedorDao();
			

			List<Fornecedor> lista = pd.listafornecedores(cnpj);
			
			request.setAttribute("cnpj", cnpj); //Aqui é variável. Isso
			request.setAttribute("listafornecedor", lista);
			request.getRequestDispatcher("fornecedorconsultado.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cnpj = request.getParameter("cnpj");
			Fornecedor fornecedor = new FornecedorDao().buscarfornecedor(cnpj);		
				request.setAttribute("fornecedor", fornecedor);
				request.getRequestDispatcher("editarfornecedor.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getRequestDispatcher("buscarfornecedor.jsp").forward(request, response);
		}
	}
	//método confirmar
	
		public void confirmar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			try {

				String nomefornecedor = request.getParameter("nomefornecedor");
				String cnpj = request.getParameter("cnpj");
				String telefone = request.getParameter("telefone");
				String email = request.getParameter("email");
				String endereco = request.getParameter("endereco");
				
			
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNomefornecedor(nomefornecedor);
				fornecedor.setCnpj(cnpj);
				fornecedor.setTelefone(telefone);
				fornecedor.setEmail(email);
				fornecedor.setEndereco(endereco);

				FornecedorDao pd = new FornecedorDao();
				pd.editar(fornecedor);
				request.getSession().setAttribute("fornecedor", fornecedor);
								
				request.getRequestDispatcher("editarfornecedor.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				request.getRequestDispatcher("buscarfornecedor.jsp").forward(request, response);
			}

		}
		
		protected void excluir(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			
			String cnpj = request.getParameter("cnpj");

			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setCnpj(cnpj);

			// Instanciando um Objeto do tipo ClienteDao
			try {
				FornecedorDao dao = new FornecedorDao();
				dao.excluir(fornecedor);
				
				request.getRequestDispatcher("buscarfornecedor.jsp").forward(request, response);


			} catch (Exception e) {
				
				request.getRequestDispatcher("menufornecedor.jsp").forward(request, response);

			} 
		}
	
}
