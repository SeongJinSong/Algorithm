package programers.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class l64065 {
	public static void main(String[] args) {
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";
		new l64065().print(new l64065().solution2(s));
	}
	public int[] solution(String s) {
		String sw = s.substring(1, s.length()-1);
		StringBuilder sb = new StringBuilder();
		Stack<Character> stk = new Stack<Character>();
		for(int i=0;i<sw.length();i++) {
			if(sw.charAt(i)=='{') {
				stk.push('{');
			}
			else if(sw.charAt(i)=='}') {
				stk.pop();
			}
			else if(sw.charAt(i)==','&&stk.isEmpty()){
				sb.append('$');
			}
			else {
				sb.append(sw.charAt(i));
			}
		}
		String[] sarr = sb.toString().split("\\$");
		Arrays.sort(sarr, (a,b)->a.length()-b.length());
        int[] answer = new int[sarr.length];
        HashSet<String> hs = new HashSet<String>();
        for(int i=0;i<sarr.length;i++) {
        	String[] sa = sarr[i].split(",");
        	if(sa.length==1) {
        		answer[i]=Integer.valueOf(sa[i]);
        		hs.add(sa[i]);
        	}
        	else {
        		for(int j=0;j<sa.length;j++) {
        			if(!hs.contains(sa[j])) {
        				answer[i]=Integer.valueOf(sa[j]);
        				hs.add(sa[j]);
        				break;
        			}
        		}
        	}
        	
        }
        return answer;
    }
	public void print(int[] s) {
		for(int st : s)System.out.print(st+" ");
		System.out.println();
	}
	public void print(String[] s) {
		for(String st : s)System.out.print(st+" ");
		System.out.println();
	}
	/* 정규식을 사용하여 더 쉽게 스트링 값들을 나눌 수 있다.
	 * set add 함수에는 중복여부에 따라 true, false값을 return 한다.
	 * */
	public int[] solution2(String s) {
		Set<String> set = new HashSet<>();
		String[] arr = s.replaceAll("[{]", " ")
				.replaceAll("[}]", " ").trim().split(" , ");
		Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
		int[] answer = new int[arr.length];
		int idx = 0;
		for(String s1:arr) {
			for(String s2 : s1.split(",")) {
				if(set.add(s2))answer[idx++]=Integer.parseInt(s2);
			}
		}
		return answer;
	}
	/*
	 * Map에 파싱한 스트링을 넣는고 카운트를 센다.
	 * n-카운트가 index가 된다.
	 * */
	public int[] solution3(String s) {
		Map<String, Integer> map = new HashMap<>();
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher(s);
		while(matcher.find()) {
			String n = matcher.group();
			map.put(n,  map.getOrDefault(n, 0)+1);
		}
		int size = map.size();
		int[] answer = new int[size];
		for(String key: map.keySet()) {
			answer[size-map.get(key)] = Integer.parseInt(key);
		}
		return answer;
	}
	/* Steam을 이용한 풀이 --> 코테에서는 부담스럽다.
	 * */
	final Map<Integer, Integer> counts = new LinkedHashMap<>();
	public int[] solution4(String s) {
		Stream.of(s.replaceAll("[}", "").split(",")).mapToInt(Integer::parseInt)
		.forEach(i->counts.merge(i, 1, Integer::sum));
		return counts.entrySet().parallelStream().sorted(
				Collections.reverseOrder(Map.Entry.comparingByValue())
				).map(Map.Entry::getKey).mapToInt(x->x).toArray();
	}
}
