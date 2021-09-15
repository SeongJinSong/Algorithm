package programers.greedy;

import java.util.TreeSet;

public class l42883 {
	public static void main(String[] args) {
//		String number="1924"; int k=3;
//		String number="1231234"; int k=3;
//		String number="4177252841"; int k=4;
//		String number="321924"; int k=2;
		String number="9998887776665554443332221110009"; int k=30;
		System.out.println(solution2(number, k));
	}
	/* 그리디 문제라 재귀호출로 풀면 죽었다 깨어나도 성능테스트를 통과 못함*/
	static TreeSet<String> ts = new TreeSet<String>((o1, o2)-> {
		if(o1.length()==o2.length()) {
			return (o1+o2).compareTo(o2+o1);
		}
		return o1.length()-o2.length();
	});
	public static String solution(String number, int k) {
		deleteChar(new StringBuilder(number), number, k);
        return String.valueOf(ts.pollLast());
    }
	public static void deleteChar(StringBuilder sb, String number, int k) {
		if(sb.toString().length()<number.length()-k)return;
		else if(sb.toString().length()==number.length()-k) {
			ts.add(sb.toString());
			return;
		}
		for(int i=0;i<sb.toString().length();i++) {
			deleteChar(new StringBuilder(sb).delete(i, i+1),number, k);
		}
	}
	
	/*그리디 알고리즘으로 풀어보자
	 * 1개를 지웠을 때 가장 큰 수가되는 index를 찾아서 지워준다.
	 * 그걸 k개까지 반복한다. --> 느림
	 * 
	 * 질문에서 실수로 first, second를 봐버림;
	 * 1.다음에 올 숫자와 크기를 비교한다.
	 * 2.다음꺼가 더 크면 현재를 지운다.
	 * */
	public static String solution2(String number, int k) {
		StringBuilder sb = new StringBuilder(number);
		int index = 0;
		while(k>0&&index<sb.toString().length()-1) {
			/*처음에 짠 코드인데 O(n)이므로 테스트케이스 6~10성능테스트를 통과하지 못함
			 	int idx=0;
			 	for(int i=idx;i<sb.toString().length();i++) {
					if(compare(sb, idx, i)<0){
						idx=i;
					}
				}
				sb.delete(idx, idx+1);
			*/
			if(	sb.toString().charAt(index)<sb.toString().charAt(index+1)) {
				sb.delete(index, index+1);
				index = index==0?0:index-1;
				k--;
			}
			else index++;
		}
		if(k==1)return sb.delete(1, 2).toString();
		return sb.toString();
    }
	public static int compare(StringBuilder sb, int idx, int i) {
		return new StringBuilder(sb).delete(idx, idx+1).toString().compareTo(new StringBuilder(sb).delete(i, i+1).toString());
	}
}
