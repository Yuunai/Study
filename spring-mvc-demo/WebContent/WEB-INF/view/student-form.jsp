<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

<title>Insert title here</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	
	Country:
	<form:select path="country">
	
		<form:options items="${countryOptions}" />
		
	</form:select>
	
	<br><br>
	
	Your favorite language:
	
	<br>
	
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" />
	C++ <form:radiobutton path="favoriteLanguage" value="C++" />
	PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		
	<br><br>
	
	Operating systems:
	
	<br>
	
	Linux <form:checkbox path="operatingSystems" value="Linux" />	
	Windows <form:checkbox path="operatingSystems" value="Windows" />
	MAC OS <form:checkbox path="operatingSystems" value="MAC OS" />
	
		
	<br><br>
	
	<input type="submit" value="Submit">
	</form:form>

</body>
</html>