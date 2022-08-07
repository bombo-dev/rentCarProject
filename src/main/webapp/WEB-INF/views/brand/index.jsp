<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/08/07
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>브랜드 리스트 페이지</title>
</head>
<body>
<div align="center">
    <hr color="green" width="300">
    <h2>브 랜 드 목 록 보 기</h2>
    <hr color="green" width="300">
    <table border="1" width="100%">
        <tr bgcolor="yellow">
            <th>브랜드 이름</th>
            <th>브랜드 번호</th>
        </tr>
        <c:if test="${empty brandList}">
            <tr>
                <td colspan="2">등록된 회원이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach var="dto" items="${brandList}">
            <tr>
                <td>${dto.brand}</td>
                <td>${dto.brand_num}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
