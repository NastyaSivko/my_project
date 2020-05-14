<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<h3>
    <p style="color:mediumspringgreen; font-size: 15mm;-webkit-text-stroke-width: 0.6mm; -webkit-text-stroke-color: green; margin-top: 10mm" align="center">
    <em>Welcome to Hotel Kempinski!</em>
    </p>
</h3>
<p align="center" >
    <img src="https://hotels.sletat.ru/i/f/66854_24.jpg" height="400 mm" vspace="0.1px" />
</p>
<p   align="center">
<table>
<tr>
<th>
    <a href="${pageContext.request.contextPath}/viewroom">
        <button style="font-size: 5mm">Look at rooms</button>
    </a>
</th>
<th>
    <a href="${pageContext.request.contextPath}/phone">
       <button style="font-size: 5mm">Sign up</button>
    </a>
</th>
<th>
    <a href="${pageContext.request.contextPath}/signup">
        <button style="font-size: 5mm">Sign in</button>
    </a>
</th>
</tr>
</table>
</p>

