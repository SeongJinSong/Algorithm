package baekjoon.random;

import java.util.*;
public class p1931 {
	static class Node implements Comparable<Node>{
		int from;
		int to;
		public Node(int from, int to) {
			this.from=from;
			this.to=to;
		}
		@Override
		public int compareTo(Node o) {
			if(this.to==o.to) {
				return this.from-o.to;
			}
			else
				return this.to-o.to;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Node> arr = new ArrayList<Node>();
		while(n-->0) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr.add(new Node(from, to));
		}
		Collections.sort(arr);
		int ans = 1;
		int last = arr.get(0).to;
		for(int i=1;i<arr.size();i++) {
			if(arr.get(i).from<last)continue;
			else {
				last = arr.get(i).to;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
