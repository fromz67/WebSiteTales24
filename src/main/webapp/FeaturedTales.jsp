
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                if (userType.equals("Гість")) {
            %>
                padding-bottom: 171px;
            <% 
                } else {
            %>
                padding-bottom: 171px;
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
                            <% 
                                if (session != null && session.getAttribute("userType") != null) {
                                    userType = (String) session.getAttribute("userType");
                                    out.print(userType);
                                } else {
                                    out.print(userType);
                                }
                            %>
                        </h1>
                    </span> <br>               
                    <a class="Back-to-Main-Page" href="index.jsp">
                      <span class="Back-to-Main-Page">ПОВЕРНУТИСЯ НА ГОЛОВНУ СТОРІНКУ</span>  
                    </a> <br>  
                </div>
            </div>
            <div class="top-right-container">
                <%
                    if (session != null && session.getAttribute("userType") != null) {
                %>
                    <a class="logout" href="logout">
                        Вийти з Облікового запису
                    </a>
                <%
                    } else {
                %>
                    <a class="login" href="login.jsp">
                        Login
                    </a>
                <%
                    }
                %>
            </div>
        </div>
        <div class="container">
            <div class="resizable-container">
            </div>
        </div>
    </div>
</body>
</html>
