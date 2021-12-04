package programers.lv1;

public class l12921 {
	public static void main(String[] args) {
		int n=5;
		System.out.println(new l12921().solution(n));
	}
	public int solution(int n) {
        int answer = 0;
        for(int i=2;i<=n;i++) {
        	for(int j=2;j*j<=i;j++) {
        		if(i%j==0) {
        			answer++;
        			break;
        		}
        	}
        }
        return n-answer-1;
    }
}
