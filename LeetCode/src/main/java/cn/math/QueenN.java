package cn.math;


public class QueenN {
    static int TRUE = 1, FALSE = 0, EIGHT = 8;
    static int[] queen = new int[EIGHT]; // col location
    static int number = 0; // total  results

    QueenN() {
        number = 0;
    }

    public static void main(String[] args) {

    }

    public static void decide_position(int value) {
        int i = 0;
        while (i < EIGHT) {
            if (!check(i, value)) {
                queen[value] = i;
                if (value == 7) {
                    printTable();
                } else decide_position(value + 1);
            }

        }
    }

    public static boolean check(int row, int col) {
        boolean result = false;
        int i = 0;
        int offset_row = 0, offset_col = 0;
        while (!result && i < col) {
            offset_col = Math.abs(i - col);
            offset_row = Math.abs(queen[i] - row);
            if (queen[i] == row || offset_col == offset_row) {
                result = true;
            }
            i++;
        }
        return result;
    }

    public static void printTable() {
        int x, y;
        number++;
        System.out.println("the");
        for (x = 0; x < EIGHT; x++) {
            for (y = 0; y < EIGHT; y++) {
                if (x == queen[y]) {
                    System.out.println(" [1] ");
                } else {
                    System.out.println(" [0] ");
                }
            }

        }
    }
}
