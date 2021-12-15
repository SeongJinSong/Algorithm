package test.study3;

import java.util.ArrayList;
import java.util.Arrays;

public class num2 {
	public static void main(String[] args) {
		//ip가 String으로 주어졌을 때 해결하기
		 String s="25525512112";
		// .을 찍어서 모든 경우의 수의 String Return값을 출력하기
		//"255.255.121.12", "255.255.12.112"
		 solution(s);
	}
	public static ArrayList<String> solution(String s){
		int n = s.length();
		char[] res = new char[2*n-1];
		for(int i=0;i<n;i++) {
			res[i*2]=s.charAt(i);
		}
		
		System.out.println();
		return null;
	}
	public static void comb(int n, int r, int depth) {
		
	}
	public static void print(ArrayList<String> list) {
		for(String s: list)System.out.print(s+" ");
		System.out.println();
	}
}

