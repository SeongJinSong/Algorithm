package programers.lv1;

public class l12954 {
	public static void main(String[] args) {
		int x=2, n=5;
//		int x=4, n=3;
//		int x=-4, n=2;
		new l12954().print(new l12954().solution(x, n));
	}
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(long i=1;i<=n;i++) {
        	answer[(int)i-1]=x*i;
        }
        return answer;
    }
	public void print(long[] arr) {
		for(long i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
