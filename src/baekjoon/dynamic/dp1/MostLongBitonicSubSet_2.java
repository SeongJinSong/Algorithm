package baekjoon.dynamic.dp1;

import java.util.*;
public class MostLongBitonicSubSet_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int d1[] = new int[n+1];
		int d2[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
			d1[i] = 1; d2[i] = 1;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(a[i]>a[i-j]) {
					d1[i] = Math.max(d1[i], d1[i-j]+1);
				}
			}
		}
		for(int i=n;i>0;i--) {
			for(int j=1;i+j<=n;j++) {
				if(a[i]>a[i+j]) {
					d2[i] = Math.max(d2[i], d2[i+j]+1);
				}
			}
		}
		int ans = 0;
		for(int i=1;i<=n;i++) {
			ans = Math.max(ans, d1[i]+d2[i]-1);
		}
		System.out.println(ans);
	}
}
