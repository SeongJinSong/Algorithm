package programers.lv1;

public class l12931 {
	public static void main(String[] args) {
		int n=123;
		System.out.println(new l12931().solution(n));
	}
	public int solution(int n) {
        int answer = 0;
        while(n>0) {
        	answer+=n%10;
        	n/=10;
        }
        return answer;
    }
}
