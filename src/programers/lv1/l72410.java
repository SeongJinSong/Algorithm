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
	/* 정규표현식을 사용한 풀이 추가	
	 * 막상 이게 더 실수가 많을 것 같아 불안해서 직접 했는데 막상 보니 이게 더 쉬운것 같다.
	 * 비슷한 유형인 경우 정규표현식으로 풀도록 하자*/
	public String solution2(String new_id) {
		String temp = new_id.toLowerCase();
		
		temp = temp.replaceAll("[^-_.a-z0-9]", "");
		temp = temp.replaceAll("[.]{2,}", ".");
		temp = temp.replaceAll("^[.]|[.]$", "");
		if(temp.equals(""))temp+="a";
		if(temp.length()>=16) {
			temp=temp.substring(0,15);
			temp=temp.replaceAll("^[.]|[.]$","");
		}
		if(temp.length()<=2)
			while(temp.length()<3)
				temp+=temp.charAt(temp.length()-1);
		return temp;
	}
	/*자바스럽게 구현하기*/
	public String solution3(String new_id) {
		return new KAKAOID(new_id)
					.replaceToLowerCase()
					.filter()
					.toSingleDot()
					.noStartEndDot()
					.noBlank()
					.noGreaterThan16()
					.noLessThan2()
					.getResult();
	}
	public static class KAKAOID{
		private String s;
		public KAKAOID(String s) {
			this.s=s;
		}
		private KAKAOID replaceToLowerCase() {
			s=s.toLowerCase();
			return this;
		}
		private KAKAOID filter() {
			s = s.replaceAll("[^a-z0-9._-]", "");
			return this;
		}
		private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }
		private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }
		private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }
		private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }
		private KAKAOID noLessThan2() {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() <= 2) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            s=sb.toString();
            return this;
        }
		private String getResult() {
            return s;
        }
	}
}
