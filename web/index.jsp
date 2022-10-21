<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <meta charset="UTF-8">
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
  <title>Алиса в стране чудес</title>
  <link rel="stylesheet" href="styles/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
  <h1>Алиса в стране чудес</h1>
</div>

<div  class="w3-container w3-border w3-large">
  <div class="w3-left-align">
    <p>Жизнь 19-летней Алисы Кингсли принимает неожиданный оборот. На викторианской вечеринке, устроенной в её честь,
      Алисе делает предложение Хэмиш, богатый, но глупый сын лорда и леди Эскот. Приглашённая на праздник, на деле
      оказавшийся замаскированной помолвкой, в момент предложения ей руки и сердца Алиса замечает Белого Кролика.
      Он одет в камзол и постоянно смотрит на карманные часы. Кролик увлекает девушку в нору, на другом конце которой ждёт
      странный мир, снившийся ей уже давно. </p>

    <p>Помоги Алисе. Как к тебе обращаться? </p>

    <form method="post" action="/level" class="w3-selection w3-light-grey w3-padding">
      <label>
        <%
          HttpSession currentSession = request.getSession();
          String name = (String) currentSession.getAttribute("gamer");
          if (name == null) {
            name = "";
          }

          out.println("<input type=\"text\" name=\"name\" value=\"" + name + "\" class=\"w3-input " +
                  "w3-animate-input w3-border w3-round-large\" style=\"width: 20%\"><br />");
        %>

      </label>
      <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Представиться</button>
    </form>
  </div>
</div>
</body>
</html>
