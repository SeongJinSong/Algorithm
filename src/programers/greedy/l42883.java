package programers.greedy;

import java.util.TreeSet;

public class l42883 {
	public static void main(String[] args) {
		String number="1924"; int k=2;
//		String number="1231234"; int k=3;
//		String number="4177252841"; int k=4;
		System.out.println(solution(number, k));
	}
	static TreeSet<Integer> ts = new TreeSet<Integer>();
	public static String solution(String number, int k) {
        String answer = "";
        findMax("", number, 0, k);
        System.out.println(ts);
        return answer;
    }
	public static void findMax(String cur, String number, int idx, int k) {
		if(idx>number.length()-1)return;
		if(cur.length()==number.length()-k) {
			ts.add(Integer.valueOf(cur));
			return;
		}
		
		for(int i=0;i<cur.length();i++) {
			findMax(cur, number, idx+1, k);
			findMax(cur.substring(0,i)+number.charAt(idx)+cur.substring(i, cur.length()),number, idx+1, k);
		}
	}
	public static String max(String a, String b) {
		int n1 = Integer.valueOf(a);
		int n2 = Integer.valueOf(b);
		if(n1>n2) return String.valueOf(n1);
		return String.valueOf(n2);
		
	}
}
