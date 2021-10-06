package programers.binarysearch;

import java.util.Arrays;

public class l43238_2 {
	public static void main(String[] args) {
		int n=6; int[] times= {7, 10};
		System.out.println(solution(n, times));
	}
	public static long solution(int n, int[] times) {
		long left=0;
		/*int * int를 long 변수에 assign 하는 경우 - 형변환이 안되는 문제가 발생할 수 있다.*/
		long right = (long)Arrays.stream(times).max().getAsInt()*(long)n;
		/* 한끗 차이인데 계산하기 너무 어렵다
		 * left<=right인 경우 right=mid-1을 하고 left를 return 해야 한다.
		 * 이걸 일일히 대입해서 테스트 해보지 않고 확실하게 인지할 수 있는 방법이 있을까?
		 * */
		while(left<right) {
			long mid = (left+right)/2;
			if(modi(mid, times)>=n)right = mid;
			else if(modi(mid, times)<n) left = mid+1;
		}
        return right;
    }
	public static long modi(long right, int[] times) {
		long rst = 0;
		for(long t:times)rst+=right/t;
		return rst;
	}
}
