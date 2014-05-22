<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
HELLO WORLD! ${messageFromController}
<a href="hello2?sampleParameter=Sociopath">Go to second</a>
<a href="hello3">Redirect</a>

<form action="secondAction" method="post">
	<input type="text" name="formSubmissionData" />
	<input type="submit" value="Submit" />
</form>

<!-- confirm with the setters and getters from the model-->
<form:form action="sixthAction" method="post" commandName="personalInfoForm">
	First name <form:input path="name.firstName" /><br/>
	Last name <form:input path="name.lastName" /><br/>
	Age <form:input path="age" /><br/>
	Interest <form:input path="interest" /><br/>
 	<input type="submit" value="Submit Form" />
</form:form>

<a href="fourthAction">access service</a>

</body>
</html>