package programers.heap;

import java.util.PriorityQueue;

public class l42627 {
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		l42627 ll = new l42627();
		System.out.println(ll.solution(jobs));;
	}
	class Job implements Comparable<Job>{
		private int in;
		private int length;
		public Job(int in, int length){
			this.in=in;
			this.length = length;
		}
		@Override
		public int compareTo(Job o) {
			return this.length-o.length;
		}
	}
	Job[] joblist;
	int[] check;
	PriorityQueue<Job> pq;
	public int solution(int[][] jobs) {
		pq  = new PriorityQueue<Job>();
		joblist = new Job[jobs.length];
		check = new int [jobs.length];
        for(int i=0;i<jobs.length;i++) {
        	joblist[i] = new Job(jobs[i][0], jobs[i][1]);
        }
        check[0]=1;
        pq.add(joblist[0]);
        int answer = bfs();
        return answer/joblist.length;
    }
	public int bfs() {
		int sum = 0;
		int start = 0;
		while(!pq.isEmpty()) {
			Job job = pq.poll();
			start+=job.length;
			sum+=start-job.in;
			for(int i=0;i<joblist.length;i++) {
				if(start>=joblist[i].in&&check[i]==0) {
					check[i]=1;
					pq.add(joblist[i]);
				}
			}
		}
		return sum;
	}
}
