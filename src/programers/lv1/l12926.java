package programers.lv1;

public class l12926 {
	public static void main(String[] args) {
		String s="AB"; int n=1;
		System.out.println(new l12926().solution2(s, n));
	}
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
        char[] a = s.toCharArray();
        for(int i=0;i<a.length;i++) {
        	if(a[i]>='A'&&a[i]<='Z') {
        		a[i]+=n;
        		if(a[i]>'Z') {
        			a[i]=(char) ('A'+(a[i]-'Z'-1));
        		}
        	}
        	else if(a[i]>='a'&&a[i]<='z') {
        		a[i]+=n;
        		if(a[i]>'z') {
        			a[i]=(char) ('a'+(a[i]-'z'-1));
        		}
        	}
        	sb.append(a[i]);
        }
        return sb.toString();
    }
	//n은 1 이상, 25이하인 자연수입니다. 라는 조건이 없었으면 이런식으로 풀었어야 했다.
	public String solution2(String s, int n) {
		String result="";
		n=n%26;
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(Character.isLowerCase(ch)) {
				ch = (char)((ch-'a'+n)%26+'a');
			}else if(Character.isUpperCase(ch)) {
				ch=(char)((ch-'A'+n)%26+'A');
			}
			result+=ch;
		}
		return result;
	}
	//char[] 배열도 스트링으로 만들 수 있다.
	public String solution3(String s, int n) {
		return s.chars().map(c->{
			int modn = n%26;
			if(c>='a' && c<='z') {
				return 'a'+(c-'a'+n)%26;
			}else if(c>='A'&&c<'Z') {
				return 'A'+(c-'A'+n)%26;
			}else {
				return c;
			}
		}).mapToObj(c->String.valueOf((char)c))
		  .reduce((a, b)->a+b).orElse("");
	}
}
