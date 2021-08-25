package baekjoon.dynamic.dp1;

import java.util.*;
public class CountCaseMakeSum_1 {
	public static long mod = 1000000000;
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	long d[][] = new long[k+1][n+1];
    	for(int i=0;i<=n;i++) {
    		d[1][i] = 1;
    	}
    	for(int i=2;i<=k;i++) {
    		for(int j=0;j<=n;j++) {
    			for(int l=0;l<=j;l++) {
    				d[i][j] += d[i-1][l];
    			}
    			d[i][j] %= mod;
    		}
    	}
    	System.out.println(d[k][n]%= mod);
    }
}