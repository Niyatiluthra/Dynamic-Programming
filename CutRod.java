import java.util.*;

public class CutRod{

    public static int cutrod(int n, int price[])
    {
        int dp[] = new int[n+1];
        dp[0] = 0;

        for ( int i = 1 ; i <= n ; i++ )
        {
            int max = 0;
            for( int j = 0 ; j < i ; j++)
            {
               int p = price[j] + dp[i-j-1];
               if ( p > max )
                   max = p;
            }
            dp[i] = max;
        }

        // printing the memoiation matrix
        // for(int i = 0;i<=n;i++)
        // {
        //     System.out.print(dp[i]+" ");
        // }

        return dp[n];
    }
    public 
    static void main(String[] args) 
    { 
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();

        int price[] = new int [n];

        for(int i = 0 ; i < n ; i++)
            price[i] = sc.nextInt();
     
        System.out.println("Maximum profit in selling this rod possible is" + " " + 
                                        cutrod( n, price ) ); 
    }   
}