<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Customer confirmation</title>

</head>

<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Postal code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}

</body>

</html>