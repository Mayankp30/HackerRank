package dynamicprogramming;

/**
 * Created by Mayank on 9/29/16.
 */
public class Dynamic {
    // coin change
    int countCoins( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n is greater than 0, then no solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
        return countCoins( S, m - 1, n ) + countCoins( S, m, n-S[m-1] );
    }

    // Fibonacci using recursion and dynamic approach
    public int fibonacci(int n){
        int[] f=new int[n+1];
        f[0]=0; // memonize the values in order to avoid overhead of calculations
        f[1]=1;

        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }

        return f[n];
    }
    // fibonacci using string recursion no DP

    /**********************************************************************************
     *
     *Fibonacci(5) = Fibonacci(4) + Fibonacci(3)
     * Fibonacci(3)= Fibonacci(2) + Fibonacci(1)
     * Fibonacci(2)= 1 + 0 =
     * Fibonacci(3) = 1 + 1 = 2
     * Fibonacci(4) = 2 + 1 =
     * Fibonacci(5) = 3 + 2 = 5
     * 1 1 2 3 5
     **********************************************************************************/


    public int recurFibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        else{
            return recurFibonacci(n-1) + recurFibonacci(n-2);
        }
    }

    


}
