package programers.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class l49189 {
	public static void main(String[] args) {
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		n = 6;
		System.out.println(solution2(n,edge));
	}
	/* 답음 맞는데 n이 커짐에 따라 '메모리 초과' 이슈가 발생했다.*/
	private static int[][] graph;
	private static int[] min;
	private static int n;
	
	public static int solution(int n, int[][] edge) {
		graph = new int [n+1][n+1];
		min = new int [n+1];
		for(int i=0;i<edge.length;i++) {
			graph[edge[i][0]][edge[i][1]] = graph[edge[i][1]][edge[i][0]] = 1;
		}
        bfs(1);
        int max = 0;
        for(int i : min) {
        	if(i>=max)max=i;
        }
        int answer = 0;
        for(int i : min) {
        	if(max==i)answer++;
        }
        return answer;
    }
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		min[start]=0;		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i=1;i<n+1;i++) {
				if(i ==curr || i==start)continue;
				if(graph[curr][i]==1) {
					if(min[i]==0) {
						min[i]=min[curr]+1;
						q.add(i);
					}
					else if(min[i]!=0&&min[i]>min[curr]+1) {
						min[i]=min[curr]+1;
						q.add(i);
					} 
				}
			}
		}
	}
	/* 링크드 리스트로 구현 */
	private static HashMap<Integer, HashSet<Integer>> graph2;
	public static int solution2(int n, int[][] edge) {
		graph2 = new HashMap<Integer, HashSet<Integer>>();
		for(int i=1;i<=n;i++) {
			graph2.put(i, new HashSet<Integer>());
		}
		min = new int [n+1];
		for(int i=0;i<edge.length;i++) {
			graph2.get(edge[i][0]).add(edge[i][1]);
			graph2.get(edge[i][1]).add(edge[i][0]);
		}
        bfs2(1);
        int max = 0;
        for(int i : min) {
        	if(i>=max)max=i;
        }
        int answer = 0;
        for(int i : min) {
        	if(max==i)answer++;
        }
        return answer;
    }
	public static void bfs2(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		min[start]=0;		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int i : graph2.get(curr)) {
				if(i==start)continue;
				if(min[i]==0) {
					min[i]=min[curr]+1;
					q.add(i);
				}
				else if(min[i]!=0&&min[i]>min[curr]+1) {
					min[i]=min[curr]+1;
					q.add(i);
				} 
			}
		}
	}
}
