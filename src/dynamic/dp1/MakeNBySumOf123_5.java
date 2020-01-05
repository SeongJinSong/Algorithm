package dynamic.dp1;

import java.util.*;
public class MakeNBySumOf123_5 {
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	long d[][] = new long[100001][4];
    	d[1][1] = 1; d[2][2] = 1;
    	d[3][1] = 1; d[3][2] = 1; d[3][3] = 1;
    	
    	while(n-->0) {
    		int k = sc.nextInt();
    		if(k>=4) {
    			for(int i=4;i<=k;i++) {
    				d[i][1] = d[i-1][2] + d[i-1][3]; d[i][1]%=1000000009;
    				d[i][2] = d[i-2][3] + d[i-2][1]; d[i][2]%=1000000009;
    				d[i][3] = d[i-3][1] + d[i-3][2]; d[i][3]%=1000000009;
    				
        		}
    		}
    		System.out.println((d[k][1]+d[k][2]+d[k][3])%1000000009);
    	}
    }
}