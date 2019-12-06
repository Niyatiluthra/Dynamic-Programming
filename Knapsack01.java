import java.util.*;

public class Knapsack01{

    public static int knapsack(int n, int value[], int weight[], int capacity)
    {
        int dp[][] = new int[n+1][capacity+1];
        for ( int i = 0 ; i <= n ; i++ )
        {
            for( int j = 0 ; j <= capacity ; j++)
            {
                if ( i == 0 || j == 0 )
                    dp[i][j] = 0 ;

                else if ( weight[i-1] > j )
                    dp[i][j] = dp[i-1][j];

                else 
                    dp[i][j] = dp[i-1][j] > (value[i-1]+dp[i-1][j-weight[i-1]]) ? dp[i-1][j] : (value[i-1]+dp[i-1][j-weight[i-1]]);

            }
        }

        // printing the memoiation matrix
        // for(int i = 0;i<=m;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }

        return dp[n][capacity];
    }
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();

        int weight[] = new int [n];

        for(int i = 0 ; i < n ; i++)
            weight[i] = sc.nextInt();
    
        int value[] = new int [n];

        for(int i = 0 ; i < n ; i++)
            value[i] = sc.nextInt();

        int capacity = sc.nextInt();
                
        System.out.println("Maximum profit in 1/0 knapsack possible is" + " " + 
                                        knapsack(n, value, weight, capacity) ); 
    }   
}