package dynamic.sol5;

import java.util.Scanner;

public class Ecology {
	static double comb[][] = new double[21][21];
	static double dp[][] = new double[21][21];
	static int n,c,d,m;
	static double p(int add, int prev) {
		return comb[n-prev][add] * comb[prev][c-add] / comb[n][c];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		comb[0][0] = 1;
	    for (int i=1; i<=20; i++) {
	        comb[i][0] = comb[i][i] = 1;
	        for (int j=1; j<i; j++) {
	            comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
	        }
	    }
	    n = sc.nextInt();
	    c = sc.nextInt();
	    d = sc.nextInt();
	    m = sc.nextInt();
	    dp[0][0] = 1.0;
	    for (int i=1; i<=d; i++) {
	        for (int j=1; j<=n; j++) {
	            for (int k=0; k<=c; k++) {
	                if (j-k >= 0) {
	                    dp[i][j] += p(k, j-k) * dp[i-1][j-k];
	                }
	            }
	        }
	    }
	    System.out.println(dp[d][m]);
	}
}
