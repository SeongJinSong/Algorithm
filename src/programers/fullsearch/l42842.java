package programers.fullsearch;

public class l42842 {
	public static void main(String[] args) {
//		int brown=10, yellow=2;
//		int brown=8, yellow=1;
		int brown=24, yellow=24;
		print(solution(brown, yellow));
	}
	public static int[] solution(int brown, int yellow) {
        int width=0, height=0;
        for(int i=1;i*i<=(brown+yellow);i++) {
        	if((brown+yellow)%i==0 && i>height && yellow==((brown+yellow)/i-2)*(i-2)) {
        		height=i;
        		width = (brown+yellow)/height;
        	}
        }
        int[] answer = {width, height};
        return answer;
    }
	/* 근의 공식을 활용하여 풀 수 있다*/
	public static int[] solution2(int brown, int yellow) {
        int a = (brown+4)/2; // width + height
        int b = brown+yellow; //width * height
        // (x-width)(x-height) = 0
        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
        return answer;
    }
	public static void print(int[] arr) {
		for(int i : arr) System.out.print(i+" ");
	}
}
