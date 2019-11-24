package dynamic.sol5;

import java.util.Scanner;

public class PrisonBreak_1 {
	static long inf = 1000000000000000L;
	static long a[] = new long[8001];
	static long s[] = new long[8001];
	static long d[][] = new long[801][8001];
	static long cost(int i, int j) {
		if(i>j)return 0;
		else return (s[j]-s[i-1])*(j-i+1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		m = sc.nextInt();
		n = sc.nextInt();
	    for (int i=1; i<=m; i++) {
	        a[i] = sc.nextLong();
	        s[i] = s[i-1] + a[i];
	    }
	    for (int i=1; i<=n; i++) {
	        for (int j=0; j<=m; j++) {
	            if (i == 1) {
	                d[i][j] = cost(1, j);
	            } else {
	                d[i][j] = inf;
	                for (int k=0; k<=j; k++) {
	                    long temp = d[i-1][k] + cost(k+1, j);
	                    if (d[i][j] > temp) {
	                        d[i][j] = temp;
	                    }
	                }
	            }
	        }
	    }
	    System.out.println(d[n][m]);
	}
}
