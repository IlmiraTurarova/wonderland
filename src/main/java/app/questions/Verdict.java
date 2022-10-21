package app.questions;

public class Verdict {
    private static Verdict instance = new Verdict();

    private String[] arrayVerdict;

    public static Verdict getInstance() {
        return instance;
    }

    private Verdict() {
        arrayVerdict = new String[5];
        arrayVerdict[0] = "Ты отклонил(-а) вызов. Поражение";
        arrayVerdict[1] = "Ты не пошел(-ла) на Безумное чаепитие. Поражение";
        arrayVerdict[2] = "Ты не помог(-ла) другу. Поражение";
        arrayVerdict[3] = "Алиса не попала домой. Поражение";
        arrayVerdict[4] = "Дома Алиса отказывается стать женой Хэмиша. Алиса продолжает дело своего отца — торговлю и " +
                "намерена открыть новые горизонты. Она отплывает на корабле в дальние страны. Победа";
    }

    public String[] list() {
        return arrayVerdict;
    }
}
