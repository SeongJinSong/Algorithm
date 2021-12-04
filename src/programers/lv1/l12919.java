package programers.lv1;

import java.util.Arrays;

public class l12919 {
	public static void main(String[] args) {
		String[] seoul= {"Jane", "Kim"};
		System.out.println(new l12919().solution(seoul));
	}
	public String solution(String[] seoul) {
        for(int i=0;i<seoul.length;i++) {
        	if("Kim".equals(seoul[i])) {
        		return "김서방은 "+i+"에 있다";
        	}
        }
        return "";
    }
	public String solution2(String[] seoul) {
		int x = Arrays.asList(seoul).indexOf("Kim");
		return "김서방은 "+x+"에 있다";
	}
}
