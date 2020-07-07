<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>



<head>
<title>Murat company page</title>

</head>



<body>
<h2> Company Page</h2>
<hr>

Welcome to Murat company home page

<!-- Add logout button -->


<form:form action="${pageContext.request.contextPath}/logut" 
method="POST">


<input type="submit" value="Logout"/>




</form:form>

</body>
</html>