import java.util.Scanner;

public class Knapsack01SpaceOptimised{

    public static int knapsack(int n, int value[], int weight[], int capacity)
    {
        int dp[] = new int[capacity+1];

        java.util.Arrays.fill(dp, 0);
        
        for ( int i = 0 ; i < n ; i++ )
            for( int j = capacity ; j >= weight[i] ; j--)
                dp[j] = Math.max(dp[j], value[i]+ dp[j - weight[i]]);
        
		return dp[capacity];
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