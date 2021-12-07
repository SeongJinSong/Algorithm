package programers.lv1;

import java.util.Arrays;

public class l12944 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		System.out.println(new l12944().solution(arr));
	}
	public double solution(int[] arr) {
        double answer = 0;
        for(int i:arr)answer+=i;
        return answer/arr.length;
    }
	public double solution2(int[] arr) {
		return Arrays.stream(arr).average().orElse(0);
    }
}
