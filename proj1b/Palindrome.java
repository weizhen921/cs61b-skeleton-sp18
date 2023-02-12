public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /** loop version */
//    public boolean isPalindrome(String word) {
//        Deque<Character> d = wordToDeque(word);
//        if (d.size() == 0 || d.size() == 1) {
//            return true;
//        }
//        for (int i = 0; i < Math.floorDiv(d.size(), 2); i += 1) {
//            int j = word.length() - i - 1;
//            if (d.get(i) != d.get(j)) {
//                return false;
//            }
//        }
//        return true;
//    }

    /** recursion version */
    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindrome(dequetoString(d));
        } else {
            return false;
        }
    }

    private String dequetoString(Deque d) {
        String s = new String();
        s = "";
        while (d.size() > 0) {
            s += d.removeFirst();
        }
        return s;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (cc.equalChars(d.removeFirst(), d.removeLast())) {
            return isPalindrome(dequetoString(d), cc);
        } else {
            return false;
        }
    }

//    public boolean isPalindrome(String word, CharacterComparator cc) {
//        Deque<Character> d = wordToDeque(word);
//        if (d.size() == 0 || d.size() == 1) {
//            return true;
//        }
//        for (int i = 0; i < Math.floorDiv(d.size(), 2); i += 1) {
//            int j = word.length() - i - 1;
//            if (!cc.equalChars(d.get(i), d.get(j))) {
//                return false;
//            }
//        }
//        return true;
//    }
}
