<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="loginFormStyle.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вхід</title>
</head>
<body>
    <a class="RetToMainPage" href="index.jsp">
        Повернутися на головну сторінку <br>
        <-
    </a>
    <form class="form" action="LoginServlet" method="post">
        <p class="form-title">Вхід в акаунт</p>
        <div class="input-container">
            <input type="text" name="login" placeholder="Введіть логін" value="${not empty param.login ? param.login : ''}" required>
        </div>
        <div class="input-container">
            <input type="password" name="password" placeholder="Введіть пароль" value="${not empty param.password ? param.password : ''}" required>
        </div>
        <button type="submit" class="submit">Увійти</button>
        <div>
            <% if ("true".equals(request.getParameter("error"))) { %>
                <p style="color:red;">Неправильний логін або пароль.</p>
            <% } %>
        </div>
    </form>
</body>
</html>