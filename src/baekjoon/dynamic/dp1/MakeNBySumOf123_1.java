package baekjoon.dynamic.dp1;

import java.util.*;
public class MakeNBySumOf123_1 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int d[] = new int[11];
    	d[0] = 1; d[1] = 1; d[2] = 2;
    	while(n-->0) {
    		int k = sc.nextInt();
        	if(k>=3) {
	        	for(int i=3; i<=k; i++) {
	        		d[i] = d[i-1] + d[i-2] + d[i-3];
	        	}
        	}
        	System.out.println(d[k]);
    	}
    }
}