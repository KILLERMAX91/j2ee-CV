package web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Coordonnees;
import metier.Filter;

/**
 * Servlet implementation class SuppCV
 */
public class SuppCV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppCV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer requestURL = request.getRequestURL();
		String[] paramaterTab;
		Long id;
		paramaterTab = requestURL.toString().split("/");
		
		
		if(Filter.validateNumber(paramaterTab[paramaterTab.length-1])){
			id =  Long.parseLong(paramaterTab[paramaterTab.length-1]);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv");
			EntityManager em = emf.createEntityManager();
			  
			Coordonnees coordonnee = em.find(Coordonnees.class, id);
	
			em.getTransaction().begin();
			em.remove(coordonnee);
			em.getTransaction().commit();
			
		}
		
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
