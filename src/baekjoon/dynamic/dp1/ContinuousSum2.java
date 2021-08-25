package baekjoon.dynamic.dp1;

import java.util.*;
public class ContinuousSum2 {
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		int d1[] = new int[n+1];
		int d2[] = new int[n+1];
		for(int i=1;i<=n;i++) {
			a[i] = sc.nextInt();
			d1[i] = d2[i] = a[i];
		}
		for(int i=2;i<=n;i++) {
			d1[i] = Math.max(d1[i-1]+a[i], a[i]);
		}
		for(int i=n-1;i>=1;i--) {
			d2[i] = Math.max(d2[i+1]+a[i], a[i]);
		}
		int ans = d1[1];
		for(int i=2;i<=n-1;i++) {
			ans = Math.max(ans, d1[i-1]+d2[i+1]);
		}
		for(int i=1;i<=n;i++) {
			ans = Math.max(ans, d1[i]);
		}
		System.out.println(ans);
    }
}