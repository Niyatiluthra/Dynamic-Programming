import java.util.*;

public class EditDistance{

    public static int ED(char X[],char Y[],int m,int n)
    {
        int dp[][] = new int[m+1][n+1];
        for ( int i = 0 ; i <= m ; i++ )
        {
            for( int j = 0 ; j <= n ; j++)
            {
                if ( i == 0 )
                    dp[i][j] =  j ;
                
                else if ( j == 0 )
                    dp[i][j] = i ; 

                else if ( X[i-1] == Y[j-1] )
                    dp[i][j] = dp[i-1][j-1];
                    
                else 
                    dp[i][j] = ( dp[i-1][j] > dp[i][j-1] ? ( dp[i-1][j-1] < dp[i][j-1] ? dp[i-1][j-1] : dp[i][j-1] ) : ( dp[i-1][j-1] < dp[i-1][j] ? dp[i-1][j-1] : dp[i-1][j] ) ) + 1 ;
                    
            }
        }

        // printing the memoiation matrix
        // for(int i = 0;i<=m;i++)
        // {
        //     for(int j=0;j<=n;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }

        return dp[m][n];
    }
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner (System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        char[] X=s1.toCharArray(); 
        char[] Y=s2.toCharArray(); 
        int m = X.length; 
        int n = Y.length; 
        
        System.out.println("Minimum operations to be performed are" + " " + 
                                        ED( X, Y, m, n ) ); 
    }   
}