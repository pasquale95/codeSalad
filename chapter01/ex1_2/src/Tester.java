import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tester {

    @Test
    void arePalindromeBeforeQuestion() {
        // yes permutation
        assertTrue(Question.arePermutationsBefore("stressed", "desserts"));
        // yes permutation,
        assertTrue(Question.arePermutationsBefore("", ""));
        // no permutation, different length
        assertFalse(Question.arePermutationsBefore("stressed", "genesis"));
        // no permutation, same length
        assertFalse(Question.arePermutationsBefore("stressed", "textarea"));
    }

    @Test
    void arePalindromeAfterQuestion() {
        // yes permutation
        assertTrue(Question.arePermutationsAfter("stressed", "desserts"));
        // yes permutation,
        assertTrue(Question.arePermutationsAfter("", ""));
        // no permutation, different length
        assertFalse(Question.arePermutationsAfter("stressed", "genesis"));
        // no permutation, same length
        assertFalse(Question.arePermutationsAfter("stressed", "textarea"));
    }
}