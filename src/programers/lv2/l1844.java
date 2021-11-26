package programers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class l1844 {
	public static void main(String[] args) {
		int[][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(new l1844().solution(maps));
	}
	class Node{
		int y;
		int x;
        int len;
		public Node(int ny, int nx, int len) {
			this.y=ny;
			this.x=nx;
            this.len=len;
		}
	}
    boolean[][] visited;
    public int solution(int[][] maps) {
    	visited = new boolean[maps.length][maps[0].length];
        int answer = -1;
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0,0,1));
        visited[0][0] = true;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0 ,0};
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.y==maps.length-1&&cur.x==maps[0].length-1)return cur.len;
            for(int i=0;i<4;i++) {
            	int ny = cur.y+dy[i];
            	int nx = cur.x+dx[i];
            	if(ny<0||ny>=maps.length||nx<0||nx>=maps[0].length)continue;
            	if(!visited[ny][nx]&&maps[ny][nx]==1) {
            		q.add(new Node(ny, nx, cur.len+1));
            		visited[ny][nx]=true;
            	}
            }
        }
        return answer;
    }
}
