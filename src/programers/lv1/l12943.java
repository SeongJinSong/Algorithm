package programers.lv1;

public class l12943 {
	public static void main(String[] args) {
//		int num=6;
		int num=626331;
		System.out.println(new l12943().solution(num));
	}
	public int solution(long num) {
		int cnt=0;
		while(num!=1) {
			num=(num%2==0)?num/2:num*3+1;
			cnt++;
			if(cnt>500)return -1;
		}
        return cnt;
    }
}
