package programers.lv2;

import java.util.ArrayList;

public class l72412 {
	public static void main(String[] args) {
		String[] info= {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query= {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		new l72412().print(new l72412().solution(info, query));
	}
	public int[] solution(String[] info, String[] query) {
		ArrayList<String[]> iarr = new ArrayList<String[]>();
		ArrayList<String[]> qarr = new ArrayList<String[]>();
		for(int i=0;i<info.length;i++) {
			String[] ii = info[i].split(" ");
			iarr.add(ii);
		}
		for(int i=0;i<query.length;i++) {
			String[] qq = query[i].replaceAll(" and "," ").split(" ");
			qarr.add(qq);
		}
		int[] answer = new int[query.length];
		for(int i=0;i<qarr.size();i++) {
			int cnt=0;
			String[] tq = qarr.get(i);
			loop: for(int j=0;j<iarr.size();j++) {
				String[] ti = iarr.get(j);
				for(int k=0;k<tq.length;k++) {
					if("-".equals(tq[k]))continue;
					if(k!=tq.length-1&&!tq[k].equals(ti[k]))continue loop;
					if(k==tq.length-1) {
						int iscore = Integer.valueOf(ti[k]);
						int qscore = Integer.valueOf(tq[k]);
						if(iscore<qscore)continue loop;
					}
				}
				cnt++;
			}
			answer[i]=cnt;
		}
        return answer;
    }
	public void print(int[] arr) {
		for(int i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
