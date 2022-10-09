<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
<title>Films</title>
</head>
<body>
	<h1>Films With KeyWord: <c:out value="${keyword}"/></h1>
	<div class="container">
		<c:forEach var="film" items="${films}" >
			<c:choose>
				<c:when test="${! empty films}">
					<table class="table table-bordered border-info">
						<thead>
							<tr>
								<th scope="col">Film Title</th>
								<th scope="col">Film Description</th>
								<th scope="col">Film Language</th>
								<th scope="col">Film Rating</th>
								<th scope="col">Film Release Year</th>
								<th scope="col">Update Film</th>
								<th scope="col">Remove Film</th>
								
							</tr>
						</thead>
						<tbody class="table-group-divider">
							<tr>
								<td>${film.title}</td>
								<td>${film.desc}</td>
								<td>${film.lang}</td>
								<td>${film.rating}</td>
								<td>${film.relYear}</td>
							<td><form action="updateFilmDetails.do" action="POST">
									<input type="hidden" name="filmId" value="${film.id}" />
									<input type="submit" value="Update Film"
										class="btn btn-primary" />
								</form></td>
								<td><a href="RemoveForm.html">Remove Film</a></td>
							</tr>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<p>No Films Found</p>
				</c:otherwise>
			</c:choose>

		</c:forEach>
	</div>
</body>
</html>