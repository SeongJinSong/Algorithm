package programers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class l42627 {
	public static void main(String[] args) {
		int[][] jobs = {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
//		int[][] jobs = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
//		int[][] jobs = {{0, 5}, {2, 10}, {100000000, 2}};
		
		l42627 ll = new l42627();
		System.out.println(ll.solution(jobs));;
	}
	/* 스케쥴링 알고리즘
	 * SPN(Shortest Process Next) / SJF(Shortest Job First)
	 * 준비 큐에서 가장 짧은(CPU 요구량이 적은 프로세스에게 CPU 할당)\
	 * starvation 발생 가능, aging 기법으로 해결
	 * 실행 전에는 실행 시간을 알 수 없다. 지수 평균 방법을 통해 추측한다.
	 * 
	 * 해결 방법
	 * 1. 대기 큐에 모든 작업을 넣고 요청 시간을 기준으로 오름차순 정렬 한다.
	 * 2. 아래를 반복한다.
	 * 	1) 현재 시간 이하의 요청 시간을 가지는 작업을 모두 대기 큐에서 작업 큐로 올긴다.
	 *  2) 작업 큐에서 가장 작업시간이 짧은 작업을 꺼내서 작업한다.
	 */
	class Job implements Comparable<Job>{
		private int in;
		private int length;
		public Job(int in, int length){
			this.in=in;
			this.length = length;
		}
		@Override
		public int compareTo(Job o) {
			if(this.in==o.in) {
				return this.length-o.length;
			}
			return this.in-o.in;
		}
	}
	/* class sort와 pq sort 를 별도로 가져갈 수 있다.
	 * class : Comparable interface
	 * PriorityQueue : 생성자에 Comparator
	 */
	public int solution(int[][] jobs) {
		Job[] joblist = new Job[jobs.length];
        for(int i=0;i<jobs.length;i++) {
        	joblist[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(joblist);
        int answer = bfs(joblist);
        return answer/joblist.length;
    }
	public int bfs(Job[] joblist) {
		PriorityQueue<Job> pq = new PriorityQueue<Job>(new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o1.length-o2.length;
			}
		});
		pq.add(joblist[0]);
		int curr=joblist[0].in;
		int idx = 0;
		int[] check = new int[joblist.length];
		int sum = 0;
		while(idx<=joblist.length-1) {
			Job currJob = pq.poll();
			if(currJob==null)break;
			curr+=currJob.length;
			sum+=curr-currJob.in;
			for(int i=idx+1;i<joblist.length;i++) {
				if(curr>=joblist[i].in&&check[i]==0) {
					pq.add(joblist[i]);
					check[i]=1;
					idx=i;
				}
				else if(pq.isEmpty()) {
					curr=joblist[i].in;
					pq.add(joblist[i]);
					check[i]=1;
					idx=i;
				}
			}
			
		}
		return sum;
	}
}
