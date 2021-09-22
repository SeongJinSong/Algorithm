package programers.dp;

public class l43105 {
	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
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
}
