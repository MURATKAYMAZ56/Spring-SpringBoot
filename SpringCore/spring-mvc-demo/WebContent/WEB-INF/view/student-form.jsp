<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>


<body>


	<form:form action="processForm" modelAttribute="student">
	
First name:<form:input path="firstName" />

		<br><br>
		
Last name:<form:input path="lastName" />

		<br><br>
		Country: 
		<form:select path="country" >
		<form:options items="${student.countryOptions}"></form:options>
		
		
		</form:select>
		
		<br><br>
		Favorite Programming Languages:<br>
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
		
		<br><br>
		
		
		
		Operating Systems: 
		
		Linux<form:checkbox path="operatingSystem" value="Linux"/>
		Mac OS<form:checkbox path="operatingSystem" value="Mac OS"/>
		MS Windows<form:checkbox path="operatingSystem" value="MS Windows"/>
		<br><br>
		
		Hobby:
		<form:checkboxes items="${student.hobbyOptions }" path="hobby"/>
		<br><br>

<input type="submit" value="Submit">

	</form:form>
</body>
</html>