/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator ccOne = new OffByOne();
        CharacterComparator ccFive = new OffByN(5);
        int wordCount = 0;

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, ccFive)) {
                wordCount += 1;
                System.out.println(word);
            }
        }
        System.out.println(wordCount);
    }
}
