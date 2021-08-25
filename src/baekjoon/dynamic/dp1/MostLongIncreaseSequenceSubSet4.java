package baekjoon.dynamic.dp1;

import java.util.*;
public class MostLongIncreaseSequenceSubSet4 {
	public static int a[];
	public static int v[];
	public static void go(int j) {
		if(j==0) return;
		go(v[j]);
		System.out.print(a[j]+" ");
	}
	public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	a = new int[n+1];
    	int d[] = new int[n+1];
    	v = new int[n+1];
    	for(int i=1;i<=n;i++) {
    		a[i] = sc.nextInt();
    		d[i] = 1; //�ʱ�ȭ�� �����ָ� �ȵ˴ϴ�.
    	}
    	for(int i=2;i<=n;i++) {
    		for(int j=1;j<i;j++) {
    			if(a[i]>a[j]) {
    				if(d[i]<d[j]+1) {
    					d[i] = d[j]+1;
    					v[i] = j;
    				}
    			}
    		}
    		
    	}
    	int ans = d[1];
    	int maxIdx = 1;
    	for(int i=2;i<=n;i++) {
    		if(ans < d[i]) {
    			maxIdx = i;
    			ans = d[i];
    		}
    	}
    	System.out.println(ans);
    	go(maxIdx);
    }
}