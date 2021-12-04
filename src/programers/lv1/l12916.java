package programers.lv1;

public class l12916 {
	public static void main(String[] args) {
//		String s="pPoooyY";
		String s="Pyy";
		System.out.println(new l12916().solution(s));
	}
	boolean solution(String s) {
		s=s.toLowerCase();
		int pcnt=0, ycnt=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='p')pcnt++;
			else if(s.charAt(i)=='y')ycnt++;
		}
		return pcnt==ycnt?true:false;
    }
	boolean solution2(String s) {
		s=s.toUpperCase();
		return s.chars().filter(e->'P'==e).count()==s.chars().filter(e->'Y'==e).count();
	}
}
