package programers.lv2;

public class l12985 {
	public static void main(String[] args) {
		int n=8, a=7, b=8;
		System.out.println(new l12985().solution(n, a, b));
	}
	public int solution(int n, int a, int b){
		int level=1;
		while(true) {
			int groupSize=(int)Math.pow(2, level);
			if(groupSize==0)break;
			for(int i=0;i<n;i+=groupSize) {
				if(i<=a-1&&a-1<i+groupSize&&i<=b-1&&b-1<i+groupSize) {
					return level;
				}
			}
			level++;
		}
		return -1;
    }
	//두 수의 이진법을 xor한 문자열의 길이가 라운드수가 된다. 원리는 나도 모르겠다..
	public int solution2(int n, int a, int b){
		return Integer.toBinaryString((a-1)^(b-1)).length();
	}
	//아이디어가 너무 대단하다.
	public int solution3(int n, int a, int b){
		int round=0;
		while(a!=b) {
			a=a/2+a%2;
			b=b/2+b%2;
			round++;
		}
		return round;
	}
}
