package baekjoon.dynamic.sol4;

import java.util.Scanner;

public class Soccer {
	static double d[][][] = new double[20][20][20];
	static boolean prime(int x) {
		if (x <= 1) return false;
	    if (x == 2) return true;
	    for (int i=2; i*i <= x; i++) {
	        if (x%i == 0) return false;
	    }
	    return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		a = sc.nextDouble();
		b = sc.nextDouble();
		a /= 100.0;
		b /= 100.0;
		d[0][0][0] = 1.0;
		for (int i=1; i<=90/5; i++) {
	        for (int j=0; j<=i; j++) {
	            for (int k=0; k<=i; k++) {
	                if (j >= 1 && k >= 1) {
	                    d[i][j][k] += d[i-1][j-1][k-1]*a*b;
	                }
	                if (j >= 1) {
	                    d[i][j][k] += d[i-1][j-1][k]*a*(1.0-b);
	                }
	                if (k >= 1) {
	                    d[i][j][k] += d[i-1][j][k-1]*(1.0-a)*b;
	                }
	                d[i][j][k] += d[i-1][j][k]*(1.0-a)*(1.0-b);
	            }
	        }
	    }
	    double ans = 0.0;
	    for (int i=0; i<=90/5; i++) {
	        for (int j=0; j<=90/5; j++) {
	            if (prime(i) || prime(j)) {
	                ans += d[90/5][i][j];
	            }
	        }
	    }
	    System.out.println(ans);
	}
}
