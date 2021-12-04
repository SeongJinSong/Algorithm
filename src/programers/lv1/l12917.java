package programers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class l12917 {
	public static void main(String[] args) {
		String s="Zbcdefg";
		System.out.println(new l12917().solution3(s));
	}
	public String solution(String s) {
		char[] carr =s.toCharArray();
		Arrays.sort(carr);
		//String s = s.chars().sorted()  
			//char[] 는 기본정렬은 되는데 파라미터(Comparator.reverseOrder(), (a,b)->a-b 등)가 안먹는다.
		//			.collect(Collectors.joining()); --> 이게 안된다.
		StringBuilder sb = new StringBuilder();
		for(int i=carr.length-1;i>=0;i--) {
			sb.append(carr[i]);
		}
        return sb.toString();
    }
	
	public String solution2(String s) {
		char[] carr = s.toCharArray();
		Arrays.sort(carr);
		return new StringBuilder(new String(carr)).reverse().toString();
	}
	public String solution3(String s) {
		//char array는 Comparater로 처리가 안됨, 람다도 안먹힘
		return Stream.of(s.split("")).sorted((a,b)->b.compareTo(a)).collect(Collectors.joining());
//		return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
	}
}
