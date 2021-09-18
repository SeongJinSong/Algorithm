package programers.greedy;

import java.util.Arrays;

public class l42885 {
	public static void main(String[] args) {
//		int[] people= {70, 50, 80, 50}; int limit=100;
//		int[] people= {70, 80, 50}; int limit=100;
		int[] people= {20, 30, 40, 140, 150, 160}; int limit=180;
		System.out.println(solution2(people, limit));
	}
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int left =0;
		int right = people.length-1;
		int answer=0;
		while(left<=right) {
			//무거운 사람 먼저 태운다.
			int cur = people[right--];
			//안태운 사람중 가장 가벼운 사람을 태운다.
			if(cur+people[left]<=limit) {
				left++;
			}
			answer++;
		}
        return answer;
    }	
	/*솔루션과 풀이방법 차이는 없다. answer 변수하나 뺀차이*/
	public static int solution2(int[] people, int limit) {
		Arrays.sort(people);
		int left =0;
		int right = people.length-1;
		while(left<=right) {
			if(people[left]+people[right--]<=limit) {
				left++;
			}
		}
        return people.length-left;
	}
}
