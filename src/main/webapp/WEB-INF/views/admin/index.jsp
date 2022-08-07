<%--
  Created by IntelliJ IDEA.
  User: munjong-un
  Date: 2022/08/06
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- index.jsp -->
<html>
<head>
    <title> 관리자 페이지 </title>
</head>
<body>
<div align="center">
    <hr color="green" width="300">
    <h2>차 종 등 록 페 이 지</h2>
    <hr color="green" width="300">
    <form name="f" action="category_insert.do" method="post">
        <table border="1">
            <tr>
                <td>
                    차종 : <input type="text" name="car_name"><br>
                    브랜드 : <input type="text" name="brand"><br>
                    외형 : <input type="text" name="appearance"><br>
                    용도 : <input type="text" name="use"><br>
                    연료 : <input type="text" name="fuel"><br>
                    <input type="submit" value="입력">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
    <hr color="green" width="300">
    <h2>차 종 삭 제 페 이 지</h2>
    <hr color="green" width="300">
    <form name="f" action="category_delete.do" method="post">
        <table border="1">
            <tr>
                <td>코드 번호 : <input type="text" name="num">
                    <input type="submit" value="삭제">
                </td>
            </tr>
        </table>
    </form>
    <hr color="green" width="300">
    <h2>차 종 찾 기 페 이 지</h2>
    <hr color="green" width="300">
    <form name="f" action="category_find.do" method="post">
        <table border="1">
            <tr>
                <td>
                    <select name="column">
                        <option value="brand">브랜드</option>
                        <option value="car_name">차 이름</option>
                        <option value="appearance">외형</option>
                        <option value="use">용도</option>
                        <option value="fuel">연료</option>
                    </select>
                </td>
                <td>
                    <input type="text" name="find_text">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="입력">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
    <hr color="green" width="300">
    <h2>차 종 보 기 페 이 지</h2>
    <hr color="green" width="300">
    <form name="f" action="category_list.do" method="post">
        <table border="1">
            <tr>
                <td>
                    <input type="submit" value="차종보기페이지이동">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

