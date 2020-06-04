package cn.hc.algorithm.math;

public class QueenN {
    int count = 0;

    public static void main(String[] args) {
        System.out.println(new QueenN().totalNQueens(8));
        System.out.println(new QueenN().totalNQueens(9));
    }

    int totalNQueens(int n) {
        backTracking(n, 0, new int[n]);
        return count;
    }

    void backTracking(int n, int row, int[] columns) {
        //是否在所有n行里摆好了皇后
        if (row == n) {
            count++; //找到了新的摆放方法
            return;
        }
        //尝试着将皇后放置在当前行中每一列
        for (int col = 0; col < n; col++) {
            columns[row] = col;
            // 检查是否合法 如果合法就继续道下一行
            if (check(row, col, columns)) {
                backTracking(n, row + 1, columns);
            }
            // 如果不合法就不把皇后放到这列中
            columns[row] = -1;
        }
    }

    public boolean check(int row, int col, int[] columns) {
        for (int r = 0; r < row; r++) {
            if (columns[r] == col || row - r == Math.abs(columns[r] - col)) {
                return false;
            }
        }
        return true;
    }
}
