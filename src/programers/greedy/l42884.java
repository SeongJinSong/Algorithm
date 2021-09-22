package programers.greedy;

import java.util.Arrays;

public class l42884 {
	public static void main(String[] args) {
		int[][] routes={{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution2(routes));
	}
	/*from to 구간을 기준으로 풀었다.*/
	public static int solution(int[][] routes) {
		/*구간을 기준으로 풀었기 때문에 첫번째 진입점을 기준으로 정렬*/
		Arrays.sort(routes, (a, b)->a[0]-b[0]);
		int idx=0;
		boolean initFlg=true;
		int from=Integer.MIN_VALUE;
		int to=Integer.MAX_VALUE;
		int answer = 0;
		while(idx<routes.length) {
			if(initFlg) {
				from = routes[idx][0];
				to = routes[idx][1];
				initFlg=false;
				idx++;
				answer++;
				continue;
			}
			if(from<routes[idx][0]) {
				from=routes[idx][0];
			}
			if(to>routes[idx][1]) {
				to=routes[idx][1];
			}
			if(to<routes[idx][0]) {
				initFlg=true;
				continue;
			}
			idx++;
		}
        return answer;
    }
	/*단순히 to 구간을 lastCamer로 설정하고 */
	public static int solution2(int[][] routes) {
		/*나가는 기준으로 정렬하고, 가장 빨리 나가는 차를 lastCamera 위치에 둔다.*/
		Arrays.sort(routes, (a, b)->a[1]-b[1]);
		int lastCamera=Integer.MIN_VALUE;
		int ans=0;
		for(int[] a : routes) {
			if(lastCamera<a[0]) {
				ans++;
				lastCamera=a[1];
			}
		}
		return ans;
	}
}
