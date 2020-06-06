package cn.hc.algorithm.string;

public class KMP {
    public static void main(String[] args) {
        String str = "AACABABABBAA";
        String substr = "ABABABB";
        int[] next = getNext(substr);
        System.out.println(kmp(str, substr, next));
    }

    public static int[] getNext(String substr) {
        int[] next = new int[substr.length()+1];
        int i = 1, j = 0;
        next[1] = 0;
        while (i < substr.length()) {
            if (j == 0 || substr.toCharArray()[i] == substr.toCharArray()[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else j = next[j];
        }
        return next;
    }

    public static int kmp(String str, String substr, int[] next) {
        int i = 1, j = 1;
        while (i <= str.length() && j < substr.length()) {
            if (j == 0 || str.toCharArray()[i] == substr.toCharArray()[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }
        if (j > substr.length()) {
            return i - substr.length();
        } else
            return 0;
    }
}
