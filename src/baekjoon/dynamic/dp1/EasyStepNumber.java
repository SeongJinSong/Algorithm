package baekjoon.dynamic.dp1;

import java.util.*;
public class EasyStepNumber {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	long d[][] = new long[n+1][10];
    	for(int i=1;i<=9;i++) {
    		d[1][i] = 1;
    	}
    	for(int i=2;i<=n;i++) {
    		d[i][0] = d[i-1][1];
    		d[i][0] %=1000000000;
    		d[i][9]	= d[i-1][8];
    		d[i][9] %=1000000000;
    		for(int j=1;j<=8;j++) {
    			d[i][j]	= d[i-1][j-1] + d[i-1][j+1];
    			d[i][j] %=1000000000;
    		}
    	}
    	long ans=0;
    	for(int i=0;i<=9;i++) {
    		ans += d[n][i];
    	}
    	System.out.println(ans%1000000000);
    }
}
