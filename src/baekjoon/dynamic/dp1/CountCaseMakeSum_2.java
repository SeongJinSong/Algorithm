package baekjoon.dynamic.dp1;

import java.util.*;
public class CountCaseMakeSum_2 {
	public static long mod = 1000000000;
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int k = sc.nextInt();
    	long d[] = new long[n+1];
    	d[1] = 1;
    	for(int i=2;i<=k;i++) {
    		for(int j=0;j<=i;j++) {
    			d[i]+=d[j];
    		}
    		d[i] %= mod;
    	}
    	System.out.println(d[n]%= mod);
    }
}