package baekjoon.dynamic.sol4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IndependentSetOfTree {
	static int n;
	static int w[] = new int[10001];
	static int d[][] = new int[10001][2];
	static ArrayList<Integer>[] a = new ArrayList[10001];
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	static void go(int now, int parent) {
		for (int i=0; i<a[now].size(); i++) {
	        if (parent == a[now].get(i)) {
	            continue;
	        }
	        go(a[now].get(i),now);
	    }
	    d[now][1] = w[now];
	    d[now][0] = 0;
	    for (int i=0; i<a[now].size(); i++) {
	        if (parent == a[now].get(i)) {
	            continue;
	        }
	        d[now][1] += d[a[now].get(i)][0];
	        d[now][0] += Math.max(d[a[now].get(i)][0],d[a[now].get(i)][1]);
	    }
	}
	static void gogo(int x, int y, int parent) {
		if (y==0) {
		       for (int i=0; i<a[x].size(); i++) {
		           if (parent == a[x].get(i)) {
		               continue;
		           }
		           if (d[a[x].get(i)][0] < d[a[x].get(i)][1]) {
		               gogo(a[x].get(i),1,x);
		           }
		           else {
		               gogo(a[x].get(i),0,x);
		           }
		       }
		   } else if (y == 1) {
		        ans.add(x);
		        for (int i=0; i<a[x].size(); i++) {
		            if (parent == a[x].get(i)) {
		                continue;
		            }
		            gogo(a[x].get(i),0,x);
		        }
		   }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<10001;i++) {
			a[i]=new ArrayList<Integer>();
		}
		for(int i=1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		for (int i=0; i<n-1; i++) {
	        int t1,t2;
	        t1 = sc.nextInt();
	        t2 = sc.nextInt();
	        a[t1].add(t2);
	        a[t2].add(t1);
	    }
		go(1,0);
		System.out.println(Math.max(d[1][0],d[1][1]));
		if (d[1][0] < d[1][1]) {
	        gogo(1,1,0);
	    } else {
	        gogo(1,0,0);
	    }
	    Collections.sort(ans);
	    for (int i=0; i<ans.size(); i++) {
	        System.out.print(ans.get(i)+" ");
	    }
	}
}