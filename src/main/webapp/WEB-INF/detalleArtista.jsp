<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detalle del artista</h1>
	<p>
		<b>Nombre: ${artistas.nombre} ${artistas.apellido}</b>
	<p>
		<b>Biografia: ${artistas.biografia} </b>
	<p>
		<b>Id: ${artistas.id}</b>
	<p>
	
	<c:forEach var="cancion" items="${artistas.canciones}">
		<b>Canciones: ${cancion.titulo}</b>
		</c:forEach>
	<div>
		<button>
		<a href="/canciones"> Regresar a canciones </a>
		</button>
	</div>
		<button>
		<a href="/artistas">Volver a lista de artistas</a>
		</button>
		</form>
	</div>
	
	
</body>
</html>