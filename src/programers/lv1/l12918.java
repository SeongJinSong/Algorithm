package programers.lv1;

public class l12918 {
	public static void main(String[] args) {
		String s = "1234";
		System.out.println(new l12918().solution4(s));
	}
	public boolean solution(String s) {
		if(s.length()!=4&&s.length()!=6)return false;
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)<'0'||s.charAt(i)>'9')return false;
        }
        return true;
    }
	// try, catch를 이용할 수 있다.
	// 이펙티브 자바 예외처리 관련된 항목에서 금기시 되는 풀이 >> 예외는 실제 예외 상황일때만 사용하라
	public boolean solution2(String s) {
		if(s.length()!=4&&s.length()!=6)return false;
		try {
			int x = Integer.parseInt(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	public boolean solution3(String s) {
		if(s.length()!=4&&s.length()!=6)return false;
		return s.matches("(^[0-9]*$)");
	}
	public boolean solution4(String s) {
		//스트링이 숫자로만 구성되어 있으면 split 정규표현식에 의해 [] 가 리턴된다. 
	    return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
	  }
}
