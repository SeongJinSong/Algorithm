package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class MergeFile_1 {
	static int a[] = new int[501];
	static int s[];
	static int d[][];
	static int go(int i, int j) {
		if(i==j) {
			return 0;
		}
		if(d[i][j]!=0) {
			return d[i][j];
		}
		for(int k=i;k<=j-1;k++) {
			int temp = go(i,k)+go(k+1,j)+s[j]-s[i-1];
			if(d[i][j]==0 || d[i][j] > temp) {
				d[i][j] = temp;
			}
		}
		return d[i][j];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			d = new int[501][501];
			s = new int[501];
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				a[i] = sc.nextInt();
				s[i] = s[i-1]+a[i];
			}
			System.out.println(go(1,n));
		}
	}
}
