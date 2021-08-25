package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class FlipCoin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		for(int i=0;i<m;i++) {
			a[i]=sc.nextInt();
		}
		double q = 1.0;
		for(int i=0;i<m;i++) {
			double p = (double)a[i]/(double)n;
			q = p*(1-q)+q*(1-p);
		}
		q*=n;
		System.out.println(q);
	}
}
