package programers.dfs_bfs;

public class l43165 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	public static int answer = 0;
	public static int solution(int[] numbers, int target) {
		dfs(numbers, 0, target, 0);
        return answer;
    }
	public static void dfs(int[] numbers, int current, int target, int i) {
        if(i>numbers.length)return;
        if(i==numbers.length) {
        	if(target==current) answer++;
        	return;
        }
        dfs(numbers, current+numbers[i], target, i+1);
        dfs(numbers, current-numbers[i], target, i+1);
       
	}
}
