package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class RewardForPerfectAttendance_5 {
	static int mod = 1000000;
	static int[][] d = new int[1001][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[0][0]=1;
		for (int i=1; i<=n; i++) {
	        d[i][0] = d[i-1][0] + d[i-1][1] + d[i-1][2];
	        d[i][1] = d[i-1][0];
	        d[i][2] = d[i-1][1];
	        for (int j=0; j<3; j++) {
	            d[i][j] %= mod;
	        }
	    }
	    int ans = 0;
	    for (int i=0; i<3; i++) {
	        ans += d[n][i];
	        ans %= mod;
	    }
	    for (int i=1; i<=n; i++) {
	        for (int j=0; j<3; j++) {
	            for (int k=0; k<3; k++) {
	                long temp = (long)d[i-1][j] * d[n-i][k];
	                ans += temp % mod;
	                ans %= mod;
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
