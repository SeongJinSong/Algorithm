package dynamic.sol2;

import java.util.Scanner;

public class SameHeightTower {
	static final int inf = 10000000;
	static int a[] = new int[50];
	static int d[][] = new int[50][250001];
	static int n;
	static int go(int k, int diff) {
		if (diff > 250000) {
	        return -inf;
	    }
	    if (k == n) {
	        if (diff == 0) {
	            return 0;
	        } else {
	            return -inf;
	        }
	    }
	    
	    if (d[k][diff] != -1) {
	        return d[k][diff];
	    }
	    d[k][diff] = go(k+1, diff);
	    d[k][diff] = Math.max(d[k][diff], go(k+1, diff+a[k]));
	    if (a[k] > diff) {
	    	d[k][diff] = Math.max(d[k][diff], diff + go(k+1, a[k]-diff));
	    } else {
	    	d[k][diff] = Math.max(d[k][diff], a[k] + go(k+1, diff-a[k]));
	    }
	    return d[k][diff];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for(int i=0;i<50;i++) {
			for(int j=0;j<250001;j++) {
				d[i][j] = -1;
			}
		}
		int ans = go(0,0);
		if(ans==0) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
}
