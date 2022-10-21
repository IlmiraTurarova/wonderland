package app.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "LogicServlet", value = "/LogicServlet")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showView(request, response, "views/levels.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем текущую сессию
        HttpSession currentSession = request.getSession();

        //количество проигрышей и выигрышей
        setCountLose(currentSession);
        setCountWin(currentSession);

        //если передали методом POST имя -> name будет не пустое, иначе берем имя из сессии
        setGamer(currentSession, request.getParameter("name"));

        //выставляем уровень вопросов в квесте
        Integer nextLevel = null;
        Integer levelQ = (Integer) currentSession.getAttribute("levelQuestion");
        if (request.getParameter("nextLevel")!=null) {
            nextLevel = Integer.parseInt(request.getParameter("nextLevel"));
        }

        Integer levelQuestion = setLevelQuestion(levelQ, nextLevel);
        currentSession.setAttribute("levelQuestion", levelQuestion);


        //проверка на неправильный ответ
        String answerString = request.getParameter("answer");
        if (answerString!=null) {
            Integer answer = Integer.parseInt(answerString);

            //проигрыш
            if (answer.equals(1)) {
                //количество проигрышей
                Integer countLose = (Integer) currentSession.getAttribute("countLose");
                countLose = increment(countLose);
                currentSession.setAttribute("countLose", countLose);

                //перенаправляем на страницу result
                showView(request, response, "views/results.jsp");
            }
            //выигрыш
            else if (answer.equals(0) && levelQuestion.equals(currentSession.getAttribute("countQuestions"))) {
                //количество выигрышей
                Integer countWin = (Integer) currentSession.getAttribute("countWin");
                countWin = increment(countWin);
                currentSession.setAttribute("countWin", countWin);

                currentSession.setAttribute("levelQuestion", levelQuestion+1);
                //перенаправляем на страницу result
                showView(request, response, "views/results.jsp");
            }
        }

        showView(request, response, "views/levels.jsp");
    }


    //количество проигрышей
    private static void setCountLose(HttpSession currentSession) {
        if (currentSession.getAttribute("countLose")==null) {
            currentSession.setAttribute("countLose", 0);
        }
    }

    //количество выигрышей
    private static void setCountWin(HttpSession currentSession) {
        if (currentSession.getAttribute("countWin")==null) {
            currentSession.setAttribute("countWin", 0);
        }
    }

    //имя игрока
    private static void setGamer(HttpSession currentSession, String name) {
        //если передали методом POST имя -> name будет не пустое, иначе берем имя из сессии
        if (name==null) {
            name = (String) currentSession.getAttribute("gamer");
        } else {
            currentSession.setAttribute("gamer", name);
        }
    }

    //определение уровня вопроса
    public static Integer setLevelQuestion (Integer levelQuestion, Integer nextLevel) {
        if (levelQuestion!=null) {
            if (levelQuestion < 0) throw new IllegalArgumentException("levelQuestion cannot be negative");
            if (nextLevel < 0) throw new IllegalArgumentException("nextLevel cannot be negative");
        }
        return levelQuestion==null ? 0 : nextLevel;
    }

    //инкремент
    public static Integer increment (Integer number) {
        if (number==null) throw new IllegalArgumentException("Argument cannot be negative");
        return ++number;
    }

    //перенаправляем на jsp
    private static void showView(HttpServletRequest request, HttpServletResponse response, String path) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
