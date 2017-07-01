package web;

import java.io.IOException;

import java.util.Date;
import entities.Coordonnees;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.DateMetier;
import metier.Filter;

/**
 * Servlet implementation class CreateCV
 */

public class CreateCV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setAttribute("title", "Ajouter votre CV" );
		Coordonnees coordonnee= new Coordonnees();
		coordonnee.setNom("");
		coordonnee.setMail("");
		coordonnee.setNaissance(new Date());
		coordonnee.setPermis(false);
		request.setAttribute("coordonnee", coordonnee );
		 this.getServletContext().getRequestDispatcher("/WEB-INF/create.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail;
		String nom;
		String[] naissanceTab;
		Boolean permis = false;
		Coordonnees coordonnee;
		Date dateNaissance;
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
					
					coordonnee = new Coordonnees();
					coordonnee.setMail(mail);
					coordonnee.setNaissance(dateNaissance);
					coordonnee.setNom(nom);
					coordonnee.setPermis(permis);
					
					 EntityManager em = Persistence .createEntityManagerFactory("cv").createEntityManager();
					 em.getTransaction().begin();
					 em.persist(coordonnee);
					 em.getTransaction().commit();
					 
					 ServletContext context= getServletContext();
					 RequestDispatcher rd= context.getRequestDispatcher("/");
					 rd.forward(request, response);
				}
			}
			
		}
		
		doGet(request, response);
	}

}
