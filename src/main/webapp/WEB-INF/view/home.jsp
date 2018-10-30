<%--
  Created by IntelliJ IDEA.
  User: kguldan
  Date: 19.10.2018.
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.krunoslav.util.Mappings" %>

<html>
<head>
    <title>Todo List Application</title>
</head>
<body>
    <div align = "center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
        <h2><a href="${itemsLink}">Show Todo Items</a></h2>
    </div>

</body>
</html>
