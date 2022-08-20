
<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/08/06
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>차종 리스트 페이지</title>
</head>
<body>
<div align="center">
    <hr color="green" width="300">
    <h2>차 종 목 록 보 기</h2>
    <hr color="green" width="300">
    <table border="1" width="100%">
        <tr bgcolor="yellow">
            <th>번호</th>
            <th>코드</th>
            <th>차종</th>
            <th>브랜드</th>
            <th>외형</th>
            <th>용도</th>
            <th>연료</th>
            <th>수정|삭제</th>
        </tr>
        <c:if test="${empty listCategory}">
            <tr>
                <td colspan="7">등록된 회원이 없습니다.</td>
            </tr>
        </c:if>
        <c:forEach var="dto" items="${listCategory}">
            <tr>
                <td>${dto.num}</td>
                <td>${dto.car_code}</td>
                <td>${dto.car_name}</td>
                <td>${dto.brand}</td>
                <td>${dto.appearance}</td>
                <td>${dto.use}</td>
                <td>${dto.fuel}</td>
                <td><a href="#">삭제</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
