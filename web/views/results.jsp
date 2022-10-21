<%@ page import="app.questions.Verdict" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Конец квеста</title>
    <link rel="stylesheet" href="styles/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Конец квеста</h1>
</div>

<div class="w3-container w3-left w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <%
                HttpSession currentSession = request.getSession();
                //вердикты
                Verdict verdict = Verdict.getInstance();
                String[] verdicts = verdict.list();

                int levelQuestion = (int) currentSession.getAttribute("levelQuestion");
            %>
            <h2>${gamer}</h2>
        </div>

        <%
            out.println("<ul class=\"w3-ul\">");
            out.println("<li class=\"w3-hover-sand\">" + verdicts[levelQuestion-1] + "</li>");
            out.println("</ul>");
        %>
        <form method="post" action="/restart" class="w3-selection w3-light-grey w3-padding">
            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Сыграть снова</button>
        </form>
    </div>
</div>

<div class="w3-container w3-left w3-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h3>Статистика</h3>
            <h6>Имя в игре: <i>${gamer}</i></h6>
            <%
                out.println("<h6>IP адрес: <i>" + request.getRemoteAddr() +  "</i></h6>");
            %>
            <h6>Количество выигрышей: <i>${countWin}</i></h6>
            <h6>Количество проигрышей: <i>${countLose}</i></h6>
        </div>

    </div>
</div>

</body>
</html>

