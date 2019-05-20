package cn.math;

/**
 * Created by super on 2019/5/21
 * https://leetcode.com/problems/excel-sheet-column-title/submissions/
 */
public class ExcelSheet {

    public String convertToTitle(int n) {
        String s = "";
        while (n > 0) {
            n--;
            s = (char) ('A' + n % 26) + s;
            n /= 26;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheet().convertToTitle(28));
        System.out.println(new ExcelSheet().convertToTitle(1));
        System.out.println(new ExcelSheet().convertToTitle(26));
        System.out.println(new ExcelSheet().convertToTitle(701));
    }
}
