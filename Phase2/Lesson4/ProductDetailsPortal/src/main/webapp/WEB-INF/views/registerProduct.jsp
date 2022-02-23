
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register Product</title>
</head>
<body>
    <%@include file="header.jsp"%>

    <div align="center">
        <h1>Register Product</h1>
        <sform:form method="post"  action="addProduct" modelAttribute="productCommand">
            <label>
                name:
                <sform:input path="name"/>
            </label>
            <br/>
            <label>
                categoy:
                <sform:input path="category"/>
            </label>
            <br/>
            <label>
                price:
                <sform:input path="price"/>
            </label>
            <br/>
            <input type="submit"/>
        </sform:form>

    </div>

</body>
</html>
