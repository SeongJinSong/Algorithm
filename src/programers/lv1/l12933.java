package programers.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class l12933 {
	public static void main(String[] args) {
		long n = 118372;
		System.out.println(new l12933().solution(n));
	}
	public long solution(long n) {
		String a = n+"";
		char[] c = a.toCharArray();
		Arrays.sort(c);
		StringBuilder sb = new StringBuilder(new String(c)).reverse();
        return Long.parseLong(sb.toString());
    }
	//forEach문에는 같은함수의 로컬 변수를 사용하지 못한다.
	String res = "";
	public long solution2(long n) {
		Long.toString(n).chars().sorted().forEach(c->res=Character.valueOf((char)c)+res);
		return Long.parseLong(res);
    }
	
	public long solution3(long n) {
		return Long.parseLong(String.valueOf(n).chars()
				.mapToObj(ch->(char)ch)
				.sorted(Comparator.reverseOrder()) // 형변환 해주면 Comparator.reverseOrder() 사용 가능
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString());
    }
}
