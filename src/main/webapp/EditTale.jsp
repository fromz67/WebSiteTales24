<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="sources.database.InMemoryTales, sources.entities.Tale" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редагувати казку</title>
</head>
<body>
    <%
        int index = Integer.parseInt(request.getParameter("index"));
        Tale tale = InMemoryTales.getTale(index);
    %>
    <form method="post" action="EditTaleServlet">
        <input type="hidden" name="index" value="<%= index %>">
        <label>Назва казки:</label>
        <input type="text" name="title" value="<%= tale.getTitle() %>" required><br>
        <label>Текст казки:</label>
        <textarea name="taleText" required><%= tale.getTaleText() %></textarea><br>
        <label>Кількість лайків:</label>
        <input type="number" name="likes" value="<%= tale.getLikes() %>" required><br>
        <button type="submit">Закінчити редагування</button>
    </form>
</body>
</html>
