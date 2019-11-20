package dynamic.sol2;

import java.util.Scanner;

public class Guitarist {
	static int n, s, m;
	static int a[] = new int[101];
	static boolean d[][] = new boolean[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		d[0][s]=true;
		for (int i=0; i<=n-1; i++) {
	        for (int j=0; j<=m; j++) {
	            if (d[i][j] == false) {
	                continue;
	            }
	            if (j-a[i+1] >= 0) {
	                d[i+1][j-a[i+1]] = true;
	            }
	            if (j+a[i+1] <= m) {
	                d[i+1][j+a[i+1]] = true;
	            }
	        }
	    }
		int ans = -1;
	    for (int i=0; i<=m; i++) {
	        if (d[n][i]) ans = i;
	    }
	    System.out.println(ans);
	}
}
