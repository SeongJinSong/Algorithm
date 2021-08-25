package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class LotteryTicket {
	static long c[][] = new long[10][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c[0][0] = 1;
		for(int i=1;i<=8;i++) {
			c[i][0] = c[i][i] = 1;
			for(int j=1;j<i;j++){
				c[i][j] = c[i-1][j-1] + c[i-1][j];
			}
		}
		int n, m, k;
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		long t1 = 0;
		for(int i=k; i<=m; i++) {
			t1 += c[m][i] * c[n-m][m-i];
		}
		long t2 = c[n][m];
		double ans = (double)t1 / (double)t2;
		System.out.println(ans);
	}
}
