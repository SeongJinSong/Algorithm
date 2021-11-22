package programers.lv1;

import java.util.PriorityQueue;

public class l42889 {
	public static void main(String[] args) {
		int N=5; int[] stages= {2, 1, 2, 6, 2, 4, 3, 3};
		new l42889().print(new l42889().solution(N, stages));
	}
	class Ratio{
		double ratio;
		int stage;
		public Ratio(double ratio, int stage) {
			this.ratio=ratio;
			this.stage=stage;
		}
	}
	public int[] solution(int N, int[] stages) {
		PriorityQueue<Ratio> pq = new PriorityQueue<Ratio>((a,b)->{
			if(a.ratio>b.ratio)return -1;
			else if(a.ratio<b.ratio) return 1;
			else return a.stage-b.stage;
		});
		int len = 0;
		for(int i=1;i<=N;i++) {
			int cnt=0;
			for(int j=0;j<stages.length;j++) {
				if(stages[j]==i) {
					cnt++;
				}
			}
			pq.add(new Ratio((double)cnt/(stages.length-len), i));
			len+=cnt;
		}
		int[] answer = new int[pq.size()];
		int i=0;
		while(!pq.isEmpty()) {
			answer[i++]=pq.poll().stage;
		}
        return answer;
    }
	public void print(int[] arr) {
		for(int i : arr)System.out.print(i+" ");
		System.out.println();
	}
}
