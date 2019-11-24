package dynamic.sol5;

import java.util.Scanner;

public class ORScoreOfSequence {
	static long cost[][] = new long[5002][5002];
	static long d[][] = new long[5002][5002];
	static int p[][] = new int[5002][5002];
	static long a[] = new long[5002];
	static void go(int i, int l, int r, int pl, int pr) {
		if(l>r)return;
		int m = (l+r)>>1;
		p[i][m] = -1;
		p[i][m] = -1;
		int lim = Math.min(m, pr);
		for(int k=pl;k<=lim;k++) {
			long temp = d[i-1][k-1] + cost[k][m];
	        if (d[i][m] < temp) {
	            d[i][m] = temp;
	            p[i][m] = k;
	        }
		}
		go(i, l, m-1, pl, p[i][m]);
	    go(i, m+1, r, p[i][m], pr);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextLong();
		}
		for (int i=1; i<=n; i++) {
	        cost[i][i] = a[i];
	        for (int j=i+1; j<=n; j++) {
	            cost[i][j] = cost[i][j-1] | a[j];
	        }
	    }
	    for (int i=1; i<=n; i++) {
	        d[1][i] = cost[1][i];
	        p[1][i] = 1;
	    }
	    for (int i=2; i<=m; i++) {
	        go(i, i, n, i, n);
	    }
	    System.out.println(d[m][n]);
	}
}
