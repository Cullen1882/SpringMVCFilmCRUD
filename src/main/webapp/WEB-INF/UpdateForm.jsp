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
    
    <label for="rating">Rating:</label> <select id="rating"
    name="rating" class="btn btn-secondary dropdown-toggle">
    <option value="${updateFilm.rating}" selected="${updateFilm.rating}">${updateFilm.rating}</option>
    <option value="G">G</option>
    <option value="PG">PG</option>
    <option value="PG13">PG13</option>
    <option value="NC17">NC17</option>
    <option value="R">R</option>
    </select>
   <%--  <input type="text" name="rating"  value="${updateFilm.rating}"/> <br> --%>
   <label for="relYear">Release Year:</label>
    <input type="text" name="relYear"  value="${updateFilm.relYear}"/>  <br>
   	<label for="rentDur">Rental Duration:</label> <input type="text" name="rentDur" value="${updateFilm.rentDur}" /><br> 
			<label
			for="rentRate">Rental Rate:</label> <input type="text" name="rentRate" value="${updateFilm.rentRate}"/><br> 
			<label
			for="length">Length:</label> <input type="text" name="length" value="${updateFilm.length}"/><br> 
			<label
			for="repCost">Replacement Cost:</label> <input type="text" name="repCost" value="${updateFilm.repCost}"/><br> 
			<label
			for="specFeat">Special Features:</label> <select id="specFeat" name="specFeat" 
			class="btn-secondary dropdown-toggle">
			<option value="${updateFilm.specFeat}" selected="${updateFilm.specFeat}">${updateFilm.specFeat}</option>
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind The Scenes">Behind The Scenes</option>
			</select><br> 

		<label for="langId">Language</label> <select id="langId"
			name="langId" class="btn btn-secondary dropdown-toggle">
			<option value="${updateFilm.lang}" selected="${updateFilm.lang}">${updateFilm.lang}</option>
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Mandarin</option>
			<option value="5">French</option>
			<option value="6">German</option>
		</select> <br> 
		<label for="categoryId">Category</label> <select id="categoryId"
			name="categoryId" class="btn btn-secondary dropdown-toggle">
			<option value="${updateFilm.category}" selected="${updateFilm.category}">${updateFilm.category}</option>
			<option value="1">Action</option>
			<option value="2">Animation</option>
			<option value="3">Children</option>
			<option value="4">Classics</option>
			<option value="5">Comedy</option>
			<option value="6">Documentary</option>
			<option value="7">Drama</option>
			<option value="8">Family</option>
			<option value="9">Foreign</option>
			<option value="10">Games</option>
			<option value="11">Horror</option>
			<option value="12">Music</option>
			<option value="13">New</option>
			<option value="14">Sci-Fi</option>
			<option value="15">Sports</option>
			<option value="16">Travel</option>
		</select>  
    <input type="submit" value="Update Film" />
  </form>
	<a href="index.html" >Home Page</a>
	</div>
</body>
</html>