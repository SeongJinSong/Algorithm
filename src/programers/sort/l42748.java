package programers.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class l42748 {
	public static void main(String[] args) {
		int [] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		print(solution(array, commands));
	}
	public static int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<commands.length;i++) {
			int [] tmparr = array.clone();
			//Arrays.copyOfRange(int[], int, int)를 사용할 수 있음
			Arrays.sort(tmparr, commands[i][0]-1, commands[i][1]);
			arr.add(tmparr[commands[i][0]+commands[i][2]-2]);
		}
        return arr.stream().mapToInt(i->i).toArray();
    }
	public static void print(int [] arr) {
		for(int i:arr)System.out.print(i+" ");
	}
}
