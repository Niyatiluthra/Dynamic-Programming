import java.util.*;

public class CoinChange{

    public static int cc(int n, int coins[], int value)
    {
        int dp[][] = new int[n+1][value+1];
        for ( int i = 0 ; i <= n ; i++ )
        {
            for( int j = 0 ; j <= value ; j++)
            {
                if ( i == 0 || j == 0 )
                    dp[i][j] = 0 ;

                else if ( coins[i-1] > j )
                    dp[i][j] = dp[i-1][j];

                else if ( coins[i-1] <= j )
                    dp[i][j] = dp[i-1][j] < dp[i][coins[i]-j] + 1 ? dp[i-1][j] : (dp[i][coins[i]-j] + 1) ;
            }               
        }

        // printing the memoiation matrix
        // for(int i = 0;i<=m;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }

        return dp[n][value];
    }
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int coinss[] = new int [n];

        for(int i = 0 ; i < n ; i++)
            coinss[i] = sc.nextInt();

        int value = sc.nextInt();
                
        System.out.println("Coinss needed is" + " " + cc(n, coinss, value) ); 
    }   
}