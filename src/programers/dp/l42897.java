package programers.dp;

import java.util.Arrays;

public class l42897 {
	public static void main(String[] args) {
		int[] money = {1000,0,0,1000,0,0,1000,0,0,1000};
		System.out.println(solution(money));
	}
	public static int solution(int[] money) {
		for(int i=3;i<money.length;i++) {
			money[i]+=Math.max(money[i-2], money[i-3]);
		}
        return Arrays.stream(money).max().getAsInt();
    }
}
