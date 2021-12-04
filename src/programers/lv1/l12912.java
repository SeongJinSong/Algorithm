package programers.lv1;

public class l12912 {
	public static void main(String[] args) {
		int a=3, b=5;
//		int a=3, b=3;
//		int a=5, b=3;
		System.out.println(new l12912().solution(a, b));
	}
	public long solution(int a, int b) {
        return a==b?a:(long)(a+b)*(Math.abs(a-b)+1)/2;
    }
}
