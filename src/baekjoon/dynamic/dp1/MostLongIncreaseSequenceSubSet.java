package baekjoon.dynamic.dp1;

import java.util.*;
public class MostLongIncreaseSequenceSubSet {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n+1];
    	int d[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    		d[i] = 1; //초기화를 안해주면 안됩니다.
    	}
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			if(a[i]>a[j]) {
    				d[i] = Math.max(d[i], d[j]+1);
    			}
    		}
    	}
    	int ans = d[1];
    	for(int i=2;i<=n;i++) {
    		ans = Math.max(ans, d[i]);
    	}
    	System.out.println(ans);
    }
}