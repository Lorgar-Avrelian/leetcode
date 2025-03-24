package lorgar.avrelian;

import java.util.ArrayDeque;

public class Task0003 {

    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (queue.contains(ch)) {
                while (!queue.isEmpty() && queue.peek() != ch) {
                    queue.remove();
                }
                queue.remove();
            }
            queue.add(ch);
            result = Math.max(result, queue.size());

        }
        return result;
    }
}