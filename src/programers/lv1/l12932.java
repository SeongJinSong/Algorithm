package programers.lv1;

public class l12932 {
	public static void main(String[] args) {
		long n = 12345;
		new l12932().print(new l12932().solution(n));
	}
	public int[] solution(long n) {
		int len = (int)Math.log10(n)+1;
        int[] answer = new int[len];
        int idx=0;
        while(n>0) {
        	answer[idx++]=(int)(n%10l);
        	n/=10;
        }
        return answer;
    }
	public void print(int[] arr) {
		for(int i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
