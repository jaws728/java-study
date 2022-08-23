<%--
  Created by IntelliJ IDEA.
  User: pck
  Date: 2022/8/13
  Time: 04:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="true">
        <h1>True</h1>
    </c:if>

    <table>
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <%--    varStatus: count or index    --%>
        <c:forEach items="${brands}" var="brand">
            <tr align="center">
                <td>${brand.id}</td>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status == 1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.status != 1}">
                    <td>禁用</td>
                </c:if>
                <td><a href="#">修改</a> <a href="#">删除</a> </td>
            </tr>
        </c:forEach>
    </table>

    <c:forEach begin="0" end="10" step="1" var="i">
        ${i}<br>
    </c:forEach>
</body>
</html>
