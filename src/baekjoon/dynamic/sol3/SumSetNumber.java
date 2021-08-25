package baekjoon.dynamic.sol3;

import java.util.Scanner;

public class SumSetNumber {
	static long d[][] = new long[1<<15][100];
	static long gcd(long x, long y) {
		if(y==0) return x;
		else return gcd(y, x%y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] num = new String[n];
		int[] a = new int[n];
		int[] len = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = sc.next();
			len[i] = num[i].length();
		}
		int k;
		k = sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<len[i];j++) {
				a[i] = a[i]*10+(num[i].charAt(j)-'0');
				a[i]%=k;
			}
		}
		int[] ten = new int[51];
		ten[0] = 1;
		for(int i=1;i<=50;i++) {
			ten[i]=ten[i-1]*10;
			ten[i]%=k;
		}
		d[0][0]=1;
		for(int i=0;i<(1<<n);i++) {
			for(int j=0;j<k;j++) {
				for(int l=0;l<n;l++) {
					if((i&(1<<l))==0) {
						int next = j*ten[len[l]];
						next %=k;
						next += a[l];
						next %= k;
						d[i|(1<<l)][next] += d[i][j];
					}
				}
			}
		}
		long t1 = d[(1<<n)-1][0];
		long t2 = 1;
		for(int i=2;i<=n;i++) {
			t2*=(long)i;
		}
		long g = gcd(t1, t2);
		t1 /= g;
		t2 /= g;
		System.out.println(t1+"/"+t2);
	}
}