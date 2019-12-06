import java.util.*;

public class LongestIncreasingSubsequence{

    public static int lis(int X[],int n)
    {
        int dp[] = new int[n] ;

        for ( int i = 0 ; i < n ; i++ )
        {
            dp[i] = 1;
            
            for( int j = 0 ; j < i ; j++)
            {
                if ( X[j] < X[i] && dp[i] < dp[j] + 1 )
                    dp[i] = dp[j]+1 ;
            }
        }

        int max = dp[0];
        for( int i = 1 ; i < n ; i++ )
        {
            max = max > dp[i] ? max : dp[i];
        }
        // printing the memoiation matrix
        for(int i = 0;i<n;i++)
        {
           System.out.print(dp[i]+" ");
        }

        return max;
    }

    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0 ; i < n ; i++ )
        {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Length of LIS is" + " " + 
                                        lis( arr,n ) ); 
    }   
}