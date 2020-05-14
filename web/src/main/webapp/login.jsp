<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<h3><p align="center">Регистрация:</p></h3>
<form action="${pageContext.request.contextPath}/phone" method="post">
    <p align="center"> <label for="name">Name</label>
    <input id="name" type="text" name="name"><br/>

    <label for="surname">SurName</label>
    <input id="surname" type="text" name="surname"><br/>

    <label for="phone">Login</label>
    <input id="phone" type="text" name="phone"> <br/>

    <label for="email">Password</label>
    <input id="email" type="email" name="email"><br/>
    <input style="margin-top: 2mm" type="submit" value="Сохранить"></p>
</form>
<p style="color: red; font-size: 5mm" align="center">${error}</p>
