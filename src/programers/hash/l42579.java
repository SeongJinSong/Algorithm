package programers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class l42579 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		print(solution(genres, plays));
	}
	public static int[] solution(String[] genres, int[] plays) {
        Integer[] idx = new Integer[genres.length];
        for(int i=0;i<idx.length;i++) {
        	idx[i]=i;
        }
        HashMap<String ,Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<genres.length;i++) {
        	hm.put(genres[i], hm.getOrDefault(genres[i], 0)+plays[i]);
        }
        String [] order = new String[hm.size()];
        Integer[] max = new Integer[hm.size()];
        int orderIndex=0;
        for(String key : hm.keySet()) {
        	order[orderIndex]= key;
        	max[orderIndex++] = hm.get(key);
        }
        for(int i=0;i<orderIndex;i++) {
        	for(int j=i+1;j<orderIndex;j++) {
        		if(max[i]<max[j]) {
        			swap(order, i, j);
        			swap(max, i, j);
        		}
        	}
        }
        Integer[] iplays = Arrays.stream(plays).boxed().toArray(Integer[]::new);
        for(int i=0;i<iplays.length;i++) {
        	for(int j=i+1;j<iplays.length;j++) {
        		if(iplays[i]<iplays[j]) {
        			swap(iplays, i, j);
        			swap(genres, i, j);
        			swap(idx, i, j);
        		}
        	}
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<orderIndex;i++) {
        	int cnt=0;
        	for(int j=0;j<genres.length;j++) {
        		if(cnt>=2)break;
        		if(order[i].equals(genres[j])) {
        			arr.add(idx[j]);
        			cnt++;
        		}
        	}
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
	public static<T> void swap(T[] arr, int i, int j) {
		T g = arr[i];
		arr[i] = arr[j];
		arr[j] = g;
	}
	public static void print(int[] arr) {
		for(int a:arr)System.out.print(a+" ");
	}
}
