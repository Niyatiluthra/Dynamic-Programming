import java.util.Scanner;
public class CoinTowerGameWinner {

	public static String winner(int n,int x,int y){
        String A = "Player1";
        String B = "Player2";
        
        int dp [] = new int[n+1];
        
        for(int i = 1; i <= n ; i++)
        {
            if(i==1||i==x||i==y)
                dp[i] = 1;
            else 
            {
                if(i>=x&&dp[i-x]%2==0)
                    dp[i] = dp[i-x]+1;
                else if(i>=y&&dp[i-y]%2==0)
                    dp[i] = dp[i-y]+1;
                else 
                    dp[i] = dp[i-1]+1;
            }
        }
        
        if(dp[n]%2==0)
            return B;
        else 
            return A;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //No of coins
		int n = sc.nextInt();
        // first skip of jumps allowed
        int diff1 = sc.nextInt();
        // second skip of jumps allowed
		int diff2 = sc.nextInt();
		System.out.println("Winner is "+ winner(n,diff1,diff2));
	}
	
}