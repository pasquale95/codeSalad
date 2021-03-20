/**
 * Chapter 1
 * Ex1.1: Is unique
 * Question A: Implement an algorithm to determine if a string has all unique characters.
 * Question B: What if you cannot use additional data structures?
 */
public class Main {

    public static void main(String[] args) {
        String[] strings = {"alpha", "beta", "gamma"};

        long startTime = System.currentTimeMillis();
        for (String string : strings) {
            QuestionA.isUniqueCharsBefore(string);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Question A (BEFORE) execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (String string : strings) {
            QuestionA.isUniqueCharsAfter(string);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Question A (AFTER) after execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (String string : strings) {
            QuestionB.isUniqueCharsAfter(string);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Question B (BEFORE) after execution time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (String string : strings) {
            QuestionB.isUniqueCharsAfter(string);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Question B (AFTER) after execution time: " + (endTime - startTime));
    }
}