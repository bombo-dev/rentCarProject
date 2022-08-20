<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/08/20
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="board_top.jsp" %>
<div align="center">
    <form id="f" action="board_write.do" method="post" onsubmit="return check()">
        <table border="1" width="600">
            <tr bgcolor="yellow">
                <td colspan="2" align="center">글쓰기</td>
            </tr>

            <c:if test="${loginMember.email eq 'admin'}">
                <tr style="background-color: #4f5050">
                    <select name="category">
                        <option value="notice">공지사항</option>
                        <option value="qa">Q&A</option>
                    </select>
                </tr>
            </c:if>

            <tr>
                <th bgcolor="yellow">제 목</th>
                <td><input type="text" name="title" size="60"></td>
            </tr>

            <tr>
                <th bgcolor="yellow">내 용</th>
                <td><textarea name="content" rows="13" cols="60" style="overflow: auto"></textarea></td>
            </tr>


            <tr bgcolor="yellow">
                <td colspan="2" align="center">
                    <input type="submit" value="글쓰기">
                    <input type="reset" value="다시작성">
                    <input type="button" value="목록보기"
                           onclick="window.location='board.do'">
                </td>
            </tr>
        </table>

    </form>
</div>
<%@ include file="board_bottom.jsp" %>
