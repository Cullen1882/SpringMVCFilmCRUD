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
<title>Update A Film</title>
</head>
<body>
	<div class="container">
	
	<h3>Film</h3>
  <form action="updateFilm.do" method="POST">
  
    <label for="filmId">Film ID </label>
    <input name="filmId" value="${updateFilm.id}" type="hidden"/>
    
    <label for="title">Title:</label> 
    <input type="text" name="title" value="${updateFilm.title}"/> <br>
   <label for="desc">Description:</label> 
    <input type="text" name="desc"  value="${updateFilm.desc}"/> <br>
    <label for="langId">Language:</label>
    <input type="text" name="langId"  value="${updateFilm.langId}"/> <br>
    <label for="rating">Rating:</label>
    <input type="text" name="rating"  value="${updateFilm.rating}"/> <br>
   <label for="relYear">Release Year:</label>
    <input type="text" name="relYear"  value="${updateFilm.relYear}"/>  <br>
    
    <input type="submit" value="Update Film" />
  </form>
	
	</div>
</body>
</html>