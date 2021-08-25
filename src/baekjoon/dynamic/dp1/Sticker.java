package baekjoon.dynamic.dp1;

import java.util.*;
public class Sticker {
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	while(t-->0) {
    		int n = sc.nextInt();
    		int a[][] = new int[n][2];
    		int d[][] = new int[n][2];
    		for(int j=0;j<2;j++) {
    			for(int i=0;i<n;i++) {
        			a[i][j] = sc.nextInt();
        		}
    		}
    		d[0][0] = a[0][0]; 				d[0][1] = a[0][1];
    		d[1][0] = a[0][1] + a[1][0];	d[1][1] = a[0][0]+a[1][1];
    		for(int i=2;i<n;i++) {
    			d[i][0] = Math.max(d[i-1][1], d[i-2][1]) + a[i][0];
    			d[i][1] = Math.max(d[i-1][0], d[i-2][0]) + a[i][1];
    		}
    		System.out.println(Math.max(d[n-1][0], d[n-1][1]));
    	}
    }
}