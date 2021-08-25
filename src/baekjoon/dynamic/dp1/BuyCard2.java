package baekjoon.dynamic.dp1;

import java.util.*;
public class BuyCard2 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int p[] = new int[n+1];
    	int d[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		p[i] = sc.nextInt();
    	}
    	d[0]=0;
    	for(int i=1;i<=n;i++) {
    		d[i] = d[i-1]+p[1];
    		for(int j=2;j<=n;j++) {
    			if(i>=j && d[i] > d[i-j]+p[j])
    				d[i] = d[i-j]+p[j];
    		}
    	}
    	System.out.println(d[n]);
    }
}