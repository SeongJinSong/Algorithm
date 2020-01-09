package dynamic.dp1;

import java.util.*;
public class MostLongBitonicSubSet {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int a[] = new int[n+1];
    	int d1[] = new int[n+1];
    	int d2[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    		d1[i] = 1;
    		d2[i] = 1;
    	}
    	int ans = 0;
    	for(int k=1;k<=n;k++) {
    		for(int i=1;i<=n;i++) {
        		d1[i] = 1;
        		d2[i] = 1;
        	}
    		for(int i=1;i<=k;i++) {
        		for(int j=1;j<i;j++) {
        			if(a[i]>a[i-j]) {
        				d1[i] = Math.max(d1[i], d1[i-j]+1);
        			}
        		}
        	}
    		for(int i=k;i<=n;i++) {
        		for(int j=1;i-j>=k;j++) {
        			if(a[i]<a[i-j]) {
        				d2[i] = Math.max(d2[i], d2[i-j]+1);
        			}
        		}
        	}
    		int ans1 = 0;
    		for(int i=0;i<=k;i++) {
    			ans1 = Math.max(ans1, d1[i]);
    		}
    		int ans2 = 0;
    		for(int i=k;i<=n;i++) {
    			ans2 = Math.max(ans2, d2[i]);
    		}
    		ans = Math.max(ans, ans1+ans2-1);
    	}
    	System.out.println(ans);
    }
}