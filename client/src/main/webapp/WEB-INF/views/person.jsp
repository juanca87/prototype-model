<%@ include file="/WEB-INF/views/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<h1>Students Data</h1>
<form:form action="person" method="POST" commandName="person">
    <table>
        <tr>
            <td>Id</td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>First name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><form:input path="lastName" /></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
                <input type="submit" name="action" value="Search" />
            </td>
        </tr>
    </table>
</form:form>
<br>
<table border="1">
    <th>ID</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Year level</th>
    <c:forEach items="${personList}" var="person">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.lastName}</td>
            <td>${person.age}</td>
            <td>${person.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>