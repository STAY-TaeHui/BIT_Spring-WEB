<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1 th:text="#{home}"></h1>
 <h2 th:text="#{hello}"></h2> 
 <a href="?lang=ko">한국어</a>
  <a href="?lang=en">영어</a>


</body>
</html>
