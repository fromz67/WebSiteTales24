<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Додати казку</title>
</head>
<body>
    <form method="post" action="AddTaleServlet">
        <label>Назва казки:</label>
        <input type="text" name="title" required><br>
        <label>Текст казки:</label>
        <textarea name="taleText" required></textarea><br>
        <label>Кількість лайків:</label>
        <input type="number" name="likes" required><br>
        <button type="submit">Додати казку до архіву</button>
    </form>
</body>
</html>
