<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DashBoard</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <h2>Dashboard Product</h2>
    <table border="1" cellpadding="10" cellspacing="0">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="prod" items="${products}">
            <tr>
                <td><c:out value="${prod.id}"/></td>
                <td><c:out value="${prod.name}"/></td>
                <td><c:out value="${prod.category}"/></td>
                <td><c:out value="${prod.price}"/></td>

                <td>
                    <a href="<%=request.getContextPath()%>/deleteProduct?id=<c:out value="${prod.id}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
