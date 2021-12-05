package programers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l72412 {
	public static void main(String[] args) {
		String[] info= {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query= {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		new l72412().print(new l72412().solution2(info, query));
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
		Collections.sort(iarr, (a,b)->Integer.valueOf(a[4])-Integer.valueOf(b[4]));
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
	Map<String, ArrayList<Integer>> allInfo;
	ArrayList<Integer> in;
	public int[] solution2(String[] info, String[] query) {
		int[] answer = new int[query.length];
		allInfo = new HashMap<>();
		
		//1. Info 모든 경우의 수 map에 저장
		for(int i=0;i<info.length;i++) {
			dfs("",0,info[i].split(" "));
		}
		
		//2. map에 저장된 점수 list 오름차순으로 정렬
		List<String> list = new ArrayList<>(allInfo.keySet());
		for(int i=0;i<list.size();i++) {
			List<Integer> scoreList = allInfo.get(list.get(i));
			Collections.sort(scoreList);
		}
		
		//3.query확인
		for(int i=0;i<query.length;i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] str = query[i].split(" ");
			int score = Integer.parseInt(str[1]);
			
			answer[i]=search(str[0], score);
		}
		return answer;
	}
	public void dfs(String pos, int depth, String[] info) {
		if(depth==4) {
			if(!allInfo.containsKey(pos)) {
				in = new ArrayList<>();
				in.add(Integer.parseInt(info[4]));
				allInfo.put(pos, in);
			}else {
				allInfo.get(pos).add(Integer.parseInt(info[4]));
			}
			return;
		}
		dfs(pos+"-", depth+1, info);
		dfs(pos+info[depth],depth+1, info);
	}
	public int search(String str, int score) {
		if(!allInfo.containsKey(str))return 0;
		List<Integer> scoreList = allInfo.get(str);
		int start = 0, end = scoreList.size()-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(scoreList.get(mid) < score) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return scoreList.size()-start;
	}
	////////////////////////////////////////////////
	public int[] solution3(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();
		for(String in : info) {
			String[] infoArr = in.split(" ");
			comb("",0,infoArr);
		}
		int queryIdx = 0;
		for(String q : query) {
			String str = q.replace(" and ", "");
			String[] tmp = str.split(" ");
			Collections.sort(map.get(tmp[0]));
			answer[queryIdx++]=binarySearch(tmp[0], Integer.parseInt(tmp[1]));
		}
		return answer;
	}
	HashMap<String, ArrayList<Integer>> map;
	void comb(String str, int depth, String[] arr) {
		if(depth==4) {
			int score = Integer.parseInt(arr[4]);
			if(map.containsKey(str))map.get(str).add(score);
			else {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(score);
				map.put(str, tmp);
			}
			return;
		}
		comb(str+"-",depth+1,arr);
		comb(str+arr[depth],depth+1,arr);
	}
	int binarySearch(String query, int score) {
		if(!map.containsKey(query))return 0;
		ArrayList<Integer> tmpList = map.get(query);
		int start=0, end=tmpList.size()-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(score > tmpList.get(mid))start=mid+1;
			else end = mid-1;
		}
		return tmpList.size()-start;
	}
}
