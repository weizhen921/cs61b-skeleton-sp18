import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /** You must use this palindrome, and not instantiate
     new Palindromes, or the autograder might be upset. */
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    static OffByOne obo = new OffByOne();
    @Test
    public void isPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("zizz"));

        assertTrue(palindrome.isPalindrome("flake", obo));

    }
}
