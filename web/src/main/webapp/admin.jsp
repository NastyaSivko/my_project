<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>
    <p style="color: crimson; font-size: 10mm; margin-top: 10mm" align="center">
        Добро пожаловать Администратор!
    </p>
</h3>
<table align="center">
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/vieworder">
                <button style="font-size: 5mm">Look at orders</button>
            </a>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/updaterooms">
                <button style="font-size: 5mm">Updates rooms</button>
            </a>
        </td>
    </tr>
</table>