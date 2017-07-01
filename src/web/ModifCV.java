package web;

import java.io.IOException;
import java.util.Date;

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
import metier.DateMetier;
import metier.Filter;

/**
 * Servlet implementation class ModifCV
 */

public class ModifCV extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifCV() {
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
			if(coordonnee!=null){
				request.setAttribute("title", "Modifier votre CV" );
				request.setAttribute("coordonnee", coordonnee );
				this.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
			}
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
		
		String mail;
		String nom;
		String[] naissanceTab;
		String[] paramaterTab;
		Boolean permis = false;
		Date dateNaissance;
		StringBuffer requestURL;
		
		ServletContext context;
		RequestDispatcher rd;
		Long id;
		
		
		requestURL = request.getRequestURL();
		paramaterTab = requestURL.toString().split("/");
		Coordonnees coordonnee = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv");
		EntityManager em = emf.createEntityManager();
		if(Filter.validateNumber(paramaterTab[paramaterTab.length-1])){
			id =  Long.parseLong(paramaterTab[paramaterTab.length-1]);
		
			  
			coordonnee = (Coordonnees) em.find(Coordonnees.class, id);
			
		}
		
		if(coordonnee==null){
			
			context= getServletContext();
			 rd = context.getRequestDispatcher("/");
			 rd.forward(request, response);
		}
		

		if(!request.getParameter("nom").equals("") && !request.getParameter("mail").equals("") && !request.getParameter("naissance").equals("")){
			mail = request.getParameter("mail");
			nom = request.getParameter("nom");
			naissanceTab = request.getParameter("naissance").split("-");
			if(Filter.validateMail(mail) && naissanceTab.length==3){
				
				if(naissanceTab[0].length()==1){
					naissanceTab[0] = "0"+naissanceTab[0];
				}
				
				dateNaissance = DateMetier.initDate(naissanceTab[2]+"/"+naissanceTab[1]+"/"+naissanceTab[0]);
				if(dateNaissance!=null){
					if(request.getParameter("permis")!=null && !request.getParameter("permis").equals("")){
						permis = true;
					}
					
					coordonnee = (Coordonnees) em.find(Coordonnees.class, coordonnee.getId());
					em.getTransaction().begin();
					coordonnee.setMail(mail);
					coordonnee.setNaissance(dateNaissance);
					coordonnee.setNom(nom);
					coordonnee.setPermis(permis);
					em.getTransaction().commit();
					
					System.out.println(coordonnee.getNom());
					
					 context= getServletContext();
					 rd = context.getRequestDispatcher("/");
					 rd.forward(request, response);
				}
			}
			
		}
		
		doGet(request, response);
	}

}
