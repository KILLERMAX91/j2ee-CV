<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page import="javax.persistence.EntityManager" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%@ page import="javax.persistence.EntityTransaction" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.Query" %>
<%@ page import="java.util.Collection" %>
<%@ page import="entities.Coordonnees" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="include/header.jsp" />
	<div class="row">	
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}/Create/CV" class="btn btn-link">créer un CV</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<table class="table table-striped">
			<thead>
				<tr>
					<th>nom</th>
					<th>email</th>
					<th>modif</th>
					<th>supp</th>
				</tr>
			</thead>
			<%
			 
				Collection<Coordonnees> coordonnees = (Collection<Coordonnees>) request.getAttribute("coordonnees");
			String name = request.getContextPath();
				for(Coordonnees coordonnee : coordonnees){
					out.println("<tr>"); 
					out.println("<td>"); 
					out.println(coordonnee.getNom()); 
					out.println("</td>"); 
					out.println("<td>"); 
					out.println(coordonnee.getMail()); 
					out.println("</td>"); 
					out.println("<td>"); 
					out.println("<a href='"+name+"/Modif/CV/"+coordonnee.getId()+"' class=\"btn btn-link\">modif</a>"); 
					out.println("</td>");
					out.println("<td>"); 
					out.println("<a href='"+name+"/Supp/CV/"+coordonnee.getId()+"' class=\"btn btn-link\">supp</a>"); 
					out.println("</td>");
					out.println("</tr>"); 
				}
			
			%>
			</table>
		</div>
	</div>
<jsp:include page="include/footer.jsp" />