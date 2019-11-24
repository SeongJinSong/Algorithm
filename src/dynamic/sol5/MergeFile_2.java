package dynamic.sol5;

import java.util.Scanner;

public class MergeFile_2 {
	static final int inf = 1000000000;
	static int p[][] = new int[5001][5001];
	static int a[] = new int[5001];
	static int s[] = new int[5001];
	static int d[][] = new int[5001][5001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				a[i] = sc.nextInt();
				s[i] = s[i-1] + a[i];
			}
			for(int i=1;i<=n;i++) {
				p[i][i] = i;
			}
			for (int l=1; l<=n; l++) {
	            for (int i=1; i+l<=n; i++) {
	                int j = i+l;
	                d[i][j] = inf;
	                for (int k=p[i][j-1]; k<=p[i+1][j]; k++) {
	                    if (d[i][j] > d[i][k] + d[k+1][j]) {
	                        d[i][j] = d[i][k] + d[k+1][j];
	                        p[i][j] = k;
	                    }
	                }
	                d[i][j] += s[j] - s[i-1];
	            }
	        }
	        System.out.println(d[1][n]);
		}
	}
}
