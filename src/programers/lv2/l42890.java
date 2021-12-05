package programers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class l42890 {
	public static void main(String[] args) {
//		String[][] relation= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
//		String[][] relation= { {"a","1","aaa","c","ng"},{"a","1","bbb","e","g"},{"c","1","aaa","d","ng"},{"d","2","bbb","d","ng"}};
		String[][] relation= {{"100","ryan","music","2"},{"100","apeach","music","2"},{"300","ryan","computer","3"}};
		System.out.println(new l42890().solution(relation));
	}
	HashSet<String> hs = new HashSet<>();
	boolean[] visited;
	public int solution(String[][] relation) {
        int n = relation[0].length;
        visited=new boolean[n+1];
        for(int i=1;i<=n;i++) {
        	comb(relation, n, i, 0);
        }
        ArrayList<String> res = new ArrayList<>();
        hs.forEach(i->res.add(i));
        Collections.sort(res, (a,b)->a.length()-b.length());
        for(int i=0;i<res.size();i++) {
        	for(int j=i+1;j<res.size();j++) {
        		if(containString(res.get(i), res.get(j))) {
        			res.remove(j);
        		}
        	}
        }
        return res.size();
    }
	public void comb(String[][] relation, int n, int r, int depth) {
		if(depth==r) {
			StringBuilder sb = new StringBuilder();
			for(int i=1;i<visited.length;i++) {
				if(visited[i])sb.append(i);
			}
			String hsKey = sortedString(sb.toString());
			Iterator<String> it = hs.iterator();
			while(it.hasNext()) {
				String ns = it.next();
				if(hsKey.indexOf(ns)!=-1) return;
			}
			HashSet<String> tmpHs = new HashSet<>();
			for(int i=0;i<relation.length;i++) {
				StringBuilder sb2 = new StringBuilder();
				for(int j=0;j<visited.length-1;j++) {
					if(visited[j+1])sb2.append(relation[i][j]);
				}
				if(!tmpHs.add(sb2.toString())) {
					return;
				}
			}
			hs.add(hsKey);
		}
		for(int i=depth+1;i<=n;i++) {
			if(visited[i])continue;
			visited[i]=true;
			comb(relation, n, r, depth+1);
			visited[i]=false;
		}
	}
	public String sortedString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	public boolean containString(String a, String b) {
		if(a.length()==b.length())return false;
		int cnt =0;
		for(int i=0;i<a.length();i++) {
			for(int j=0;j<b.length();j++) {
				if(a.charAt(i)==b.charAt(j))cnt++;
			}
		}
		return a.length()==cnt;
	}
}
