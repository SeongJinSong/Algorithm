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
	//����Լ����� for���� ����Ͽ� �׻� ���ϴ� ��츦 ����ߴ�
	//�ε����� ������Ű�鼭 ���ϰų�, ������ �ʰų��� �ϸ� for���� ������� ���� �� �ִ�.
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
	//���ϰų� ������ �ʰų��� ����! 
	public static void go2(int mo, int ja, int len, int idx, int n, String str, char[] c) {
		if(len>n) return;
		//if(idx>=c.length)return; 
		/*�̰� ����� �ּ� ��¸� �ϴ� ���� ��찡 �߻��ߴ�.
		�ε��� üũ ��ġ�� �����ϰ� �����ؾ� �Ѵ�.*/
		if(mo>=1&&ja>=2&&len==n) {
			System.out.println(str);
			return;
			/*����Լ��� ���ϰų� �������ʰų��� �����ϴ� ���
			����ϰ� return�� ���� ������ ������ �ʴ� ���ȣ�⶧ �ߺ������ �ȴ�.*/
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
