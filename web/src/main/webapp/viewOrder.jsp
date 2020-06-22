<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<a href="${pageContext.request.contextPath}/logout">
    <button>Выйти</button>
</a>


<h3><p align="center" style="color: green; font-size: 10mm">Новые заказы:</p></h3>
<p style="color: red; font-size: 5mm" align="center">${message}</p>
<p style="color: darkblue; font-size: 20mm; margin-top: 10mm" align="center">
<table border="3" cellspacing="0" cellpadding="20" width="700">
    <tr>
        <th style="font-size: 7mm">Логин пользователя</th>
        <th style="font-size: 7mm">Тип номера</th>
        <th style="font-size: 7mm">Количество спальных мест</th>
        <th></th>
    </tr>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <form action="${pageContext.request.contextPath}/vieworder" method="post">
                <th><input type="hidden" name="userLogin" value="${order.userLogin}">${order.userLogin}</th>
                <th><input type="hidden" name="nameRoom" value="${order.nameRoom}">${order.nameRoom}</th>
                <th><input type="hidden" name="bed" value="${order.beds}">${order.beds}</th>
                <th>
                    <input style="margin-top: 2mm" type="submit" value="Ответить на запрос">
                </th>
                </form>
            </tr>
        </c:forEach>
</table>
</p>
<a>
    <table>
        <tr></tr>
    </table>
    <p style="color: darkblue; font-size: 20mm; margin-top: 10mm" align="center">
        <c:if test="${currentPage != 1}">
            <a href="${pageContext.request.contextPath}/vieworder?page=${currentPage - 1}">
                <button><span aria-hidden="true">&laquo;</span></button>
            </a>
        </c:if>
        <c:forEach begin="1" end="${pageCount}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <button>${i}</button>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/vieworder?page=${i}">
                        <button>${i}</button>
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${currentPage lt pageCount}">
            <a href="${pageContext.request.contextPath}/vieworder?page=${currentPage + 1}">
                <button><span aria-hidden="true">&raquo;</span></button>
            </a>
        </c:if>
    </p>
</a>