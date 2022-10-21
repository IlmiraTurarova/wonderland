import app.questions.Answer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnswerTest {
    @Test
    public void getAnswer () {
        Answer answer = Answer.getInstance();
        assertNotNull(answer);
    }
}
