package cn.math;

public class PowerOfThree {
    /**
     * leetcode -> math -> Power of Three
     * Given an integer, write a function to determine if it is a power of three.

       Follow up:
       Could you do it without using any loop / recursion?
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(81));
        System.out.println(isPowerOfThree(80));
    }
    public static boolean isPowerOfThree(int n) {
        return n > 0 ? getMaxPowerOfThree() % n ==0:false;
    }
    public static int getMaxPowerOfThree(){
        /**
         * get the max integer number which is power of three
         */
        double max = 0;
        for(int i = 1;i<100000;i++){
            double tmp = Math.pow(3,i);
            if((double)(Integer.MAX_VALUE)-tmp > 0){
                max = tmp;
            }else{
                break;
            }
        }
        return (int)max;
    }
}
