package baekjoon.dynamic.sol5;

import java.util.Arrays;
import java.util.Scanner;

public class CutString_1 {
	static final long inf = 1000000000000000000L;
	static long d[][] = new long[1003][1003];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] a = new int[n+2];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
		}
		a[n+1]=m;
		Arrays.parallelSort(a);
		n+=2;
		for (int i=0; i<n; i++) {
	        d[i][i] = 0;
	        for (int j=i+1; j<n; j++) {
	            d[i][j] = 0;
	        }
	    }
	    for (int l=2; l<=n; l++) {
	        for (int i=0; i+l<n; i++) {
	            int j = i+l;
	            d[i][j] = inf;
	            for (int k=i; k<=j; k++) {
	                if (d[i][j] > d[i][k] + d[k][j]) {
	                    d[i][j] = d[i][k] + d[k][j];
	                }
	            }
	            d[i][j] += a[j]-a[i];
	        }
	    }
	    System.out.println(d[0][n-1]);
	}
}
