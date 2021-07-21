<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<h1>New Manager</h1>
    <form:form action="" method="post" modelAttribute="employee">
        <p>
            <form:label path="firstName"> First Name: </form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName"> Last Name: </form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
    
</body>
</html>