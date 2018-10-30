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
<%@ page import="com.krunoslav.util.AttributeNames" %>

<html>
<head>
    <title>Item Details</title>
</head>
<body>
<div align="center">
    <c:url var="viewUrl" value="${Mappings.ITEMS}"/>
    <a href="${viewUrl}">Back to list</a>

    <table border="1" cellpadding="5">

        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Deadline</th>
            <th>View Details</th>
        </tr>

            <tr>
                <td><c:out value="${todoItem.id}"/></td>
                <td><c:out value="${todoItem.title}"/></td>
                <td><c:out value="${todoItem.deadline}"/></td>
                <td><c:out value="${todoItem.detail}"/></td>
            </tr>

</div>

</body>
</html>
