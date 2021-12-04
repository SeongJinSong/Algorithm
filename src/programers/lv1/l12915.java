package programers.lv1;

import java.util.Arrays;

public class l12915 {
	public static void main(String[] args) {
//		String[] strings= {"sun", "bed", "car"}; int n=1;
		String[] strings= {"abce", "abcd", "cdx"}; int n=2;
		new l12915().print(new l12915().solution(strings, n));
	}
	public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b)->{
        	if(a.charAt(n)==b.charAt(n)) {
        		return a.compareTo(b);
        	}else return a.charAt(n)-b.charAt(n);
        });
        return strings;
    }
	public void print(String[] arr) {
		for(String s : arr)System.out.print(s+" ");
		System.out.println();
	}
}
