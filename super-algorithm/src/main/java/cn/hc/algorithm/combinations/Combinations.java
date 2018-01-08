package cn.hc.algorithm.combinations;

import java.util.Arrays;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.combinations(Arrays.asList(1,2,3,4),2);
    }
    public void combinations(List<Integer> data,int n){
        if(data.isEmpty()){
            return;
        }
        if(n == 0){
            //output all selected elements
            return;
        }

        // select element 0
        combinations(data.subList(1,data.size()),n-1);
        // un-select element 0
        combinations(data.subList(1,data.size()),n);
    }
}
