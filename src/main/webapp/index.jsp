<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="sources.database.InMemoryTales, sources.entities.Tale" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="mainstyles.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Казка на ніч</title>
    <style>
        .top-left-container {
            <% 
                String userType = "Гість";
                if (session != null && session.getAttribute("userType") != null) {
                    userType = (String) session.getAttribute("userType");
                }
                if (userType.equals("Адміністратор")) {
            %>
                padding-bottom: 200px;
            <% 
                } else {
            %>
                padding-bottom: 250px;
            <% 
                }
            %>
        }
    </style>
</head>
<body>
    <div class="main-container">
        <div class="container">
            <img src="img/title.png" width="500" alt="123">
        </div>
        <div class="container">
            <div class="top-left-container">
                <div class="top-left-inner-container">
                    Ти увійшов як: <br> 
                    <span class="user-type">
                        <h1>
                            <c:set var="userType" value="${sessionScope.userType != null ? sessionScope.userType : 'Гість'}" />
                            ${userType}
                        </h1>
                    </span>
                </div>
            </div>
            <div class="top-right-container">
                <c:choose>
                    <c:when test="${sessionScope.userType != null}">
                        <a class="logout" href="logout">Вийти з Облікового запису</a>
                    </c:when>
                    <c:otherwise>
                        <a class="login" href="login.jsp">Login</a>
                    </c:otherwise>
                </c:choose>
                <form method="GET" action="SearchServlet">
                    <input type="text" name="query" placeholder="Введіть слова у назві казки">
                    <button type="submit">Пошук</button>
                </form>
            </div>
        </div>
        <c:if test="${sessionScope.userType == 'Адміністратор'}">
            <div class="admin-buttons">
                <a href="AddTale.jsp"><button>Додати</button></a>
            </div>
        </c:if>
        <div class="container">
            <div class="resizable-container">
                <c:forEach var="tale" items="${InMemoryTales.getTales()}" varStatus="status">
                    <div class="story-title">
                        <a class="story-name" href='TalePage.jsp?index=${status.index}'>${tale.title}</a>
                        <div class="button-container">
                            <form method="post" action="LikeServlet">
                                <input type="hidden" name="index" value="${status.index}">
                                <button type="submit" class="like-btn">
                                    Лайк (${tale.likes})
                                </button>
                            </form>
                            <c:if test="${sessionScope.userType == 'Адміністратор'}">
                                <a href="EditTale.jsp?index=${status.index}"><button>Редагувати</button></a>
                                <form method="post" action="DeleteTaleServlet" style="display:inline;">
                                    <input type="hidden" name="index" value="${status.index}">
                                    <button type="submit">Видалити</button>
                                </form>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</body>
</html>
