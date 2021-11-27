package test.study;

import java.util.ArrayList;
import java.util.Arrays;

public class num2 {
	public static void main(String[] args) {
		int[] arr= {0, 1, 2, 5, 3, 7}; //3
//		int[] arr= {1, 2, 3, 2, 1}; //4
//		int[] arr= {1, 2, 3, 2, 1, 4, 3, 2, 2, 1}; //6
//		int[] arr= {1, 2, 1, 2, 1}; //2
		
		System.out.println(new num2().solution(arr));
	}
	public int solution(int[] arr) {
        int answer = 0;
        int n = arr.length;
        for(int i=0;i<n;i++) {
        	for(int j=i;j<=n;j++) {
        		if(j-i<3)continue;
        		int[] tmp = Arrays.copyOfRange(arr, i,j);
//        		print(tmp);
        		if(isAShape(tmp)) {
//        			System.out.println("---------");
        			answer=(answer+1)%(1000000000+7);
        		}
        	}
        }
        return answer;
    }
	public boolean isAShape(int[] arr) {
		ArrayList<Integer> dir = new ArrayList<Integer>();
		int dir2=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]<arr[i+1]) {
				if(dir2<=0)dir.add(1);
				dir2=1;
			}
			else if(arr[i]>arr[i+1]) {
				if(dir2>=0)dir.add(-1);
				dir2=-1;
			}
			else {
				if(dir2!=0)dir.add(0);
				dir2=0;
			}
		}
		return dir.size()==2&&dir.get(0)==1;
	}
	public void print(int[] arr) {
		for(int i : arr)System.out.print(i+ " ");
		System.out.println();
	}
}
