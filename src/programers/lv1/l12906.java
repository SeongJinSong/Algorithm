package programers.lv1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class l12906 {
	public static void main(String[] args) {
//		int[] arr= {1,1,3,3,0,1,1};
		int[] arr= {4,4,4,3,3};
		new l12906().print(new l12906().solution(arr));
	}
	public int[] solution(int []arr) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int prev = arr[0];
		a.add(prev);
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==prev) {
				continue;
			}
			else {
				prev=arr[i];
				a.add(prev);
			}
		}
		return a.stream().mapToInt(i->i).toArray();
	}
	public int[] solution_(int []arr) {
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
        for(int i:arr)hs.add(i);
        int[] answer = new int[hs.size()];
        Iterator<Integer> it = hs.iterator();
        int idx=0;
        while(it.hasNext()) {
        	answer[idx++]=it.next();
        }
        return answer;
    }
	public void print(int[] arr) {
		for(int i : arr) System.out.print(i+" ");
		System.out.println();
	}
}
