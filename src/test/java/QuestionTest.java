import app.questions.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuestionTest {
    @Test
    public void getQuestion () {
        Question question = Question.getInstance();
        assertNotNull(question);
    }
}
