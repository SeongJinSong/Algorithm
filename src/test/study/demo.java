package test.study;

import java.util.HashMap;

public class demo {
	public static void main(String[] args) {
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		System.out.println(new demo().solution(v));
	}
	public int[] solution(int[][] v) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> y = new HashMap<Integer, Integer>();
        for(int i=0;i<v.length;i++){
            x.put(v[i][0], x.getOrDefault(v[i][0], 0)+1);
            y.put(v[i][1], y.getOrDefault(v[i][1], 0)+1);
        }
        for(int xx : x.keySet()) {
        	if(x.get(xx)==1)answer[0]=xx;
        }
        for(int yy : y.keySet()) {
        	if(y.get(yy)==1)answer[1]=yy;
        }
        return answer;
    }
}
