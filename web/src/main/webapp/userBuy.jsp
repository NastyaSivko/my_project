<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<p style="color: darkblue; font-size: 20mm; margin-top: 10mm" align="center">
<table width="700px" ;>
    <col width="50%">
    <col width="50%">
    <tbody>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/userbuy" method="post">
                <fieldset>
                    <legend>Выберите тип номера и количество спальных мест:</legend>
                    <select name="listName">
                        <c:forEach items="${listRooms}" var="room">
                            <option value="${room.name}">${room.name}</option>
                        </c:forEach>
                    </select>
                    <select name="listBed">
                        <c:forEach var="i" begin="1" end="6">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Ок">
                </fieldset>
            </form>
        </td>
    </tr>
    </tbody>
</table>
<%--<p style="color: red; font-size: 5mm" align="center">${error}</p>--%>
</p>