<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Coordonnees" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<% 

Coordonnees Coordonnee = (Coordonnees) request.getAttribute("coordonnee");
%>
<jsp:include page="include/header.jsp" />
		<div class="row">
		<div class="col-md-8">
			<form class="form-horizontal"  method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<h1><% out.print(request.getAttribute("title")); %></h1>
					</div>
				</div>
			 	<div class="form-group">
			    	<label for="mail" class="col-sm-2 control-label">Email</label>
				    <div class="col-sm-10">
				      <input type="email" class="form-control" value="<% out.print(Coordonnee.getMail()); %>" id="mail" name="mail" placeholder="Email">
				    </div>
			 	 </div>
				<div class="form-group">
			    	<label for="nom" class="col-sm-2 control-label">nom</label>
				    <div class="col-sm-10">
				      <input type="text" class="form-control" value="<% out.print(Coordonnee.getNom()); %>"  id="nom" name="nom" placeholder="Nom">
				    </div>
			 	 </div>
			 	 <div class="form-group">
			    	<label for="nom" class="col-sm-2 control-label">naissance</label>
				    <div class="col-sm-10">
				    	<%
				    	String naissance = new SimpleDateFormat("d-MM-yyyy").format(Coordonnee.getNaissance());
				    	%>
				      <input type="text" class="form-control" value="<% out.print(naissance); %>" id="naissance" name="naissance" placeholder="Naissance">
				    </div>
			 	 </div>
				   <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <div class="checkbox">
				        <label>
				        	<%
				        	String checked = "";
				        	if(Coordonnee.getPermis()){
				        		checked = "checked";
				        	}
				        	%>
				          <input name="permis" type="checkbox" <% out.print(checked); %>> permis
				        </label>
				      </div>
				    </div>
				  </div>
				   <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">Envoyer</button>
				    </div>
				  </div>
			</form>
		  </div>
		</div>
	</div>

	<script type="text/javascript">
	    $(function () {
	        $('#naissance').datetimepicker({
	        	format: 'DD-MM-YYYY',
	        });
	    });
	</script>
<jsp:include page="include/footer.jsp" />