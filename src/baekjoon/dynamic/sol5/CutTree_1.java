package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class CutTree_1 {
	static final long inf = 1000000000000000L;
	static long a[] = new long[100000];
	static long b[] = new long[100000];
	static long d[] = new long[100000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i] = sc.nextLong();
		}
		for(int i=0;i<n;i++) {
			b[i] = sc.nextLong();
		}
		d[0] = 0;
		for (int i=1; i<n; i++) {
	        d[i] = inf;
	        for (int j=i-1; j>=0; j--) {
	            if (d[i] > d[j] + b[j]*a[i]) {
	                d[i] = d[j] + b[j]*a[i];
	            }
	        }
	    }
		System.out.println(d[n-1]);
	}
}
