/**
 * Chapter 1
 * Ex1.2: Check permutations
 * Given two strings, write a method to decide if one
 * is a permutation of the other.
 */
public class Main {

    public static void main(String[] args) {
        String[] firsts = {"stressed", "", "stressed", "stressed"};
        String[] seconds = {"desserts", "", "genesis", "textarea"};

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < firsts.length; i++) {
            Question.arePermutationsBefore(firsts[i], seconds[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Question (BEFORE) execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < firsts.length; i++) {
            Question.arePermutationsAfter(firsts[i], seconds[i]);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Question (BEFORE) execution time: " + (endTime - startTime));
    }
}