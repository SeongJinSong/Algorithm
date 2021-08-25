package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class RewardForPerfectAttendance_2 {
	static int mod = 1000000;
	static int d[][][][]= new int[1001][3][2][3];
	// �⼮: 0, �Ἦ: 1, ����: 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d[1][0][0][0] = 1;
	    d[1][1][0][1] = 1;
	    d[1][0][1][2] = 1;
	    for (int i=2; i<=n; i++) {
	        d[i][0][0][0] = d[i-1][0][0][0] + d[i-1][1][0][1] + d[i-1][2][0][1];
	        d[i][0][1][0] = d[i-1][0][1][0] + d[i-1][1][1][1] + d[i-1][2][1][1] + d[i-1][0][1][2];
	        d[i][1][0][1] = d[i-1][0][0][0];
	        d[i][2][0][1] = d[i-1][1][0][1];
	        d[i][1][1][1] = d[i-1][0][1][0] + d[i-1][0][1][2];
	        d[i][2][1][1] = d[i-1][1][1][1];
	        d[i][0][1][2] = d[i-1][0][0][0] + d[i-1][1][0][1] + d[i-1][2][0][1];
	        for (int j=0; j<3; j++) {
	            for (int k=0; k<2; k++) {
	                for (int l=0; l<3; l++) {
	                    d[i][j][k][l] %= mod;
	                }
	            }
	        }
	    }
	    int ans = 0;
	    for (int i=0; i<3; i++) {
	        for (int j=0; j<2; j++) {
	            for (int k=0; k<3; k++) {
	                ans += d[n][i][j][k];
	                ans %= mod;
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
