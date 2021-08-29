package programers.greedy;

import java.util.ArrayList;

public class l42862 {
	public static void main(String[] args) {
		int n = 5;
		int [] lost = {2,3,4};
		int [] reserve = {1,2,3};
		System.out.println(solution(n, lost, reserve));
	}
	public static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> larr = new ArrayList<Integer>();
        ArrayList<Integer> rarr = new ArrayList<Integer>();
        for(int i:reserve) {
        	rarr.add(i);
        }
        for(int i: lost) {
        	int idx;
        	if((idx=rarr.indexOf(i))!=-1) {
        		rarr.remove(idx);
        		continue;
        	}
        	larr.add(i);
        }
        for(int i : rarr) {
        	int idx;
        	if((idx = larr.indexOf(i-1)) !=-1 ||
        		(idx = larr.indexOf(i+1))!=-1) {
        		larr.remove(idx);
        		continue;
        	}
        }
        return n-larr.size();
    }
	/* 배열로 각 index를 카운트로 정리하는 아이디어가 빛남*/
	public int solution2(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost) 
            people[l-1]--;
        for (int r : reserve) 
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else 
                    answer--;
            }
        }
        return answer;
    }
	
}
