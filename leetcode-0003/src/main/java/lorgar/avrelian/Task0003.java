package lorgar.avrelian;

public class Task0003 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String s) {
        if (!s.isEmpty()) {
            int total = 0;
            int count = 1;
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                StringBuilder sb = new StringBuilder(charArray[i] + "");
                if (i < charArray.length - 1) {
                    for (int j = i + 1; j < charArray.length; j++) {
                        if (j == charArray.length - 1) {
                            if (sb.indexOf(charArray[j] + "") == -1) count++;
                            if (count >= total) {
                                total = count;
                            }
                            count = 1;
                            break;
                        }
                        if (sb.indexOf(charArray[j] + "") == -1) {
                            sb.append(charArray[j]);
                            count++;
                        } else {
                            if (count >= total) {
                                total = count;
                            }
                            count = 1;
                            break;
                        }
                    }
                } else {
                    if (count >= total) {
                        total = count;
                    }
                    count = 1;
                }
            }
            return total;
        } else {
            return 0;
        }
    }
}