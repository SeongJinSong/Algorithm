package programers.binarysearch;

import java.util.Arrays;

public class l43236_sol {
	public static void main(String[] args) {
		int distance=25; int[] rocks= {2, 14, 11, 21, 17}; int n=2;
		System.out.println(solution(distance, rocks, n));
	}
	public static int solution(int distance, int[] rocks, int n) {
		Arrays.sort(rocks);
		long left = 1;
		long right = distance;
		long answer = 0 ;
		while( left <= right ) {
			int removeRockCnt = 0 ;
			int prev = 0;
			long minDistance = (left+right)/2;
			for( int rock : rocks ) {
				if( (rock - prev) < minDistance ) removeRockCnt++;
				else prev = rock;
			}
			if( distance - prev < minDistance ) removeRockCnt++;
			if( removeRockCnt <= n ) {
    			answer = Math.max(answer, minDistance);
    			left = minDistance+1 ;
    		}
			else right = minDistance-1;
		}
		return (int)answer ;
    }
}
