package programers.lv1;

import java.util.Arrays;

public class l12935 {
	public static void main(String[] args) {
		int[] arr= {4,3,2,1};
		new l12935().print(new l12935().solution(arr));
	}
	public int[] solution(int[] arr) {
		if(arr.length==1)return new int[] {-1};
		int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i->i!=min).toArray();
    }
	public void print(int[] arr) {
		for(int i: arr)System.out.print(i+" ");
		System.out.println();
	}
}
