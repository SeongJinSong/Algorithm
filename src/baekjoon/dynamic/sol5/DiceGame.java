package baekjoon.dynamic.sol5;

import java.util.Scanner;

public class DiceGame {
	static double d[] = new double[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			d[i]=1;
			for(int j=1;j<=6;j++) {
				if(i-j>=0) {
					d[i] += d[i-j]/6.0;
				}
			}
		}
		System.out.println(d[n]);
	}
}
