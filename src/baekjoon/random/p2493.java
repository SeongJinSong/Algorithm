package baekjoon.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		ArrayList<Integer> a = new ArrayList<Integer>();
		while(n-->0) {
			a.add(Integer.parseInt(tk.nextToken()));
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);
		int max = a.get(0);
		for(int i=1;i<a.size();i++) {
			if(max<a.get(i)) {
				max=a.get(i);
				res.add(0);
				continue;
			}
			for(int j=i-1;j>=0;j--) {
				if(a.get(j)>a.get(i)) {
					res.add(j+1);
					break;
				}
				else if(j==0) res.add(0);
			}
		}
		for(int i:res)System.out.print(i+" ");
	}
}
