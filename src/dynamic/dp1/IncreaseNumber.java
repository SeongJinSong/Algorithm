package dynamic.dp1;

import java.util.*;
public class IncreaseNumber {
    public static long mod = 10007;
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int d[][] = new int[n+1][10];
    	for(int i=0;i<=9;i++) {
    		d[1][i]=1;
    	}
    	long ans=0;
    	for(int i=1;i<=n;i++) {
    		for(int k=0;k<=9;k++) {
    			for(int j=0;j<=k;j++) {
    				d[i][k] += d[i-1][j];
    			}
    			d[i][k]%=mod;
    		}
    	}
    	for(int i=0;i<=9;i++) {
    		ans+=d[n][i];
    	}
    	System.out.println(ans%mod);
    }
}