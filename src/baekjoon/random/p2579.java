package baekjoon.random;

import java.util.Scanner;

public class p2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[][] dp = new int[n+1][3];
		for(int i=1;i<=n;i++) {
			a[i]=sc.nextInt();
		}
		dp[1][1]=a[1];
		for(int i=2;i<=n;i++) {
			dp[i][2]=dp[i-1][1]+a[i];
			dp[i][1]=Math.max(dp[i-2][1], dp[i-2][2])+a[i];
		}
		System.out.println(Math.max(dp[n][1], dp[n][2]));
	}
}
