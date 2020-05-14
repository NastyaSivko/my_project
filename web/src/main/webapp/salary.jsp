<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<a href="${pageContext.request.contextPath}/logout"><button>Выйти</button></a>

<h3><p style="color: green; font-size: 10mm">Расчёт зарплаты</h3>
<table border="3" cellspacing="0" cellpadding="20" width="700">
    <tr>
        <th style="font-size: 7mm">Название</th>
        <th style="font-size: 7mm">Процент, %</th>
        <th style="font-size: 7mm">Сумма, руб.</th>
    </tr>
    <tr>
        <td style="font-size: 5mm">Начислили ЗП</td>
        <td style="font-size: 5mm" valign="middle" align="center">-</td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${userSalary.getSalary()}" default='defaultValue' escapeXml='true'/></td>
    </tr>
    <tr>
        <td style="font-size: 5mm">ФСЗН</td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${userSalary.getTax()}" default='defaultValue' escapeXml='true'/></td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${fszn}" default='defaultValue' escapeXml='true'/></td>
    </tr>
    <tr>
        <td style="font-size: 5mm">Белгосстрах</td>
        <td style="font-size: 5mm" valign="middle" align="center">1</td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${bgs}" default='defaultValue' escapeXml='true'/></td>
    </tr>
    <tr>
        <td style="font-size: 5mm">Подохоный налог</td>
        <td style="font-size: 5mm" valign="middle" align="center">13</td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${pod}" default='defaultValue' escapeXml='true'/></td>
    </tr>
    <tr>
        <td style="font-size: 5mm">Профсоюз</td>
        <td style="font-size: 5mm" valign="middle" align="center">1</td>
        <td style="font-size: 5mm" valign="middle" align="center"><c:out value="${prof}" default='defaultValue' escapeXml='true'/></td>
    </tr>
    <tr>
        <th style="font-size: 5mm"><p align="left">Получить</th>
        <td style="font-size: 5mm"></td>
        <th style="font-size: 5mm" valign="middle" align="center"><c:out value="${salary}" default='defaultValue' escapeXml='true'/></th>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/pageuser"><p style="margin-top: 2mm"><button>Назад</button></p></a>