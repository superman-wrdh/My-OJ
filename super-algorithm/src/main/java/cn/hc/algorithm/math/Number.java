package cn.hc.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hc on 2017/7/2.
 */
public class Number {
    public static void main(String[] args) {
        System.out.println(decimalToN(255,16));
    }
    /**
     * 十进制转n进制
     * @return string n进制字符串
     */
    public static String decimalToN(int inputDecima,int ToBase){
        String result="";
        int n=inputDecima;
        int jz=ToBase;
        List<String> list = new ArrayList();
        while (n>=1) {
            int temp=n%jz;
            list.add(getBase(temp));
            n/=jz;
        }
        int len=list.size();
        for (int i = len-1; i>=0; i--) {
            result=result.concat(list.get(i));
        }
        return result;
    }

    public static String getBase(int n)
    {
        String s="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return s.substring(n, n+1);
    }

    public static boolean isPrime(int n)
    {
        int i=2;
        while (i<n) {
            if (n%i==0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
