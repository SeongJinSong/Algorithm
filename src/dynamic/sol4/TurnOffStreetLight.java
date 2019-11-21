package dynamic.sol4;

import java.util.Scanner;

public class TurnOffStreetLight {
	static int n, m;
	static long x[] = new long[1001];
	static long s[] = new long[1001];
	static long w[] = new long[1001];
	static long d[][][] = new long[1001][1001][2];
	static long go(int left, int right, int where) {
		if (left == 1 && right == n) {
	        return 0;
	    }
	    if (d[left][right][where] != 0) {
	        return d[left][right][where];
	    }
	    int now = where>0 ? right : left;
	    if (left-1 >= 1) {
	        long temp = go(left-1, right, 0) + (x[now]-x[left-1])*(s[n]-s[right]+s[left-1]);
	        if (d[left][right][where] == 0 || d[left][right][where] > temp) {
	        	d[left][right][where] = temp;
	        }
	    }
	    if (right+1 <= n) {
	        long temp = go(left, right+1, 1) + (x[right+1]-x[now])*(s[n]-s[right]+s[left-1]);
	        if (d[left][right][where] == 0 || d[left][right][where] > temp) {
	        	d[left][right][where] = temp;
	        }
	    }
		return d[left][right][where];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) {
			x[i] = sc.nextLong();
			w[i] = sc.nextLong();
			s[i] = s[i-1]+w[i];
		}
		System.out.println(go(m,m,0));
	}
}