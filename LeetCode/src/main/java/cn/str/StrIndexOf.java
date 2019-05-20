package cn.str;

public class StrIndexOf {
    public static void main(String[] args) {
        int i = new StrIndexOf().strStr("a", "a");
        System.out.println(i);
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int nLen = needle.length();
        for (int i = 0; i < haystack.length() - nLen +1; i++) {
            String possNeedle = haystack.substring(i, i + nLen);
            if (possNeedle.equals(needle)) return i;
        }
        return -1;
    }

}
