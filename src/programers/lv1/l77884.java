package programers.lv1;

public class l77884 {
	public static void main(String[] args) {
		int left=24, right=27;
		System.out.println(new l77884().solution(left, right));
	}
	public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(isEven(i))answer+=i;
            else answer-=i;
        }
        return answer;
    }
    public boolean isEven(int num){
        int cnt=0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0)cnt++;
        }
        return ++cnt%2==0;
    }
    /* 제곱수인 경우 약수의 개수가 홀수
     * 제곱수가 아닌 경우 약수의 개수가 짝수
     * */
    public int solution2(int left, int right) {
        int answer = 0;
        for (int i=left;i<=right;i++) {
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            else {
                answer += i;
            }
        }
        return answer;
    }
}
