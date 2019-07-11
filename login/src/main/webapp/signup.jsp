<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>This is Register Page. Enter your name.</h1>
	<form:form id="registerForm" modelAttribute="registerDtoObj"
		action="register-progress" method="post">
		<table align="center">
			<tr>
				<td><form:label path="firstName">FirstName: </form:label></td>
				<td><form:input path="firstName" name="firstName" id="firstName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName:</form:label></td>
				<td><form:input path="lastName" name="lastName"
						id="lastName" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">Phone: </form:label></td>
				<td><form:input path="phone" name="phone" id="phone" />
				</td>
			</tr>
			<tr>
				<td><form:label path="email">Email: </form:label></td>
				<td><form:input path="email" name="email" id="email" />
				</td>
			</tr>
			<tr>
				<td><form:label path="address">Address: </form:label></td>
				<td><form:input path="address" name="address" id="address" />
				</td>
			</tr>
			<tr>
				<td><form:label path="username">Username: </form:label></td>
				<td><form:input path="username" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password: </form:label></td>
				<td><form:password path="password" name="password" id="password" />
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td align="left"><form:button id="submit" name="submit">Submit</form:button>
				</td>
			</tr>
			<tr></tr>
		</table>
	</form:form>
</body>
</html>
