<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<p style="color: darkblue; font-size: 20mm; margin-top: 10mm" align="center">
<table border="3" cellspacing="0" cellpadding="20" width="700">
    <tr>
        <th style="font-size: 7mm">Логин пользователя</th>
        <th style="font-size: 7mm">Тип номера</th>
        <th style="font-size: 7mm">Количество спальных мест</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <form action="${pageContext.request.contextPath}/answerfororder" method="post">
            <th><input type="hidden" name="userLogin" value="${userOrderAnswer.userLogin}"/>${userOrderAnswer.userLogin}
            </th>
            <th><input type="hidden" name="nameRoom" value="${userOrderAnswer.nameRoom}"/>${userOrderAnswer.nameRoom}
            </th>
            <th><input type="hidden" name="bed" value="${userOrderAnswer.beds}"/>${userOrderAnswer.beds}</th>
            <th>
                <select name="answer">
                    <option>YES</option>
                    <option>NO</option>
                </select>
            </th>
            <th>
                <select name="numberRoom">
                    <c:forEach items="${number}" var="num">
                        <option value="${num}">${num}</option>
                    </c:forEach>
                </select>
            </th>
            <th>
                <select name="costs">
                    <c:forEach items="${costList}" var="i" >
                        <option value="${i.cost}">${i.cost}</option>
                    </c:forEach>
                </select>
            </th>
            <th>
                <input style="margin-top: 2mm" type="submit" value="Отправить ответ">
            </th>
        </form>
    </tr>

</table>


</p>
