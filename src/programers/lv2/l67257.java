package programers.lv2;

public class l67257 {
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";
		
		System.out.println(new l67257().solution(expression));
	}
	public long solution(String expression) {
        long answer = 0;
        for(int i=0;i<6;i++) {
        	String temp = expression;
        	char[] carr = caseConfirm(i);
        	for(int j=0;j<3;j++) {
        		temp=replace(carr[j], temp);
        	}
        	answer=Math.max(answer, Math.abs(Integer.valueOf(temp)));
        }
        return answer;
    }
	public String replace(char c, String expression) {
		if(expression.indexOf(c)==-1)return expression;
		StringBuilder sb = new StringBuilder();
		int lastbIdx=0;
		for(int i=0;i<expression.length();i++) {
			if(c==expression.charAt(i)) {
				System.out.println("c:"+c+" i:"+i);
				int fIdx = getFront(expression, i);
				int bIdx = getBack(expression, i);
				sb.append(expression.substring(lastbIdx, fIdx));
				sb.append(calc(c, expression, i, fIdx, bIdx+1));
				System.out.println("bIdx: "+bIdx);
				i=bIdx+1;
				lastbIdx=i;
				i--;
				System.out.println(sb.toString());
			}
		}
		if(expression.length()>=lastbIdx)sb.append(expression.substring(lastbIdx));
		return sb.toString();
	}
	public String calc(char c, String expression, int i, int fIdx, int bIdx) {
		int len = expression.length();
		switch(c) {
		case '*':
			int f1 = Integer.valueOf(expression.substring(fIdx, i));
			int b1 = Integer.valueOf(expression.substring(i+1, bIdx>len?len:bIdx));
			return String.valueOf(f1*b1);
		case '+':
			int f2 = Integer.valueOf(expression.substring(fIdx, i));
			int b2 = Integer.valueOf(expression.substring(i+1, bIdx>len?len:bIdx));
			return String.valueOf(f2+b2);
		case '-':
			System.out.println("expression:"+expression+" fIdx:"+fIdx+" i:"+i+" bIdx:"+ bIdx);
			int f3 = Integer.valueOf(expression.substring(fIdx, i));
			int b3 = Integer.valueOf(expression.substring(i+1, bIdx>len?len:bIdx));
			return String.valueOf(f3-b3);
		}
		return null;
	}
	
	public int getFront(String s, int idx) {
		for(int i=idx-1;i>=0;i--) {
			if(s.charAt(i)<'0'||s.charAt(i)>'9')return i+1;
		}
		return 0;
	}
	public int getBack(String s, int idx) {
		for(int i=idx+1;i<s.length();i++) {
			if(s.charAt(i)<'0'||s.charAt(i)>'9')return i-1;
		}
		return s.length();
	}
	public char[] caseConfirm(int i) {
		switch(i) {
		case 0:
			char[] a = {'*', '+','-'};
			return a;
		case 1:
			char[] b = {'*', '-','+'};
			return b;
		case 2:
			char[] c = {'+', '*','-'};
			return c;
		case 3:
			char[] d = {'+', '-','*'};
			return d;
		case 4:
			char[] e = {'-', '*','+'};
			return e;
		case 5:
			char[] f = {'-', '+','*'};
			return f;
		}
		return null;
	}
}
