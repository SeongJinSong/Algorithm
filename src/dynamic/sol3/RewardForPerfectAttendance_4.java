package dynamic.sol3;

import java.util.Scanner;

public class RewardForPerfectAttendance_4 {
	static int mod = 1000000;
	static int d[][][]= new int[1001][2][3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[0][0][0] = 1;
		for (int i=1; i<=n; i++) {
	        for (int j=0; j<2; j++) {
	            for (int k=0; k<3; k++) {
	                d[i][j][0] += d[i-1][j][k];
	                d[i][j][0] %= mod;
	                if (j == 0) {
	                    d[i][1][0] += d[i-1][j][k];
	                    d[i][1][0] %= mod;
	                }
	                if (k < 2) {
	                    d[i][j][k+1] += d[i-1][j][k];
	                    d[i][j][k+1] %= mod;
	                }
	            }
	        }
	    }
	    int ans = 0;
	    for (int i=0; i<2; i++) {
	        for (int j=0; j<3; j++) {
	            ans += d[n][i][j];
	            ans %= mod;
	        }
	    }
	    System.out.println(ans);
	}
}
