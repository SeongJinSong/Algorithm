package programers.dp;

import java.util.Arrays;

public class l43105 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution2(triangle));
	}
	/*처음 솔루션은 O(2^500) 이므로 성능테스트에서 통과 불가*/
	public static int solution(int[][] triangle) {
        return sum(triangle, 0, 0, 0);
    }
	public static int sum(int[][] triangle, int depth, int idx, int sum) {
		if(depth>triangle.length-1) {
			return sum;
		}
		sum+=triangle[depth][idx];
		return Math.max(sum(triangle, depth+1, idx, sum), sum(triangle, depth+1, idx+1,sum));
	}
	public static int solution2(int[][] triangle) {
		for(int i=1;i<triangle.length;i++) {
			for(int j=0;j<triangle[i].length;j++) {
				int left = j==triangle[i].length-1?j-1:j;
				int right= j-1<0?j=0:j-1;
				triangle[i][j]+=Math.max(triangle[i-1][left], triangle[i-1][right]);
			}
        }
		return Arrays.stream(triangle[triangle.length-1]).max().orElse(0);
    }
	/*솔루션
	 * 나보다 변수 2개를 덜썼다.. 맨끝과 마지막이므로 굳이 변수 쓸 이유가 없다.
	 * OptionalInt를 변경하는 방법은 orElse(0), getAsInt() 두가지 방법이 있다.
	 * */
	public static int solution3(int[][] triangle) {
		for(int i=1;i<triangle.length;i++) {
			triangle[i][0]+=triangle[i-1][0];
			triangle[i][i]+=triangle[i-1][i-1];
			for(int j=1;j<i;j++) {
				triangle[i][j]+=Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
	}
}
