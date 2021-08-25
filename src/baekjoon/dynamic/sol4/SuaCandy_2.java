package baekjoon.dynamic.sol4;

import java.util.Arrays;
import java.util.Scanner;

public class SuaCandy_2 {
	static int l[][][] = new int[301][301][2];
	static int r[][][] = new int[301][301][2];
	static int a[] = new int[301];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		boolean zero = false;
		for (int i=0; i<n; i++) {
	        if (a[i] == 0) {
	            zero = true;
	        }
	    }
	    if (!zero) {
	        a[n++] = 0;
	    }
	    Arrays.parallelSort(a, 0, n);
	    int s = 0;
	    for (int i=0; i<n; i++) {
	        if (a[i] == 0) {
	            s = i;
	            break;
	        }
	    }
	    int ans = 0;
	    for (int k=1; k<n; k++) {
	        for (int i=0; i<n; i++) {
	            for (int j=i; j<n; j++) {
	                l[i][j][k%2] = 100000000;
	                r[i][j][k%2] = 100000000;
	                if (i-1 >= 0) {
	                    l[i][j][k%2] = Math.min(l[i][j][k%2], l[i-1][j][(k+1)%2] + k*(a[i] - a[i-1]));
	                    r[i][j][k%2] = Math.min(r[i][j][k%2], l[i-1][j][(k+1)%2] + k*(a[j]-a[i-1]));
	                }
	                if (j+1 < n) {
	                    l[i][j][k%2] = Math.min(l[i][j][k%2], r[i][j+1][(k+1)%2] + k*(a[j+1]-a[i]));
	                    r[i][j][k%2] = Math.min(r[i][j][k%2], r[i][j+1][(k+1)%2] + k*(a[j+1]-a[j]));
	                }
	            }
	        }
	        ans = Math.max(ans, k*m - l[s][s][k%2]);
	    }
	    if (zero) {
	        ans += m;
	    }
	    System.out.println(ans);
	    sc.close();
	}
}
