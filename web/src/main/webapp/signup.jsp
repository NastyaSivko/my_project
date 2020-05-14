<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3><p align="center">Вход:</p></h3>
<form action="${pageContext.request.contextPath}/signup" method="post">
    <p align="center"><label for="phone">Login</label>
        <input id="phone" type="text" name="phone"> <br/>

        <label for="email">Password</label>
        <input id="email" type="email" name="email"><br/>
  <input style="margin-top: 2mm" type="submit" value="Войти"></p>
</form>
<a href="${pageContext.request.contextPath}/phone">
    <p align="center"><button>Зарегистрироваться</button></p>
</a>
<p style="color: red; font-size: 5mm" align="center">${error}</p>