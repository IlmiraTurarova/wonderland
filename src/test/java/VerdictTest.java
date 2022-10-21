import app.questions.Verdict;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VerdictTest {
    @Test
    public void getVerdict () {
        Verdict verdict = Verdict.getInstance();
        assertNotNull(verdict);
    }
}
