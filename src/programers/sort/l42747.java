package programers.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class l42747 {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		//System.out.println(solution2(citations));
		System.out.println(solution3(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		if(citations[0]>=citations.length) return citations.length;
		for (int h = 1; h <= citations.length; h++) {
			for (int i = 0; i < citations.length-1; i++) {
				if (citations[i] < h && citations[i + 1] >= h && citations.length - i -1 >= h) {
					answer = h;
				}
			}
		}
		return answer;
	}
	/* 원소 값은 점점 감소하고, 원소 값 이상인 것의 개수는 점점 증가하므로
	 * 이 두 값의 최소값의 변화가 증가하다가 감소하는 지점을 찾으면 그것이 답이 된다.
	 * 비슷한 관점을 생각해서 풀긴 했는데 아래와 같이 깔끔하게 다듬어지지 못했다.ㅏ
	 */
	public static int solution2(int[] citations) {
		Arrays.sort(citations);
		int max = 0;
		for(int i=citations.length-1;i>-1;i--) {
			int min = (int)Math.min(citations[i], citations.length-i);
			if(max<min) max = min;
		}
		return max;
	}
	/*
	 * 자바 스트림에서는 index를 파라미터로 주는게 없어서
	 * Arrays.sort를 한후 IntStream.range를 사용해서 구현해야한다
	 */
	public static int solution3(int[] citations) {
		Arrays.sort(citations);
		return IntStream.range(0, citations.length)
			.mapToObj(i->Math.min(citations[i], citations.length-i))
			.reduce(0, (a,b)->Math.max(a, b));
	}
	
}
