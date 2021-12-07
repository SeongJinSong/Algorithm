package programers.lv1;

public class l12940 {
	public static void main(String[] args) {
		int n=8, m=12;
		new l12940().print(new l12940().solution(n, m));
//		System.out.println(new l12940().calc(n, m));
	}
	public int[] solution(int n, int m) {
        //최대공약수 구한 후 add
		//n*m/최대공약수 = 최소공배수
		int max = calc(n,m);
		return new int[] {max, n*m/max};
    }
	//유틀리드 호제법은 로직이 간단해서 외워졌다. a = bx+r일때 (a,b) = (b,r) 이다.
	public int calc(int a, int b) {
		if(a%b==0)return b;
		return calc(b,a%b);
	}
	public void print(int[] arr) {
		for(int i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
