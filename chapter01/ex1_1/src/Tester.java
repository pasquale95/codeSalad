import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tester {

    @Test
    void isUniqueCharsBeforeQuestionA() {
        assertTrue(QuestionA.isUniqueCharsBefore(""));
        assertFalse(QuestionA.isUniqueCharsBefore("alpha"));
        assertTrue(QuestionA.isUniqueCharsBefore("beta"));
    }

    @Test
    void isUniqueCharsAfterQuestionA() {
        assertTrue(QuestionA.isUniqueCharsAfter(""));
        assertFalse(QuestionA.isUniqueCharsAfter("alpha"));
        assertTrue(QuestionA.isUniqueCharsAfter("beta"));
    }

    @Test
    void isUniqueCharsBeforeQuestionB() {
        assertTrue(QuestionB.isUniqueCharsBefore(""));
        assertFalse(QuestionB.isUniqueCharsBefore("alpha"));
        assertTrue(QuestionB.isUniqueCharsBefore("beta"));
    }

    @Test
    void isUniqueCharsAfterQuestionB() {
        assertTrue(QuestionB.isUniqueCharsAfter(""));
        assertFalse(QuestionB.isUniqueCharsAfter("alpha"));
        assertTrue(QuestionB.isUniqueCharsAfter("beta"));
    }
}