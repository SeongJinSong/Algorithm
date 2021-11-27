package programers.lv1;

import java.util.Arrays;

public class l12982 {
	public static void main(String[] args) {
//		int[] d = {1,3,2,5,4}; int budget=9;
		int[] d = {2,2,3,3}; int budget=10;
		System.out.println(new l12982().solution(d, budget));
	}
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int sum=0;
		int answer = 0;
		for(int i=0;i<d.length;i++) {
			sum+=d[i];
			if(sum<=budget)
				answer++;
			else break;
		}
        return answer;
    }
}
