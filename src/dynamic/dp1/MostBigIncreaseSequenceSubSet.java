package dynamic.dp1;

import java.util.*;
public class MostBigIncreaseSequenceSubSet {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n+1];
    	int d[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    		d[i] = a[i];
    	}
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			if(d[i]<d[j]+a[i] && a[i]>a[j]) {
    				d[i] = d[j]+a[i];
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