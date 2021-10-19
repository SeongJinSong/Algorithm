package programers.lv1;

public class l72410 {
	public static void main(String[] args) {
//		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = "z-+.^.";
//		String new_id = "=.=";
//		String new_id = "123_.def";
//		String new_id = "abcdefghijklmn.p";
		String new_id = "b";		
		System.out.println(solution(new_id));
	}
	public static String solution(String new_id) {
        return lv7(lv6(lv5(lv4(lv3(lv2(lv1(new_id)))))));
    }
	public static String lv1(String new_id) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<new_id.length();i++) {
			if(new_id.charAt(i)>=65&&new_id.charAt(i)<=90) {
				sb.append((char)(new_id.charAt(i)+32));
				continue;
			}
			sb.append(new_id.charAt(i));
		}
		return sb.toString();
	}
	public static String lv2(String new_id) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<new_id.length();i++) {
			if(new_id.charAt(i)>=65&&new_id.charAt(i)<=90) {
				sb.append(new_id.charAt(i));
			}
			else if(new_id.charAt(i)>=97&&new_id.charAt(i)<=122) {
				sb.append(new_id.charAt(i));
			}
			else if(new_id.charAt(i)==45||new_id.charAt(i)==95||new_id.charAt(i)==46) {
				sb.append(new_id.charAt(i));
			}
			else if(new_id.charAt(i)>=48&&new_id.charAt(i)<=57) {
				sb.append(new_id.charAt(i));
			}
		}
		return sb.toString();
	}
	public static String lv3(String new_id) {
		if(new_id.length()<2) return new_id;
		StringBuilder sb = new StringBuilder();
		char prev = new_id.charAt(0);
		for(int i=1;i<new_id.length();i++) {
			if(prev=='.'&&new_id.charAt(i)=='.') {
				continue;
			}else {
				sb.append(prev);
				prev=new_id.charAt(i);
				if(i==new_id.length()-1)sb.append(new_id.charAt(i));
			}
		}
		return sb.toString();
	}
	public static String lv4(String new_id) {
		if(new_id.length()==0)return new_id;
		if(new_id.length()==1&&new_id.charAt(0)=='.')return "";
		if(new_id.charAt(0)=='.')new_id = new_id.substring(1);
		if(new_id.charAt(new_id.length()-1)=='.')new_id=new_id.substring(0, new_id.length()-1);
		return new_id;
	}
	public static String lv5(String new_id) {
		if(new_id.length()==0)return "a";
		return new_id;
	}
	public static String lv6(String new_id) {
		if(new_id.length()>15) {
			new_id= new_id.substring(0, 15);
		}
		if(new_id.charAt(new_id.length()-1)=='.') new_id=new_id.substring(0, new_id.length()-1);
		return new_id;
	}
	public static String lv7(String new_id) {
		if(new_id.length()>2)return new_id;
		char lastChar = new_id.charAt(new_id.length()-1);
		StringBuilder sb = new StringBuilder(new_id);
		while(sb.length()<3) {
			sb.append(lastChar);
		}
		return sb.toString();
	}
}
