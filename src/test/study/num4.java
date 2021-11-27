package test.study;

import java.util.Arrays;

public class num4 {
	public static void main(String[] args) {
		int[][] rectangles= {{0,2,1,3},{1,2,2,5},{3,3,4,4},{4,1,6,3},{1,6,5,7},{5,5,7,6},{5,8,6,10}};
		//"0 0 1 1", "1 0 2 3", "2 0 3 1", "3 0 5 2", "0 3 4 4", "2 2 4 3", "4 3 5 5"
		new num4().prints(new num4().solution(rectangles));
	}
	public String[] solution(int[][] rectangles) {
		//높이가 낮은 순으로 정렬한다.
		Arrays.sort(rectangles, (a,b)->a[3]-b[3]);
		
		//높이가 높은 것들중에서 겹치는 것들이 있으면 겹치는 것의 최대 높이로 이동한다.
		for(int i=0;i<rectangles.length;i++) {
			int maxHeight=0;
			// 아래 있는 것 j
			for(int j=0;j<i;j++) {
				if(rectangles[i][0]<rectangles[j][2]&&rectangles[j][2]<rectangles[i][2]) {
					if(maxHeight<rectangles[j][3]) {
						maxHeight=rectangles[j][3];
						System.out.println("1 i:"+i+" j:"+j+" maxH:"+maxHeight);
					}
				}else if(rectangles[j][0]<rectangles[i][2]&&rectangles[i][2]<rectangles[j][2]) {
					if(maxHeight<rectangles[j][3]) {
						maxHeight=rectangles[j][3];
						System.out.println("2 i:"+i+" j:"+j+" maxH:"+maxHeight);
					}
				}
			}
			int a = rectangles[i][1];
			rectangles[i][1]-=a+maxHeight;
			rectangles[i][3]-=a+maxHeight;
		}
		String[] r1 = new String[rectangles.length];
		for(int i=0;i<rectangles.length;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<4;j++) {
        		sb.append(rectangles[i][j]);
        		if(j!=3)sb.append(" ");
        	}
        	r1[i]=sb.toString();
        }
		prints(r1);
		System.out.println();
		Arrays.sort(rectangles, (a, b)->a[2]-b[2]);
		for(int i=0;i<rectangles.length;i++) {
			int maxWidth=0;
			// 왼쪽에 있는게 j
			for(int j=0;j<i;j++) {
				if(rectangles[i][1]<=rectangles[j][3]&&rectangles[j][3]<=rectangles[i][3]) {
					if(maxWidth<rectangles[j][2]) {
						maxWidth=rectangles[j][2];
					}
				}else if(rectangles[j][1]<=rectangles[i][3]&&rectangles[i][3]<=rectangles[j][3]) {
					if(maxWidth<rectangles[j][2]) {
						maxWidth=rectangles[j][
						                       2];
					}
				}
			}
			int a =rectangles[i][2];
			rectangles[i][0]-=a+maxWidth;
			rectangles[i][2]-=a+maxWidth;
		}
        String[] answer = new String[rectangles.length];
        for(int i=0;i<rectangles.length;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<4;j++) {
        		sb.append(rectangles[i][j]);
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
