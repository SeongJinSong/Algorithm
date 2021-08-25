package baekjoon.dynamic.sol2;

import java.util.Scanner;

public class CorrectParenthesis {
	static final long mod = 100000;
	static long d[][] = new long[200][200];
	static String s;
	static char open[] = {'(', '{', '['};
	static char close[] = {')', '}', ']'};
	static long go(int i, int j) {
		if(i>j) {
			return 1;
		}
		if( d[i][j]!=-1) {
			return  d[i][j];
		}
		 d[i][j] = 0;
		for (int k=i+1; k<=j; k+=2) {
	        for (int l=0; l<3; l++) {
	            if (s.charAt(i) == open[l] || s.charAt(i) == '?') {
	                if (s.charAt(k) == close[l] || s.charAt(k) == '?') {
	                    long temp = go(i+1, k-1) * go(k+1, j);
	                    d[i][j] += temp;
	                    if(d[i][j] >= mod) {
	                    	d[i][j] = mod +  d[i][j] % mod;
	                    }
	                }
	            }
	        }
	    }
		return  d[i][j];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s =sc.next();
		for(int i=0;i<200;i++) {
			for(int j=0;j<200;j++) {
				d[i][j]=-1;
			}
		}
		long ans = go(0,n-1);
		if(ans >= mod) {
			System.out.println(String.format("%05d", ans%mod));
		}
		else {
			System.out.println(ans);
		}
	}
}
