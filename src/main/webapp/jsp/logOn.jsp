<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../CSS/css/bootstrap.css">
    <link rel="stylesheet" href="../CSS/logOnStyle.css">

    <script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

   <title>Войти</title>
</head>
<body>
    <div class="container noLog">
            <p>Просматривать сайт могут только зарегистрированные пользователи </p>
            <p>Авторизуетесь на сайте по форме ниже </p>
    </div>
    <table border="0" cellspacing="10" cellpadding="2" width="100px" align="center" class="logOnForm">
        <tr>
            <td colspan="4" style="color:black">
                <h3> Вход в систему <h3>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                Логин:
            </th>
            <td colspan="2">
                <input type="text" id="login" name="login" pattern=".{3,}" title="Минимум 3 символа" placeholder="Введите логин"  autofocus>
            </td>
        </tr>
        <tr>
            <th colspan="2">
                Пароль:
            </th>
            <td colspan="2">
                <input type="password" id="password" name="password" pattern=".{3,}" title="Минимум 3 символа" placeholder="Введите пароль">
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" id="enter" onclick="vhodIn()"  value="Войти">
            </td>
            <td></td>
        </tr>
    </table>
    <div style="margin:10px 50%;">
    </div>

    <div class="container noLog">
        <p>Вы ещё не зарегистрированы на данном сайте? </p>
        <p>Тогда зарегистрируйтесь, используя форму ниже </p>
        <p> Логин и пароль должны содержать больше 3-х символов, быть нна английском языке и/или содержать цифры,
        и не содержать специальные символы &lt; &gt; &frasl; &quot; &prime; , ; | \ <p>
    </div>

    <table border="0" cellspacing="10" cellpadding="2" width="100px" align="center" class="logOnForm">
        <td colspan="4" style="color:black">
            <h3> Регистрация <h3>
        </td>
        <tr>
            <th colspan="2">
                Логин:
            </th>
            <td colspan="2">
                <input type="text" id="newLogin" name="newLogin" pattern=".{3,}" title="Минимум 3 символа" placeholder="Введите новый логин">
            </td>
        </tr>
        <tr>
            <th colspan="2">
                Пароль:
            </th>
            <td colspan="2">
                <input type="password" id="newPassword" name="newPassword" pattern=".{3,}" title="Минимум 3 символа" placeholder="Введите пароль">
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <input type="submit" onclick="goRegistr()" value="Зарегистрироваться">
            </td>
            <td></td>
        </tr>
    </table>
    <div style="margin:10px 50%"></div>

    <script src="../js/registration.js"> </script>
    <script src="../js/vxod.js"></script>
    <script src="../js/js/bootstrap.js"></script>
</body>
</html>