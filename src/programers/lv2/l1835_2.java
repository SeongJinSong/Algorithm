package programers.lv2;

import java.util.HashMap;

public class l1835_2 {
	public static void main(String[] args) {
		
	}
	boolean[] visit;
    int answer;
    int[] position;
    String[] conditions;
    HashMap<Character, Integer> friends;
    public int solution(int n, String[] data) {
        friends.put('A', 0);
        friends.put('C', 1);
        friends.put('F', 2);
        friends.put('J', 3);
        friends.put('M', 4);
        friends.put('N', 5);
        friends.put('R', 6);
        friends.put('T', 7);
        position = new int[friends.size()];
        visit = new boolean[friends.size()];
        conditions=data;
        answer = 0;
        dfs(0);
        return answer;
    }
    public void dfs(int idx){
        if(idx==8){
            if(check(position)){
                answer++;
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(visit[idx])continue;
            visit[idx]=true;
            position[idx] = i;
            dfs(idx+1);
            visit[idx]=false;
        }
    }
    public boolean check(int[] position){
        for(int i=0;i<conditions.length;i++){
            int from = friends.get(conditions[i].charAt(0));
            int to = friends.get(conditions[i].charAt(2));
            char op = conditions[i].charAt(3);
            int res = conditions[i].charAt(4)-'0';
            //position.indexOf(from);
        }
        return true;
    }
}
