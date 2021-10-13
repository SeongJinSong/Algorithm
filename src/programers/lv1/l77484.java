package programers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;

public class l77484 {
	public static void main(String[] args) {
//		int[] lottos= {44, 1, 0, 0, 31, 25};int[] win_nums= {31, 10, 45, 1, 6, 19};
//		int[] lottos= {0, 0, 0, 0, 0, 0};int[] win_nums= {38, 19, 20, 40, 15, 25};
		int[] lottos= {45, 4, 35, 20, 3, 9};int[] win_nums= {20, 9, 3, 45, 4, 35};
		print(solution(lottos, win_nums));
	}
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        /*map을 사용하면 조금 더 성능 개선이 가능하다.*/
        ArrayList<Integer> a = new ArrayList<Integer>();
        int zcnt=0;
        int wcnt=0;
        for(int v: lottos) {
        	if(v==0)zcnt++;
        	else a.add(v);
        }
        for(int v : a) {
        	for(int k:win_nums) {
        		if(v==k)wcnt++;
        	}
        }
        answer[0]=(7-(wcnt+zcnt))>5?6:(7-(wcnt+zcnt));
        answer[1]=(7-wcnt)>5?6:(7-wcnt);
        return answer;
    }
	public static void print(int[] arr) {
		for(int a : arr)System.out.print(a+" ");
		System.out.println();
	}
	/* 람다를 통한 방식 */
	public int[] solution2(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
        )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }
}
