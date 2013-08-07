<%@page import="py.edu.ucsa.dto.AlumnoDTO"%>
<%@page import="py.edu.ucsa.servlets.AlumnoServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type='text/javascript' src="bootstrap/js/jquery-1.7.2.min.js"></script>
<title>Añadir alumno</title>
</head>
<body>
	<form action="AlumnoServlet" method="post">
	<% AlumnoDTO alumno = request.getAttribute("alumno") != null ? (AlumnoDTO)request.getAttribute("alumno"): null; %>
		<label id="nombre">Nombre</label>
		<input type="text" name="nombre" value="<%= alumno == null ? "": alumno.getNombre() %>">
		<label id="apellido">Apellido</label>
		<input type="text" name="apellido" value="<%= alumno == null ? "": alumno.getApellido()%>">
		<input type="hidden" name="id" value="<%= alumno == null ? "": alumno.getId() %>">
		<input type="hidden" id="accion" name="accion" value="<%= alumno == null ? "agregar": "actualizar" %>">
		<input type="submit" id="botonEnviar" value="Enviar">
	</form>
</body>
</html>