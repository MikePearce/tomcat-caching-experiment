<%@ page contentType="text/html; charset=UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head></head>
<body>

<h1>${model.text}</h1>

<ul>
    <c:forEach items="${model.list}" var="value">
    <li>${value}</li>
    </c:forEach>
</ul>
</body>
</html>