
public class l12903 {
	public static void main(String[] args) {
		String s = "abcde";
//		String s = "qwer";
		System.out.println(new l12903().solution2(s));
	}
	public String solution(String s) {
        return s.length()%2==0?s.substring(s.length()/2-1,s.length()/2+1)
        		:s.charAt(s.length()/2)+"";
    }
	//2로 나누기전에 1을 빼서 짝수/홀수 분기처리를 안할 수 있다.
	public String solution2(String s) {
        return s.substring((s.length()-1)/2,s.length()/2+1);
    }
}
