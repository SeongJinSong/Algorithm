package programers.sort;

import java.util.Arrays;

public class l42746 {
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}
	public static String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)nums[i]=String.valueOf(numbers[i]);
        Arrays.sort(nums, (o1,o2)->{
        	int min = Math.min(o1.length(),o2.length());
        	for(int i=0;i<min;i++) {
        		if(o1.charAt(i)==o2.charAt(i))continue;
        		else return Integer.valueOf(o2.charAt(i))-Integer.valueOf(o1.charAt(i));
        	}
        	return Integer.valueOf(o2+o1)-Integer.valueOf(o1+o2);
        });
        for(String s:nums)answer=answer.concat(s);
        return answer.startsWith("0")?"0":answer;
    }
	public static void print(String[] arr) {
		for(String s : arr)System.out.println(s+ " ");
	}
	public static String solution2(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] nums = new String[numbers.length];
        for(int i=0;i<numbers.length;i++)nums[i]=String.valueOf(numbers[i]);
        Arrays.sort(nums, (o1,o2)->Integer.valueOf(o2+o1)-Integer.valueOf(o1+o2));
        /* append 할때 StringBuilder를 쓰는게 더 효율적 
         * 프로그래머스 기준으로 3000ms 걸리는 작업이 186ms로 바뀜 
         * */
        for(String s:nums)sb.append(s);
        return sb.toString().startsWith("0")?"0":sb.toString();
    }
	public static String solution3(int[] numbers) {
        return Arrays.stream(numbers)
        		.mapToObj(String::valueOf)
        		.sorted((s1, s2) -> -s1.concat(s2).compareTo(s2.concat(s1)))
        		.reduce("", (s1, s2)->s1.startsWith("0")?"0":s1.concat(s2));
    }
}

