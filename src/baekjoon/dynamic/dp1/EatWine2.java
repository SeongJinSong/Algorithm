package baekjoon.dynamic.dp1;

import java.util.*;
public class EatWine2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int d[][] = new int[n+1][3];
    	int a[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    	}
    	d[1][1] = a[1];
    	if(n>=2) {
    		d[2][1] = a[2];
    		d[2][2] = a[1]+a[2];
    	}
    	for(int i=3;i<=n;i++) {
    		d[i][0] = Math.max(Math.max(d[i-1][0], d[i-1][1]), d[i-1][2]);
    		d[i][1] = Math.max(Math.max(d[i-2][0], d[i-2][1]), d[i-2][2]) + a[i];
    		d[i][2] = Math.max(Math.max(d[i-3][0], d[i-3][1]),  d[i-3][2]) + a[i-1] + a[i];
    	}
    	int ans = d[1][1];
    	for(int i=2;i<=n;i++) {
    		for(int j=0;j<3;j++) {
    			ans = Math.max(ans, d[i][j]);
    		}
    	}
    	System.out.println(ans);
    	sc.close();
	}
}