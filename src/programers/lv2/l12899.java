package programers.lv2;

public class l12899 {
	public static void main(String[] args) {
		System.out.println(new l12899().solution2(7));
	}
	public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int x = n-4;
        get3(x, sb);
        StringBuilder sb2 = new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--) {
        	sb2.append(sb.charAt(i));
        	//sb2.append(convert(sb.charAt(i)));
        }
        return sb2.toString();
    }
	public void get3(int n, StringBuilder sb) {
		if(n<3) {
			sb.append(n);
			return;
		}
		if(n>=3)sb.append(n%3);
		get3(n/3, sb);
	}
	public char convert(char c) {
		switch(c) {
		case '0':
			return '1';
		case '1':
			return '2';
		case '2':
			return '4';
		}
		return 'e';
	}
	public String solution2(int n) {
		String answer = "";
		int cn = n;
		while(cn>0) {
			if(cn%3==0) {
				answer="4"+answer;
				cn--; //나누어 떨어질 경우 자릿수 바뀜
			}
			else if(cn%3==1) {
				answer = "1"+answer;
			}
			else {
				answer = "2" + answer;
			}
			cn /=3;
		}return answer;
	}
	// best solution
	public String solution3(int n) {
		String[] num = {"4", "1", "2"};
		StringBuilder sb = new StringBuilder();
		
		while(n>0) {
			sb.insert(0, num[n%3]);
			//자릿수가 바뀌는 경우를 막기위해 1을 빼줘야 한다.
			n=(n-1)/3; // 어짜피 3으로 나눌때 나머지 1,2 쯤이야 영향이 없다.
		}
		return sb.toString();
	}
}
