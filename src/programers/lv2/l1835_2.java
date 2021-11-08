package programers.lv2;

import java.util.HashMap;

public class l1835_2 {
	public static void main(String[] args) {
		int n=2; String[] data= {"N~F=0", "R~T>2"};
//		int n=2; String[] data= {"M~C<2", "C~M>1"};
		System.out.println(new l1835_2().solution(n, data));
	}
	boolean[] visit;
    int answer;
    int err;
    int[] position;
    String[] conditions;
    HashMap<Character, Integer> friends;
    public int solution(int n, String[] data) {
    	friends = new HashMap<Character, Integer>();
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
        err=0;
        dfs(0);
        System.out.println("err:"+err+" ans:"+answer);
        return answer;
    }
    public void dfs(int idx){
        if(idx==8){
            if(check(position)){
                answer++;
            }
            else {
            	err++;
            }
            return;
        }
        for(int i=0;i<8;i++){
//        	err++;
        	if(visit[i])continue;
            visit[i]=true;
            position[idx] = i;
            dfs(idx+1);
            visit[i]=false;
        }
    }
    public boolean check(int[] position){
    	
        for(int i=0;i<conditions.length;i++){
            int from = friends.get(conditions[i].charAt(0));
            int to = friends.get(conditions[i].charAt(2));
            char op = conditions[i].charAt(3);
            int res = conditions[i].charAt(4)-'0'+1;
//            System.out.println("res:"+res);
            //position.indexOf(from);
            switch(op) {
            case '=':
            	if(Math.abs(position[from]-position[to])!=res) {
//            		System.out.println(op+" "+from+" "+to+" "+position[from]+" "+position[to]);
            		return false;
            	}
            	break;
            case '>':
            	if(Math.abs(position[from]-position[to])<=res) {
//            		System.out.println(op+" "+from+" "+to+" "+position[from]+" "+position[to]);
            		return false;
            	}
            	break;
            case '<':
            	if(Math.abs(position[from]-position[to])>=res) {
//            		System.out.println(op+" "+from+" "+to+" "+position[from]+" "+position[to]);
            		return false;
            	}
            	break;
            }
        }
        return true;
    }
}
