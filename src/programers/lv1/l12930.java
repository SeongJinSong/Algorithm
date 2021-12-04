package programers.lv1;

import java.util.Arrays;

public class l12930 {
	public static void main(String[] args) {
		String s = "try hello world";
		System.out.println(new l12930().solution(s));
	}
	public String solution(String s) {
        String[] arr = s.split(" ", -1);
        for(int i=0;i<arr.length;i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0;j<arr[i].length();j++) {
        		if(j%2==0) {
        			sb.append(((arr[i].charAt(j)+"").toUpperCase()));
        		}else {
        			sb.append(((arr[i].charAt(j)+"").toLowerCase()));
        		}
        	}
        	arr[i]=sb.toString();
        }
        return Arrays.stream(arr).reduce((a,b)->a+" "+b).orElse("");
    }
}
