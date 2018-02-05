package cn.math;


public class PrimeCount {
    public static void main(String[] args) {
        for (int i = 0; i < 100000 ; i++) {
            try {
                countPrimes(i);
            }catch (Exception e){
                System.out.println("exeception " +i);
            }
        }
    }

    /**
     * 欧拉筛选法
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if(n < 1)
            return 0;
        boolean[] isPrime = new boolean[n + 1];
        int[] prime = new int[n / 10];
        int totalPrimes = 1;
        for (int i = 3; i <= n; i += 2)
            isPrime[i] = true;
        isPrime[2] = true;
        prime[0] = 2;
        for (int i = 3; i <= n; i += 2) {
            if (isPrime[i])
                prime[totalPrimes++] = i;
            for (int j = 1; i * prime[j] <= n && j < totalPrimes; j++) {
                isPrime[i * prime[j]] = false;
                if (i % prime[j] == 0)
                    break;
            }
        }
        return totalPrimes;
    }
}



