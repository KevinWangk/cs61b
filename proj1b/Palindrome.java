/**
 * Palindrome
 *
 * @author Wangkun
 * @create 2021-01-30-9:55
 **/
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }
    public boolean isPalindrome(String word) {

        return false;
    }
}
