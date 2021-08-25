package baekjoon.dynamic.dp1;

import java.util.*;
public class ContinuousSum {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n+1];
    	int d[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    		d[i] = a[i];
    	}
    	int ans = d[1];
    	for(int i=1;i<=n;i++) {
    		d[i] = Math.max(d[i-1]+a[i], d[i]);
    		ans = Math.max(ans, d[i]);
    	}
    	System.out.println(ans);
    }
}