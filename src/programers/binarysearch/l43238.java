package programers.binarysearch;

import java.util.Arrays;
/* 다시 풀어보기 */
public class l43238 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));
	}
	
	public static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		long left = 0;
		long right = (long) n*times[times.length-1]; // 가장 최악의 경우의 (오래걸리는) 시간
		while(left<=right) {
			long mid = (left+right)/2;
			long sum = 0; //총 심사한 인원
			for(int i=0;i<times.length;i++) { //빨리 심사하는 심사관 순으로 심사 처리
				sum += mid /times[i];
			}
			if(sum<n) { // 해야할 인원보다 심사처리 못함 -> 시간 더 필요
				left = mid +1;
			}else { //해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우 시간을 만든다.
				right = mid -1;
				answer = mid;
			}
		}
		return answer;
	}
	public static long solution1(int n, int[] times) {
		long answer = 0;
		long[] d = new long[n + 1];
		Arrays.sort(times);
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (i - j - 1 < times.length) {
					System.out.print("d["+i+"]:"+d[i]+"	d["+j+"]:"+d[j]+"	times["+(i-j-1)+"]:"+times[i-j-1] );
					d[i] = d[i] == 0 ? d[j] + times[i - j - 1] 
							: Math.min(d[i], d[j] + times[i - j - 1]);
					System.out.println("	d["+i+"]:"
							+ ""+d[i]);
				}
			}
		}
		return d[n];
	} 
}
