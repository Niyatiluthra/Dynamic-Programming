/* Question : A thief cannot loot two consecutive houses. Find the maximum amount of money he can loot. */

import java.util.Scanner;
public class LootHouses{
	public static int getMaxMoney(int arr[], int n){

        int dp [] = new int[n];
        
        for(int i = 0 ; i < n ; i++)
        {
            if(i==0)
                dp[i] = arr[i];
            else if ( i== 1)
                dp[i] = Math.max(arr[0],arr[i]);
            else 
            {
                dp[i] = Math.max(dp[i-2]+arr[i],dp[i-1]);
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println("Maximum money that can be looted is " + getMaxMoney(arr, n));
	}
}
