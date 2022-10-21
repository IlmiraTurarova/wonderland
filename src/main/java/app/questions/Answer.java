package app.questions;

public class Answer {
    private static Answer instance = new Answer();

    private String[][] arrayAnswers;

    public static Answer getInstance() {
        return instance;
    }

    private Answer() {
        arrayAnswers = new String[4][2];
        arrayAnswers[0][0] = "Принять вызов";
        arrayAnswers[0][1] = "Отклонить вызов";
        arrayAnswers[1][0] = "Согласиться";
        arrayAnswers[1][1] = "Отказаться";
        arrayAnswers[2][0] = "Освободить Шляпника";
        arrayAnswers[2][1] = "Забить на Шляпника";
        arrayAnswers[3][0] = "Выпить эликсир";
        arrayAnswers[3][1] = "Не пить эликсир";
    }

    public String[][] list() {
        return arrayAnswers;
    }
}
