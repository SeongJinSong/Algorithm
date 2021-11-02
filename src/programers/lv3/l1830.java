package programers.lv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class l1830 {
	public static void main(String[] args) {
//		String sentence = "HaEaLaLaObWORLDb";
//		String sentence = "SpIpGpOpNpGJqOqA";
//		String sentence = "AxAxAxAoBoBoB";
//		String sentence = "AbAaAbAaCa"; //invalid
//		String sentence = "aIaAM";
//		String sentence = "AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR";
//		String sentence = "aaA";
//		String sentence = "Aaa";
//		String sentence = "aHELLOWORLDa";
//		String sentence = "HaEaLaLObWORLDb";
//		String sentence = "HaEaLaLaObWORLDb";
//		String sentence = "aHbEbLbLbOacWdOdRdLdDc";
//		String sentence = "abAba";
//		String sentence = "HELLO WORLD";
//		String sentence = "xAaAbAaAx"; // rule2 중복 체크
//		String sentence = "AbAaAbAaCa";
		String sentence = "AbAaAbAaC"; // rule2 중복 체크
//		System.out.println(new l1830().restoreRule2(sentence, 'a'));
		System.out.println(new l1830().solution(sentence));
		
	}
	String err = "invalid";
	ConcurrentHashMap<Integer, String> hm2;
	public String solution(String sentence) {
		/* 1. 띄어쓰기 case insert
		 * 규칙 2 확인
		 * 	처음부터 끝까지 검사했을때 2개만 있는지 invalid 체크
		 * 규칙 1 확인
		 *  대문자 다음부터 마지막 안까지 듬성듬성 있는지 invalid 체크
		 * 띄어쓰기 케이스 --> 규칙 12는 규칙2와 같다.
		 *   규칙1 + 규칙1 	: HaEaLWbLbD >> 서로다른 소문자 사이에 대문자 2개
		 *   규칙2 + 규칙2 	: aHELabWLDb  >> 소문자 연속
		 *   규칙1 + 규칙2 	: HaEaLbWLDb >> 대문자 양옆에 서로다른 소문자
		 *   규칙2 + 규칙1 	: aHELaWbLbD  >> 대문자 양옆에 서로다른 소문자
		 *   규칙12 + 규칙12 	: aHbEbLacWdLdDc >> 소문자 연속
		 *   규칙12 + 규칙1 	: aHbEbLaWcLcD >> 대문자 양옆에 서로다른 소문자
		 *   
		 *   크게 규칙 2먼저 체크하고 규칙 2 다음에는 띄어쓰기 한다.(마지막 문자인 경우는 안함)
		 *   규칙1 + 규칙1 	: HaEaLWbLbD >> 서로다른 소문자 사이에 대문자 2개
		 *   규칙2 + 규칙2 	: aHELa bWLDb  >> 해결
		 *   규칙1 + 규칙2 	: HaEaLbWLDb >> 대문자 양옆에 서로다른 소문자
		 *   규칙2 + 규칙1 	: aHELa WbLbD  >> 해결
		 *   
		 */ 
		String tmp = sentence;
		if(sentence.contains(" "))return err;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i<sentence.length();i++) {
			if(checkmini(sentence.charAt(i))){
				hm.put((int)sentence.charAt(i), hm.getOrDefault((int)sentence.charAt(i), 0)+1);
			}
		}
		hm2 = new ConcurrentHashMap<Integer, String>();
		for(int i : hm.keySet()) {
			if(hm.get(i)==2) {
				tmp=restoreRule2(tmp, (char)i);
				if(err.equals(tmp))return err;
			}
		}
//		System.out.println("1 tmp:"+tmp);
		for(int i: hm.keySet()) {
			if(hm.get(i)!=2) {
				tmp=restoreRule1(tmp, (char)i);
				if(err.equals(tmp))return err;
			}
		}
//		System.out.println("2 tmp:"+tmp);
        return tmp;
    }
	//연속된 소문자 케이스에만 띄어쓰기를 적용한다.
	public String insertSpace(String sentence) {
		for(int i=1;i<sentence.length()-1;i++) {
			
		}
		return "";
	}
	public boolean checkmini(char c) {
		if(c>=97&&c<=122)return true;
		return false;
	}
	public String restoreRule(String sentence, char c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<sentence.length();i++) {
			if(!checkmini(sentence.charAt(i)))sb.append(sentence.charAt(i));
		}
		return sb.toString();
	}
	public String restoreRule1(String sentence, char c) {
		int start = sentence.indexOf(c);
		int end = sentence.lastIndexOf(c)+1;
		boolean toggle = true;
		StringBuilder sb = new StringBuilder();
//		System.out.println("start:"+start+" sentence.charAt(start-1):"+sentence.charAt(start-1));
		if(start>0&&' '==sentence.charAt(start-1))return err;
		
		for(int i=start; i<=end;i++) {
			if(toggle&&c==sentence.charAt(i)) {
				toggle=!toggle;
				continue;
			}
			else if(!toggle&&c!=sentence.charAt(i)) {
				toggle=!toggle;
				sb.append(sentence.charAt(i));
			}
			else {
//				System.out.println("rule1 err");
				return err;
			}
		}
//		System.out.println("end:"+end+" sentence.len:"+sentence.length());
		String s = sentence.substring(0, start-1)
				+((start>1&&' '!=sentence.charAt(start-2))?" ":"")
				+sentence.charAt(start-1)
				+sb.toString()
				+(end==sentence.length()-1||' '==sentence.charAt(end+1)?"":" ")
				+sentence.substring(end+1, sentence.length());
//		System.out.println("s:"+s);
		return s;
	}
	public String restoreRule2(String sentence, char c) {
		System.out.println("rule2 char:"+c+" sentence:"+sentence);
		int spaceCnt=0;
		for(int i=0;i<sentence.length();i++) {
			if(sentence.charAt(i)==' ')spaceCnt++;
		}
		int start = sentence.indexOf(c);
		int end = sentence.lastIndexOf(c);
		if(hm2.isEmpty()) {
			System.out.println("isEmpty start:"+ start+" end:"+end);
			hm2.put((int)c, start+" "+end);
		}
		else {
			for(int i:hm2.keySet()) {
				System.out.println("i:"+i);
				int tmpStart = Integer.valueOf(hm2.get(i).split(" ")[0]);
				int tmpEnd = Integer.valueOf(hm2.get(i).split(" ")[1]);
				System.out.println("tmpStart:"+tmpStart+" end:"+end+" tmpEnd:"+tmpEnd+" start:"+start);
				if(tmpStart>end+spaceCnt||tmpEnd<start+spaceCnt)hm2.put((int)c, start+" "+end);
				else if(tmpStart==start&&tmpEnd==end) continue;
				else {
//					System.out.println("rule2 err");
					return err;
				}
			}
		}
		if(start==end-1)return err;
		StringBuilder sb = new StringBuilder();
		sb.append(sentence.substring(0, start));
		if(start>0&&' '!=sentence.charAt(start-1))sb.append(' ');
		sb.append(sentence.substring(start+1, end));
		if(end!=sentence.length()-1) {
			sb.append(" ");
		}
		sb.append(sentence.substring(end+1, sentence.length()));
		return sb.toString();
	}
	public String solution2(String sentence) {
		String invalid = "invalid";
		try {
			/*기호 종류, 위치 파악*/
			char s[]=sentence.toCharArray(), ch;
			int l = s.length, i;
			LinkedHashMap<Character, List<Integer>> hm = new LinkedHashMap<>();
			for(i=0;i<l;i++) {
				ch=s[i];
				if(ch>='a' && ch<='z') {
					if(!hm.containsKey(ch)) hm.put(ch, new ArrayList<>());
					hm.get(ch).add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			int iss=0, isw=0, iew=0, iswp = -1, iewp = -1, isc, iec, iscp=-1, iecp=-1, n,d,r=0;
			List<Integer> ps;
			for(char c : hm.keySet()) {
				ps = hm.get(c);
				n = ps.size();
				isc = ps.get(0);
				iec = ps.get(n-1);
				if(n==1 || n>=3) {
					for(i=1;i<n;i++)
						if(ps.get(i)-ps.get(i-1)!=2) return invalid;
				}else if(n==2) {
					d = iec-isc;
					if(d==2&&(iscp < isc && iec <iecp)) r=1;
					else if(d>=2) r=2;
					else return invalid;
				}
				
				if(r==1) {
					isw = isc-1;
					iew = iec+1;
					if(iswp < isw && iew < iewp) {
						if(isc - iscp ==2 && iecp -iec ==2) continue;
						else return invalid;
					}
				}
				else if(r==2) {
					isw = isc;
					iew = iec;
					if(iswp < isw && iew < iewp) return invalid;
				}
				
				if(iewp >= isw) return invalid;
				if(iss < isw) sb.append(getStr(s, iss, isw -1)+" ");
				sb.append(getStr(s, isw, iew)+ " ");
				iswp = isw;
				iewp = iew;
				iscp = isc;
				iecp = iec;
				iss = iew+1;
			}
			if(iss<1) sb.append(getStr(s, iss, l-1));
			String str = sb.toString();
			return str.trim();
		}catch(Exception e) {
			return invalid;
		}
	}
	public String getStr(char s[], int is, int ie) {
		StringBuilder sb = new StringBuilder();
		char c;
		for(int i=is; i<=ie; ++i) {
			c=s[i];
			if(c>='A' && c<='Z') sb.append(c);
		}
		return sb.toString();
	}
}
