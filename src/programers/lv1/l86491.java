package programers.lv1;

import java.util.Arrays;

public class l86491 {
	public static void main(String[] args) {
//		int[][] sizes= {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int[][] sizes= {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
//		int[][] sizes= {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		
		System.out.println(new l86491().solution3(sizes));
	}
	public int solution(int[][] sizes) {
		for(int i=0;i<sizes.length;i++) {
			Arrays.sort(sizes[i]);
		}
		int maxw=0, maxh=0;
		for(int i=0;i<sizes.length;i++) {
			if(sizes[i][0]>maxw)maxw=sizes[i][0];
			if(sizes[i][1]>maxh)maxh=sizes[i][1];
		}
        return maxw*maxh;
    }
	public int solution2(int[][] sizes) {
		int length=0, height=0;
		for(int[] card : sizes) {
			length = Math.max(length, Math.max(card[0], card[1]));
			height = Math.max(height, Math.min(card[0], card[1]));
		}
		return length*height;
	}
	public int solution3(int[][] sizes) {
		return Arrays.stream(sizes).reduce((a, b)-> new int[] {
				Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])) , Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
		}).map(it->it[0]*it[1]).get();
	}
}
