package dynamic.dp1;

import java.util.*;
public class SumOfSquareNumber {
    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int d[] = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		d[i]=i;
    		for(int j=1;j*j<=i;j++) {
				d[i] = Math.min(d[i-j*j]+1, d[i]);
    		}
    	}
    	System.out.println(d[n]);
    }
}