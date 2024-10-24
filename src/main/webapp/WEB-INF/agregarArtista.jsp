<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar artista</title>
</head>
<body>
	<h1>Agregar Artistas</h1>
	<table>
		<div>
			<form:form action="/artistas/procesa/agregar" method="post" modelAttribute="artistas">
				<div>
					<form:label path="Nombre" for="Nombre">Nombre</form:label>
					<form:input path="Nombre" type="text" id="Nombre" name="Nombre" />
					<form:errors path="Nombre" />
				</div>
				<div>
					<form:label path="Apellido" for="Apellido">Apellido</form:label>
					<form:input path="Apellido" type="text" id="Apellido" name="Apellido" />
					<form:errors path="Apellido" />
				</div>
				<div>
					<form:label path="Biografia" for="Biografia">Biografia</form:label>
					<form:input path="Biografia" type="text" id="Biografia" name="Biografia" />
					<form:errors path="Biografia" />
				</div>
			
	</table>
	<button>Agregar</button>
	</form:form>
	</div>
	<a href="/canciones">
		<button>Volver a lista de canciones</button>
	</a>
</body>
</html>