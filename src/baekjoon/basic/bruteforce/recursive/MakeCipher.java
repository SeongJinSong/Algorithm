package baekjoon.basic.bruteforce.recursive;

import java.util.Arrays;
import java.util.Scanner;
/*1759*/
public class MakeCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] c = new char[m];
		for(int i=0;i<m;i++) {
			c[i] = sc.next().charAt(0);
		}
		Arrays.sort(c);
		//go(0, 0, 0, 0, n,"", c);
		go2(0, 0, 0, 0, n,"", c);
	}
	//재귀함수에서 for문을 사용하여 항상 더하는 경우를 사용했다
	//인덱스만 증가시키면서 더하거나, 더하지 않거나로 하면 for문을 사용하지 않을 수 있다.
	public static void go(int mo, int ja, int len, int idx, int n, String str, char[] c) {
		if(len>n) return;
		if(mo>=1&&ja>=2&&len==n) System.out.println(str);
		for(int i=idx;i<c.length;i++) {
			if(c[i]=='a'||c[i]=='e'||c[i]=='i'||c[i]=='o'||c[i]=='u') {
				go(mo+1, ja, len+1, i+1, n, str+c[i], c);
			}
			else{
				go(mo, ja+1, len+1, i+1, n, str+c[i], c);
			}
		}
	}
	//더하거나 더하지 않거나로 구현! 
	public static void go2(int mo, int ja, int len, int idx, int n, String str, char[] c) {
		if(len>n) return;
		//if(idx>=c.length)return; 
		/*이걸 여기다 둬서 출력를 하다 마는 경우가 발생했다.
		인덱스 체크 위치를 신중하게 생각해야 한다.*/
		if(mo>=1&&ja>=2&&len==n) {
			System.out.println(str);
			return;
			/*재귀함수를 더하거나 더하지않거나로 구현하는 경우
			출력하고 return을 하지 않으면 더하지 않는 재귀호출때 중복출력이 된다.*/
		}
		if(idx>=c.length)return;
		if(c[idx]=='a'||c[idx]=='e'||c[idx]=='i'||c[idx]=='o'||c[idx]=='u') {
			go2(mo+1, ja, len+1, idx+1, n, str+c[idx], c);
			go2(mo, ja, len, idx+1, n, str, c);
		}else {
			go2(mo, ja+1, len+1, idx+1, n, str+c[idx], c);
			go2(mo, ja, len, idx+1, n, str, c);
		}
	}
}
