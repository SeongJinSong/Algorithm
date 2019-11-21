package dynamic.sol4;

import java.util.Scanner;

public class MakeTournament {
	static int d[][] = new int[256][256];
	static int a[] = new int[256];
	static int w[][] = new int[256][256];
	static int go(int i, int j) {
		if (d[i][j]>0) return d[i][j];
	    if (i == j) return 0;
	    d[i][j] = 200000000;
	    for (int k=i; k<j; k++) {
	        int temp = go(i,k) + go(k+1,j);
	        temp += Math.abs(w[i][k]-w[k+1][j]);
	        if (d[i][j] > temp) {
	            d[i][j] = temp;
	        }
	    }
	    return d[i][j];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for (int i=0; i<n; i++) {
	        w[i][i] = a[i];
	        for (int j=i+1; j<n; j++) {
	            w[i][j] = Math.min(w[i][j-1],a[j]);
	        }
	    }
		System.out.println(go(0, n-1));
	}
}
