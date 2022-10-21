import app.servlets.LogicServlet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicServletTest {
    @Test
    public void setLevelQuestionNegativeException () {
        assertThrows(IllegalArgumentException.class, () -> LogicServlet.setLevelQuestion(-1, 0));
    }

    @Test
    public void setNextLevelQuestionNegativeException () {
        assertThrows(IllegalArgumentException.class, () -> LogicServlet.setLevelQuestion(0, -1));
    }

    @Test
    public void setLevelQuestionNegativeExceptionMessage () {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> LogicServlet.setLevelQuestion(-1, 0));
        assertEquals("levelQuestion cannot be negative", exception.getMessage());
    }

    @Test
    public void setNextLevelQuestionNegativeExceptionMessage () {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> LogicServlet.setLevelQuestion(0, -1));
        assertEquals("nextLevel cannot be negative", exception.getMessage());
    }

    @Test
    public void setNullLevelQuestion () {
        assertEquals(0, LogicServlet.setLevelQuestion(null, 10));
    }

    @Test
    public void setLevelQuestion () {
        assertEquals(3, LogicServlet.setLevelQuestion(1, 3));
    }

    @Test
    public void incrementNullException () {
        assertThrows(IllegalArgumentException.class, () -> LogicServlet.increment(null));
    }

    @Test
    public void incrementNullExceptionMessage () {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> LogicServlet.increment(null));
        assertEquals("Argument cannot be negative", exception.getMessage());
    }

    @Test
    public void increment () {
        assertEquals(16, LogicServlet.increment(15));
    }
}
