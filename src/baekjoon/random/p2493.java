package baekjoon.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class p2493 {
	static class Node{
		int idx;
		int height;
		Node(int idx, int height){
			this.idx=idx;
			this.height=height;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		Stack<Node> stk = new Stack<Node>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		int idx=1;
		int max=0;
		int maxIdx=1;
		while(tk.hasMoreTokens()) {
			int next = Integer.parseInt(tk.nextToken());
			if(stk.isEmpty()) {
				res.add(0);
				stk.add(new Node(idx, next));
				max=next;
				maxIdx=idx;
			}
			else if(max<next) {
				stk.clear();
				max = next;
				maxIdx=idx;
				stk.push(new Node(idx, next));
				res.add(0);
			}
			else if(stk.peek().height<next) {
				while(stk.peek().height<next)stk.pop();
				res.add(stk.peek().idx);
				stk.add(new Node(idx, next));
			}
			else {
				res.add(stk.peek().idx);
				stk.add(new Node(idx, next));
			}
			idx++;
		}
		for(int i:res)System.out.print(i+" ");
	}
}
