package programers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;

public class l67257 {
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
//		String expression = "50*6-3*2";
		
		System.out.println(new l67257().solution2(expression));
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
	class Operate{
		char op;
		int front;
		int back;
		public Operate(char op, int front, int back) {
			this.op=op;
			this.front=front;
			this.back=back;
		}
		public void setFront(int front) {
			this.front=front;
		}
		public void setBack (int front) {
			this.front=front;
		}
	}
	public String replaceChar(char c, String expression) {
		LinkedList<Operate> op = new LinkedList<Operate>();
		LinkedList<Integer> num = new LinkedList<Integer>();
		for(int i=0;i<expression.length();i++) {
			if(c==expression.charAt(i)) {
				int fIdx = getFront(expression, i);
				int bIdx = getBack(expression, i);
				int len = expression.length();
				int f1 = Integer.valueOf(expression.substring(fIdx, i));
				int b1 = Integer.valueOf(expression.substring(i+1, bIdx>len?len:bIdx));
				
			}
		}
		return null;
	}
	/*이 풀이는 양옆으로 같은 부호를 끼고 있는 경우 문제가 된다ㅜ*/
	public String replace(char c, String expression) {
		if(expression.indexOf(c)==-1)return expression;
		StringBuilder sb = new StringBuilder();
		int lastbIdx=0;
		for(int i=0;i<expression.length();i++) {
			if(c==expression.charAt(i)) {
				System.out.println("c:"+c+" i:"+i+" lastbIdx:"+lastbIdx);
				int fIdx = getFront(expression, i);
				int bIdx = getBack(expression, i);
				System.out.println("fIdx:"+fIdx+" bIdx:"+bIdx);
				if(lastbIdx<fIdx)
					sb.append(expression.substring(lastbIdx, fIdx));
				System.out.println("ex:"+expression+" i:"+i+" fIdx:"+fIdx+" bIdx:"+bIdx);
				System.out.println("##:"+calc(c, expression, i, fIdx, bIdx+1));
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
	// 시간내에 풀려다 보니 맘이 급해져서 이렇게 되었다.
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
	///////////////////////////////////////////////////////////////////
	public static long answer = Long.MIN_VALUE;
	
	public static ArrayList<Long> numList = new ArrayList<>(); // 숫자 담을 리스트 
	public static ArrayList<String> operList = new ArrayList<>(); // 연산자 담을 리스트 
	
	public static String[] oper = {"+", "-", "*"};
	public static String[] output = new String[3]; // 순열 결과 담을 배열 
	public static boolean[] visited = new boolean[3]; 


	public static long solution2(String expression) {
		String n = "";
		for(int i = 0; i < expression.length(); i++) {
			char exp = expression.charAt(i);
			if(exp == '+' || exp == '-' || exp == '*') {
				// 연산자랑 숫자 리스트 분리해야함 음수 계산의 경우가 있기 때문 
				operList.add(exp + "");
				numList.add(Long.parseLong(n));
				n = "";
			} else {
				n += exp;
			}
		}  
		// 마지막 숫자 삽입 
		numList.add(Long.parseLong(n));
	
		//순열 만들기
		per(0, oper.length);
		
		return answer;
	}

	//순열 찾기
	static void per(int depth, int r) {
		if(depth == r) {
			solve(); // 연산 
		
			return;
		}

		for(int i = 0; i < oper.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = oper[i];
				per(depth + 1, r);  
				visited[i] = false;
			}
		}
	}

	// 연산 
	static void solve() {
		// 연산자 우선 순위에 따른 값을 얻기 위해 List 복사 
		ArrayList<String> oper = new ArrayList<String>();
		oper.addAll(operList);
		
		ArrayList<Long> num = new ArrayList<Long>();
		num.addAll(numList);
		
		for(int i = 0; i < output.length; i++) {
			String curOper = output[i]; // 현재 우선순위 연산자 
			
			for(int j = 0; j < oper.size(); j++) {
				
				if(oper.get(j).equals(curOper)) { // 현재 우선순위에 맞는 연산자일 경우 
					long n1 = num.get(j);
					long n2 = num.get(j+1);
					long res = cal(n1, n2, curOper);
					
				
					num.remove(j+1); // 숫자 삭제 
					num.remove(j);
					oper.remove(j); // 연산자 삭제 
					
	
					num.add(j, res); // 연산 결과 넣기 
			
					j--; // 삭제했으니 인덱스 하나 줄여주기 
				}
			}
		}
		
		answer = Math.max(answer, Math.abs(num.get(0)));
	}
	
	// 수식 계산 
	static long cal(long n1, long n2, String o) {
		long res = 0;
		switch(o) {
		case "+" :
			res = n1 + n2;
			break;
		case "-" :
			res = n1 -n2;
			break;
		case "*" :
			res = n1 * n2;
			break;
		}
		return res;
	}
}
