package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class l43163 {
	public static void main(String[] args) {
		String begin="hit",target="cog"; String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
//		String begin="hit",target="cog"; String[] words= {"hot", "dot", "dog", "lot", "log"};
		System.out.println(new l43163().solution(begin, target, words));
	}
	class Word{
		private String word;
		private Integer depth;
		public Word(String word, Integer depth) {
			this.word=word;
			this.depth=depth;
		}
	}
	/*contain 함수로 bfs전에 체크를 하고 싶어서 ArrayList를 사용했다.*/
	public int solution(String begin, String target, String[] words) {
		ArrayList<String> arr = new ArrayList<String>(Arrays.asList(words));
		HashSet<String> hs = new HashSet<String>();
		if(!arr.contains(target))return 0;
		Queue<Word> q = new LinkedList<Word>();
		q.add(new Word(begin, 0));
		while(!q.isEmpty()) {
			Word cur = q.poll();
			if(target.equals(cur.word))return cur.depth;
			hs.add(cur.word);
			for(String s : arr) {
				if(hs.contains(s)||!check1diff(cur.word, s))continue;
				q.add(new Word(s, cur.depth+1));
			}
		}
        int answer = 0;
        return answer;
    }
	public boolean check1diff(String a, String b) {
		int diff=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!=b.charAt(i))diff++;
		}
		if(diff==1)return true;
		return false;
	}
	/*변수짓기 애매했는데 Node라는 추상적인 변수가 더 자연스럽다.*/
	class Node{
		private String word;
		private Integer depth;
		public Node(String word, Integer depth) {
			this.word=word;
			this.depth=depth;
		}
	}
	public int solution2(String begin, String target, String[] words) {
		/*visit 이라는 변수가 더 적합하다.*/
		boolean[] visit = new boolean[words.length];
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(begin, 0));
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(target.equals(cur.word))return cur.depth;
			for(int i=0;i<words.length;i++) {
				if(visit[i]||!check1diff(cur.word, words[i]))continue;
				q.add(new Node(words[i], cur.depth+1));
				visit[i]=true;
			}
		}
        return 0;
    }
	/*isNext라는 추상적인 함수명이 더 나을 것 같다.*/
	public boolean isNext(String a, String b) {
		int diff=0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)!=b.charAt(i)) {
				if(diff++>1)return false;
			}
		}
		return true;
	}
}
