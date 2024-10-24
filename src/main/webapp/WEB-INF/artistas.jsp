<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de artistas</title>
</head>
<body>
	<h1>Lista de artistas</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Nombre</th>
			</tr>
		</thead>
		<tbody>
				<tr>
				<c:forEach var="artistas" items="${artistas}">
					<td>
					<a href="/artistas/detalle/${artistas.id}">
					${artistas.nombre}  ${artistas.apellido}
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/canciones">
		<button>Ir a canciones</button>
	</a>
	<a href="/artistas/formulario/agregar">
		<button>Agregar artista</button>
	</a>
</body>
</html>