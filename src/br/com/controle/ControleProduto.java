package br.com.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.ProdutoDao;
import br.com.entidade.Produto;
import util.Arquivo;

@MultipartConfig

@WebServlet(name="/ControleProduto",urlPatterns = { "/cadastrarproduto.html","/buscarproduto.html",
		"/produtoconsultado.html","/confirmarproduto.html","/editarproduto.html","/excluirproduto.html","/addcarrinho.html"})

public class ControleProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Arquivo arq = new Arquivo();
	String caminhoFoto = "C:/Users/%userprofile%/Documents/Eclipse/javaweb/Projetofinal/WebContent/fotos";//windows
	//String caminhoFoto = "C:/Users/%userprofile%/Desktop/Projetofinal/WebContent/fotos";//windows
         
	
    public ControleProduto() {
        super();
        // TControleProdutoODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarproduto(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executarproduto(request,response);
	}
	protected void executarproduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String url = request.getServletPath();

			if (url.equalsIgnoreCase("/cadastrarproduto.html")) {
				cadastrar(request, response);
			} else if (url.equalsIgnoreCase("/editarproduto.html")) {
				editar(request, response);
			} else if (url.equalsIgnoreCase("/buscarproduto.html")) {
				buscaproduto(request, response);
			} else if (url.equalsIgnoreCase("/produtoconsultado.html")) {
				buscar(request, response);
			} else if (url.equalsIgnoreCase("/confirmarproduto.html")) {
				confirmar(request, response);
			}else if (url.equalsIgnoreCase("/excluirproduto.html")) {
				excluir(request, response);
			}else if (url.equalsIgnoreCase("/addcarrinho.html")) {
				addcarrinho(request, response);
			}else {
			throw new Exception("URL Inválida!!!");
		}
	} catch (Exception e) {
		//response.sendRedirect("index.jsp");
		e.printStackTrace();
	}
	

	}
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 
		 String Nome = request.getParameter("nome");
		 String Descricao = request.getParameter("descricao");
		// String Foto = request.getPart("foto1").getName();
		 int Qtdprod = Integer.parseInt(request.getParameter("quantidade"));
		 double Preco = Double.parseDouble(request.getParameter("preco"));
				
		Produto produto = new Produto();
		produto.setNome(Nome);
		produto.setDescricao(Descricao);
		//produto.setFoto(Foto);
		produto.setPreco(Preco);
		produto.setQtdprod(Qtdprod);
		
		produto.setFoto1(arq.upload(caminhoFoto,
                        request.getPart("foto1").getName(),// parameto da foto
                        request.getPart("foto1").getInputStream()));
		produto.setFoto2(arq.upload(caminhoFoto,
                request.getPart("foto2").getName(),// parameto da foto
                request.getPart("foto2").getInputStream()));
		produto.setFoto3(arq.upload(caminhoFoto,
                request.getPart("foto3").getName(),// parameto da foto
                request.getPart("foto3").getInputStream()));
		produto.setFoto4(arq.upload(caminhoFoto,
                request.getPart("foto4").getName(),// parameto da foto
                request.getPart("foto4").getInputStream()));

		
		try {
			produto.validar();
			ProdutoDao dao = new ProdutoDao();
			dao.cadastrarproduto(produto);
			request.getRequestDispatcher("cadastrarprod.jsp").forward(request, response);
			request.setAttribute("msg", "<div class='alert alert-info'>Produto cadastrado com sucesso!!!</div>");
		} catch (Exception e) {
			request.setAttribute("erros", e.getMessage());
			e.printStackTrace();
			
		} 
	}
	
	public void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			ProdutoDao pd = new ProdutoDao();

			List<Produto> lista = pd.buscarproduto(nome);
            /*
			if (lista.size() == 0) {
				request.setAttribute("msg", "<div class='alert alert-info'>Nenhum Produto na lista!!!</div>");
			}*/
			request.setAttribute("nome", nome);
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("discricao.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addcarrinho(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int idprod = Integer.parseInt(request.getParameter("idproduto"));
			ProdutoDao pddao = new ProdutoDao();
			  double total = 0;
			 int index = 0;
			Produto prod = pddao.addprodutoporid(new Integer(idprod));
			
			List <Produto> produto = new ArrayList<>();
              for (Produto i : produto) {
		            total += i.getPreco();
		            index++;
		        }
		  
		   
		        double frete = 0;
		        for (Produto i : produto) {
		            frete += i.getPreco() * 0.10;
		        
		    }
			/*
			if (lista.size() == 0) {
				request.setAttribute("msg", "<div class='alert alert-info'>Nenhum Produto na lista!!!</div>");
			}*/
		
		    produto.add(prod);
			//request.setAttribute("idproduto", idprod);
		  request.getSession().setAttribute("produto", produto);
		  request.getSession().setAttribute("index", index);
		  request.getSession().setAttribute("frete", frete);
		  request.getSession().setAttribute("total", total);
			
		  request.getRequestDispatcher("mycarrinho.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buscaproduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int idproduto = Integer.parseInt(request.getParameter("idproduto"));
			ProdutoDao pd = new ProdutoDao();
			Produto produto =  pd.buscarprodutoporid(new Integer(idproduto));
			
			
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("descricao.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
					
					int idproduto = Integer.parseInt(request.getParameter("idproduto"));
					ProdutoDao pd = new ProdutoDao();
					Produto produto =  pd.buscarprodutoporid(new Integer(idproduto));
					
					
						request.setAttribute("produto", produto);
						request.getRequestDispatcher("editarproduto.jsp").forward(request, response);
					
				} catch (Exception e) {
					e.printStackTrace();
					
					request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
				}
			}
		

public void confirmar(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	 String nome = request.getParameter("nome");
	 String descricao = request.getParameter("descricao");
	 String foto1 = request.getParameter("foto1");
	 String foto2 = request.getParameter("foto2");
	 String foto3 = request.getParameter("foto3");
	 String foto4 = request.getParameter("foto4");
	 int qtdprod = Integer.parseInt(request.getParameter("quantidade"));
	 double preco = Double.parseDouble(request.getParameter("preco"));

	 Produto produto = new Produto();
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setFoto1(foto1);
		produto.setFoto2(foto2);
		produto.setFoto3(foto3);
		produto.setFoto4(foto4);
		produto.setPreco(preco);
		produto.setQtdprod(qtdprod);

	ProdutoDao pd = new ProdutoDao();
	try {
		pd.atualizarproduto(produto);
		request.setAttribute("produto", pd);//setando a variavel instanciada
		request.getRequestDispatcher("editarproduto.jsp").forward(request, response);
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
	}
}


public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String idproduto = request.getParameter("idproduto");
			ProdutoDao pd = new ProdutoDao();
			pd.excluirproduto(new Integer(idproduto));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			request.getRequestDispatcher("buscarproduto.jsp").forward(request, response);
		}	
		
	}

}
