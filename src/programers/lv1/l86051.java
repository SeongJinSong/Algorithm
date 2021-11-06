package programers.lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class l86051 {
	public static void main(String[] args) {
//		int[] numbers= {1,2,3,4,6,7,8,0};
		int[] numbers= {5,8,4,0,6,7,9};
		System.out.println(new l86051().solution2(numbers));
	}
	public int solution(int[] numbers) {
        int answer = 45;
        for(int i : numbers)answer-=i;
        return answer;
    }
	/* 스트림을 사용*/
	public int solution2(int[] numbers) {
        return IntStream.range(0, 10).filter(i -> Arrays.stream(numbers).noneMatch(num -> i == num)).sum();
    }
}
