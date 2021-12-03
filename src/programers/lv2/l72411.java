package programers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class l72411 {
	public static void main(String[] args) {
//		String[] orders= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; int[] course= {2,3,4};
//		String[] orders= {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; int[] course= {2,3,5};
		String[] orders= {"XYZ", "XWY", "WXA"}; int[] course= {2,3,4};
		new l72411().print(new l72411().solution(orders, course));
	}
	class Course{
		StringBuilder sb;
		int len;
		int cnt;
		public Course(StringBuilder sb, int len, int cnt) {
			this.sb=sb;
			this.len=len;
			this.cnt=cnt;
		}
	}
	boolean[] visited;
	ArrayList<Character> a;
	ArrayList<Course> res;
	HashSet<String> hs;
	String[] sortedOrders;
	int max=0;
	public String[] solution(String[] orders, int[] course) {
		hs = new HashSet<String>();
		ArrayList<String> result = new ArrayList<String>();
		sortedOrders = new String[orders.length];
		for(int i=0;i<orders.length;i++) {
			char[] tmp = orders[i].toCharArray();
			Arrays.sort(tmp);
			StringBuilder sb = new StringBuilder();
			for(char c : tmp)sb.append(c);
			sortedOrders[i]=sb.toString();
		}
		for(int r : course) {
			res = new ArrayList<Course>(); 
			max=0;
			for(String order:sortedOrders) {
				visited = new boolean[order.length()];
				comb(order, order.length(), r, 0);
			}
			for(Course nd : res) {
				if(max==nd.cnt)result.add(nd.sb.toString());
			}
		}
		Collections.sort(result);
        return result.stream().toArray(String[]::new);
    }
	public void addRes(String order,  int n, int r, StringBuilder sb) {
		int cnt=0;
		for(int i=0;i<sortedOrders.length;i++) {
			int len=0;
			for(int j=0;j<n;j++) {
				if(visited[j]&&sortedOrders[i].lastIndexOf(order.charAt(j))!=-1) {
					len++;
				}
			}
			if(len==r)cnt++;
		}
		if(cnt>=max&&cnt>1) {
			max=cnt;
			res.add(new Course(sb, r, cnt));
		}
	}
	public void comb(String order, int n, int r, int depth) {
		if(depth==r) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<visited.length;i++) {
				if(visited[i])sb.append(order.charAt(i));
			}
			if(!hs.add(sb.toString()))return;
			addRes(order, n, r, sb);
			return;
		}
		for(int i=depth;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(order, n, r, depth+1);
				visited[i]=false;
			}
		}
	}
	public void print(String[] arr) {
		for(String s : arr)System.out.print(s+" ");
		System.out.println();
	}
}
