package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class PrisonBreak_2 {
	static long a[] = new long[8001];
	static long s[] = new long[8001];
	static long d[][] = new long[801][8001];
	static long p[][] = new long[801][8001];
	static long cost(int i, int j) {
		if(i>j)return 0;
		else return (s[j]-s[i-1])*(j-i+1);
	}
	static void go(int i, int l, int r, int pl, int pr) {
		if(l>r)return;
		int m = (l+r)>>1;
		p[i][m] = -1;
		d[i][m] = -1;
		for(int k=pl; k<=pr; k++) {
			long temp = d[i-1][k] + cost(k+1,m);
			if(d[i][m] == -1 || d[i][m] > temp) {
				d[i][m] = temp;
				p[i][m] = k;
			}
		}
		go(i, l, m-1, pl, (int)p[i][m]);
	    go(i, m+1, r, (int)p[i][m], pr);
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
	    for (int i=0; i<=m; i++) {
	        d[1][i] = cost(1, i);
	        p[1][i] = 0;
	    }
	    for (int i=2; i<=n; i++) {
	        go(i, 0, m, 0, m);
	    }
	    System.out.println(d[n][m]);
	}
}