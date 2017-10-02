<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>

	<title>Customer registration form</title>

	<style>
		.error{color:red}
	</style>

</head>

<body>

<i>Fill out the form. (*) is required!</i>

<form:form action="processForm" modelAttribute="customer" >
	First name: <form:input path="firstName" type="text" />
	
	<br>
	
	Last name (*): <form:input path="lastName" type="text" />
	<form:errors path="lastName" cssClass="error" />
	
	<br>
	
	Free passes: <form:input path="freePasses" type="text" />
	<form:errors path="freePasses" cssClass="error" />	
	
	<br>
	
	Postal code: <form:input path="postalCode" type="text" />
	<form:errors path="postalCode" cssClass="error" />
	
	<br>
	
	Course code: <form:input path="courseCode" type="text" />
	<form:errors path="courseCode" cssClass="error" />
	
	<br>
	
	<input type="submit" value="Submit!" />
	
</form:form>

</body>

</html>