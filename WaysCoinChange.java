import java.util.Scanner;
public class WaysCoinChange {
	public static int countWaysToMakeChange(int denominations[], int value){
        int dp[] = new int[value+1];
        
        java.util.Arrays.fill(dp,0);
        
        dp[0] = 1;
        
        for(int i = 0 ; i < denominations.length ; i++)
        {
            for(int j = denominations[i] ; j <= value ; j++)
            {
                dp[j] = dp[j] + dp[j-denominations[i]];
            }
        }
        return dp[value];
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int denominations[] = new int[n];
		for(int i = 0; i < n; i++){
			denominations[i] = sc.nextInt();
		}
		
		int value = sc.nextInt();
		
		System.out.println("Maximum number of ways can be " + countWaysToMakeChange(denominations, value));
		
	}
}

