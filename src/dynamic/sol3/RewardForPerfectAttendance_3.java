package dynamic.sol3;

import java.util.Scanner;

public class RewardForPerfectAttendance_3 {
	static int mod = 1000000;
	static int d[][][][]= new int[1001][2][3][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0; i<3; i++) {
	        for (int j=0; j<3; j++) {
	            if (i%2 + j%2 == 2) continue;
	            d[2][i%2+j%2][i][j] = 1;
	        }
	    }
	    for (int i=3; i<=n; i++) {
	        for (int prev=0; prev<3; prev++) {
	            for (int now=0; now<3; now++) {
	                for (int late=0; late+now%2<=1; late++) {
	                    for (int prev2=0; prev2<3; prev2++) {
	                        if (prev+now+prev2 == 6) continue;
	                        d[i][late+now%2][prev][now] += d[i-1][late][prev2][prev];
	                        d[i][late+now%2][prev][now] %= mod;
	                    }
	                }
	            }
	        }
	    }
	    if (n == 1) {
	        System.out.println(3);
	    } else {
	        int ans = 0;
	        for (int i=0; i<=1; i++) {
	            for (int j=0; j<3; j++) {
	                for (int k=0; k<3; k++) {
	                    ans += d[n][i][j][k];
	                    ans %= mod;
	                }
	            }
	        }
	        System.out.println(ans);
	    }
	}
}
