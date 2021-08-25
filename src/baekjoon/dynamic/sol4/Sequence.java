package baekjoon.dynamic.sol4;

import java.util.Scanner;

public class Sequence {
	static long d[][][] = new long[11][221][221];
	// len, sum, last
	static int n,m;
	static void go(int len, int sum, int last, long cnt) {
		if(len<=0) {
			return;
		}
		//System.out.println(len+" "+sum+" "+last);
		long acc = 0;
		for (int i=last; i<=m; i++) {
	        if (cnt < acc+d[len][sum][i]) {
	            System.out.print(i+" ");
	            go(len-1, sum-i, i, cnt-acc);
	            break;
	        }
	        acc += d[len][sum][i];
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s;
		n = sc.nextInt();
		m = sc.nextInt();
		s = sc.nextLong();
		for(int i=1;i<=m;i++) {
			d[1][i][i]=1L;
		}
		for (int i=2; i<=n; i++) {
	        for (int j=1; j<=m; j++) {
	            for (int k=1; k<=j; k++) {
	                for (int l=k; l<=j; l++) {
	                    if (j-k >= 1) {
	                        d[i][j][k] += d[i-1][j-k][l];
	                    }
	                }
	            }
	        }
	    }
	    go(n,m,1,s-1);
	}
}
