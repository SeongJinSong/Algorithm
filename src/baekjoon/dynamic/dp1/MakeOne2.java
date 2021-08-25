package baekjoon.dynamic.dp1;

import java.util.*;

public class MakeOne2 {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] d = new int[n+1];
    	
    	d[0] = 0; d[1] = 0;
    	for(int i=2;i<=n;i++) {
    		if(d[i]==0 || (d[i]!=0 && d[i] > d[i-1]+1))
    		{
    			d[i] = d[i-1]+1;
    		}
    		if(d[i]==0 || (d[i]!=0 && i%2 == 0 && d[i] > d[i/2] + 1)) {
    			d[i] = d[i/2]+1;
    		}
    		if(d[i]==0 || (d[i]!=0 && i%3 == 0 && d[i] > d[i/3] + 1)) {
    			d[i] = d[i/3]+1;
    		}
    	}
    	System.out.println(d[n]);
    }
}