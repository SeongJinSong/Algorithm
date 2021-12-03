package programers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class l72411 {
	public static void main(String[] args) {
		String[] orders= {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; int[] course= {2,3,4};
//		String[] orders= {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; int[] course= {2,3,5};
//		String[] orders= {"XYZ", "XWY", "WXA"}; int[] course= {2,3,4};
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
	public String[] solution(String[] orders, int[] course) {
		a = new ArrayList<Character>();
		hs = new HashSet<String>();
		for(String s : orders) {
			for(int i=0;i<s.length();i++) {				
				if(a.indexOf(s.charAt(i))==-1) {
					a.add(s.charAt(i));
				}
			}
		}
		Collections.sort(a);
		int n = a.size();
		visited = new boolean[n];
		ArrayList<String> result = new ArrayList<String>();
		for(int r : course) {
			res = new ArrayList<Course>(); 
			comb(orders, n, r, 0);
			int max = 0;
			for(Course nd : res) {
				if(max<nd.cnt)max=nd.cnt;
			}
			for(Course nd : res) {
				if(max==nd.cnt)result.add(nd.sb.toString());
			}
		}
		Collections.sort(result);
        return result.stream().toArray(String[]::new);
    }
	public void comb(String[] orders, int n, int r, int depth) {
		if(depth==r) {
			StringBuilder sb = new StringBuilder();
			int cnt=0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i])sb.append(a.get(i));
			}
			if(hs.contains(sb.toString()))return;
			for(int i=0;i<orders.length;i++) {
				int len=0;
				for(int j=0;j<n;j++) {
					if(visited[j]&&orders[i].lastIndexOf(a.get(j))!=-1) {
						len++;
					}
				}
				if(len==r)cnt++;
			}
			if(cnt>1) {
				hs.add(sb.toString());
				res.add(new Course(sb, r, cnt));
			}
			return;
		}
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(orders, n, r, depth+1);
				visited[i]=false;
			}
		}
	}
	public void print(String[] arr) {
		for(String s : arr)System.out.print(s+" ");
		System.out.println();
	}
}
