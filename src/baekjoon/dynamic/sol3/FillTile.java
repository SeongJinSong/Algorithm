package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class FillTile {
	static long D[][] = new long[31][8];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		D[0][7] = 1;
		for(int i=1;i<=n;i++) {
			D[i][0] = D[i-1][7];
	        D[i][1] = D[i-1][6];
	        D[i][2] = D[i-1][5];
	        D[i][4] = D[i-1][3];
	        D[i][3] = D[i-1][4] + D[i-1][7];
	        D[i][6] = D[i-1][1] + D[i-1][7];
	        D[i][5] = D[i-1][2];
	        D[i][7] = D[i-1][0] + D[i-1][3] + D[i-1][6];
		}
		System.out.println(D[n][7]);
	}
}
