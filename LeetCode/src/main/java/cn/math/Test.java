package cn.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by super on 2018/5/3
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> queen = new LinkedList<>();
        queen.add(1);
        queen.add(2);
        queen.add(3);
        while (queen.size() > 0) {
            System.out.println(queen.remove());
        }
    }
}
