package baekjoon.dynamic.sol2;

import java.util.Scanner;

public class Jump_2 {
	static int a[][] = new int[100][100];
	static long d[][] = new long[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		d[0][0]=1;
		for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
	            if (a[i][j] == 0) continue;
	            // (i,j) -> (i,j+a[i][j])
	            if (j+a[i][j] < n) {
	                d[i][j+a[i][j]] += d[i][j];
	            }
	            // (i,j) -> (i+a[i][j],j)
	            if (i+a[i][j] < n) {
	                d[i+a[i][j]][j] += d[i][j];
	            }
	        }
	    }
		System.out.println(d[n-1][n-1]);
	}
}
