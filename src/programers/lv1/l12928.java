package programers.lv1;

public class l12928 {
	public static void main(String[] args) {
		int n = 12;
		new l12928().solution(n);
	}
	public int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++) {
        	if(n%i==0)answer+=i;
        }
        return answer;
    }
	//조금이라도 효율적으로 풀 수 있는지 항상 검토하자
	public int solution2(int n) {
        int answer = 0;
        for(int i=1;i<=n/2;i++) {
        	if(n%i==0)answer+=i;
        }
        return answer+n;
    }
}
