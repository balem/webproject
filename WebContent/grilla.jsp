<%@page import="py.edu.ucsa.dto.*" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<AlumnoDTO> lista =  (List<AlumnoDTO>) session.getAttribute("alumnos");%>
<% Iterator<AlumnoDTO> it = lista.iterator(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="StyleSheet" type="css" href="/webproject/bootstrap/css/bootstrap.css">
	<link rel="StyleSheet" type="css" href="/webproject/bootstrap/css/bootstrap-responsive.css">
	<script type="text/javascript" src="/webproject/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-modal.js"></script>
	<script type='text/javascript' src="bootstrap/js/jquery-1.7.2.min.js"></script>
	<style type="text/css">
	
		body{
			text-align: center;
		}
		div#container{
			margin: margin:0 auto;
		}
		
	</style>
<script type='text/javascript'> 
	$('#myModal').show();

</script>


</head>
<body>
<div id="container" class="row-fluid">
	<div class="span3" style="">
		<ul class="nav nav-tabs nav-stacked">
			<li><a href="">Inicio</a></li>
			<li><a href="">Agregar</a></li>
			<li><a href="">Cerrar	</a></li>
		</ul>
	</div>
	<div class="span8">
		<h1>Lista de alumnos</h1>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<%
					while(it.hasNext()){
						AlumnoDTO a = it.next();	
				%>
				<tr id="row">
					<td><span>
						<%= a.getId() %>
						</span>
					</td>
					<td>
						<span>
						<%= a.getNombre() %>
						</span>
					</td>
					<td>
						<span>
						<%= a.getApellido() %>
						</span>
					</td>
					<td>
						<form action="AlumnoServlet" method="get">
							<input type="hidden" name="id" value="<%= a.getId() %>">
							<input type="submit" name="accion" value="modificar" class="btn btn-warning">
						</form>
						<form action="AlumnoServlet" method="get">
							<input type="hidden" name="id" value="<%= a.getId() %>">
							<input type="submit" name="accion" value="eliminar" class="btn btn-danger" value="eliminar">
						</form>
					</td>
				</tr>
				<%
					}
				%>
				
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<a class="btn btn-primary" data-toggle="modal" data-target="#myModal" href="addalumno.jsp">
							Agregar
						</a>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
	
	<!-- Button to trigger modal -->

 
<!-- Modal -->
<div id="myModal" style="display:none" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <form action="AlumnoServlet" method="get">
  	<input type="submit" name="accion" value="añadir" class="btn">
  </form>
</div>
</div>
</body>	
</html>