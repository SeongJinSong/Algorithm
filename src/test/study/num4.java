package test.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class num4 {
	public static void main(String[] args) {
		int[][] rectangles= {{0,2,1,3},{1,2,2,5},{3,3,4,4},{4,1,6,3},{1,6,5,7},{5,5,7,6},{5,8,6,10}};
		//"0 0 1 1", "1 0 2 3", "2 0 3 1", "3 0 5 2", "0 3 4 4", "2 2 4 3", "4 3 5 5"
		String[] answer = new num4().solution(rectangles);
		new num4().prints(answer);
		System.out.println();
	}
	class Shape{
		int seq;
		int[] rectangles;
		public Shape(int seq, int[] rectangles) {
			this.seq=seq;
			this.rectangles=rectangles;
		}
	}
	public String[] solution(int[][] rectangles) {
		ArrayList<Shape> arr = new ArrayList<Shape>();
		for(int i=0;i<rectangles.length;i++) {
			arr.add(new Shape(i, rectangles[i]));
		}
		//시작 높이가 낮은 순으로 정렬한다.
		Collections.sort(arr, (a,b)->a.rectangles[1]-b.rectangles[1]);
		//높이가 높은 것들중에서 겹치는 것들이 있으면 겹치는 것의 최대 높이로 이동한다.
		for(int i=0;i<arr.size();i++) {
			int maxHeight=0;
			// 아래 있는 것 j
			for(int j=0;j<i;j++) {
				if(!(arr.get(i).rectangles[2]<=arr.get(j).rectangles[0]||arr.get(i).rectangles[0]>=arr.get(j).rectangles[2])) {
					maxHeight=maxHeight>arr.get(j).rectangles[3]?maxHeight:arr.get(j).rectangles[3];
				}
			}
			int a = arr.get(i).rectangles[1];
			arr.get(i).rectangles[1]-=a-maxHeight;
			arr.get(i).rectangles[3]-=a-maxHeight;
		}
		
		//시작 너비가 낮은 순으로 정렬한다.
		Collections.sort(arr, (a,b)->a.rectangles[0]-b.rectangles[0]);
//		for(int i=0;i<rectangles.length;i++) {
//			StringBuilder sb = new StringBuilder();
//			for(int j=0;j<4;j++) {
//				sb.append(rectangles[i][j]);
//				if(j!=3)sb.append(" ");
//			}
//			r1[i]=sb.toString();
//		}
//		prints(r1);
		for(int i=0;i<arr.size();i++) {
			int maxWidth=0;
			// 왼쪽에 있는게 j
			for(int j=0;j<i;j++) {
				if(!(arr.get(i).rectangles[3]<=arr.get(j).rectangles[1]||arr.get(i).rectangles[1]>=arr.get(j).rectangles[3])) {
					maxWidth=maxWidth>arr.get(j).rectangles[2]?maxWidth:arr.get(j).rectangles[2];
				}
			}
			int a =arr.get(i).rectangles[0];
			arr.get(i).rectangles[0]-=a-maxWidth;
			arr.get(i).rectangles[2]-=a-maxWidth;
		}
		
		Collections.sort(arr, (a,b)->a.seq-b.seq);
        String[] answer = new String[rectangles.length];
        for(int i=0;i<arr.size();i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<4;j++) {
        		sb.append(arr.get(i).rectangles[j]);
        		if(j!=3)sb.append(" ");
        	}
        	answer[i]=sb.toString();
        }
        return answer;
    }
	
	public void prints(String[] arr) {
		for(String s : arr)System.out.print(s+", ");
		System.out.println();
	}
}
