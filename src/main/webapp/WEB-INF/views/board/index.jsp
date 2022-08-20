<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/08/20
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="board_top.jsp" %>
<div align="center">
    <h2> 글 목 록 </h2>
    <table style="border: 0; width: 700px">
        <tr style="background-color: #7fffd4">
            <td style="text-align: right">
                <a href="board_write.do">글 쓰 기</a>
            </td>
        </tr>
    </table>

    <table style="border: 1px; width: 700px">
        <tr style="background-color: yellowgreen; border-spacing: 3px">
            <th style="width:3px"></th>
            <th style="text-align: center">번호</th>
            <th style="width:30%">제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
        </tr>
        <c:if test="${not empty noticeBoard}">
            <c:forEach var="noticeBoard" items="${noticeBoard}">
                <tr style="background-color: lightgrey">
                    <td style="background-color: red"></td>
                    <td style="text-align: center">공지</td>
                    <td><b>${noticeBoard.title}</b></td>
                    <td style="color: red">${noticeBoard.writer}</td>
                    <td>${noticeBoard.reg_date}</td>
                    <td>${noticeBoard.readcount}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty listBoard}">
            <tr>
                <td colspan="6">등록된 게시글이 없습니다.</td>
            </tr>
        </c:if>
        <c:if test="${not empty listBoard}">
            <c:forEach var="dto" items="${listBoard}">
                <tr>
                    <td></td>
                    <td style="text-align: center">${dto.num}</td>
                    <td>${dto.title}</td>
                    <td>${dto.writer}</td>
                    <td>${dto.reg_date}</td>
                    <td>${dto.readcount}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <br>

    <div id="search">
        <div style="alignment: right">
            <a href="board_write.do">
<%--                <hidden><button>글 작성</button></hidden>--%>
            </a>
        </div>

        <div>
            <form action="">
                <input type="text">
                <button>검색</button>
            </form>
        </div>

        <div id="gap"></div>
    </div>

    <br>

    <div id="page">
        <div class="pageBtn">
            <a href="board.do?page=${page.end - page.perSection}">
                ${page.prev ? '이전' : ''}
            </a>
        </div>

        <div>
            <c:forEach var="n" begin="${page.begin }" end="${page.end}" step="1">
      		<span>
      		  <a href="board.do?page=${n }">
                      ${n }
              </a>
      		</span>
            </c:forEach>
        </div>

        <div class="pageBtn">
            <a href="board.do?page=${page.begin + page.perSection }">
                ${page.next ? '다음' : ''}
            </a>
        </div>
    </div>

    <br>

</div>
<%@ include file="board_bottom.jsp" %>

