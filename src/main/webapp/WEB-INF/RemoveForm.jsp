<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Film</title>
</head>
<body>
  <form action="removeFilm.do" method="GET">
     <h1>Remove Film</h1>
     
     <label for="filmId">Confirm Film ID: </label>
    <input name="filmId" value="${removeFilm.id}"/>
    
    <input type="submit" value="Remove Film" />
  </form>
</body>
</html>