package test.study;

import java.util.ArrayList;

public class num1 {
	public static void main(String[] args) {
//		String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"};
//		String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
		String[] record = {"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"};
		
		new num1().solution(record);
	}
	class Node{
		int price;
		int cnt;
		int idx;
		public Node(int price, int cnt, int idx) {
			this.price=price;
			this.cnt=cnt;
			this.idx=idx;
		}
	}
	public int[] solution(String[] record) {
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		int front =0;
		int back = 0;
		for(int i=0;i<record.length;i++) {
			if("P".equals(record[i].split(" ")[0])){
				for(int j=0;j<Integer.valueOf(record[i].split(" ")[2]);j++) {
					f.add(Integer.valueOf(record[i].split(" ")[1]));
					b.add(Integer.valueOf(record[i].split(" ")[1]));
				}
			}
			if("S".equals(record[i].split(" ")[0])){
				for(int j=0;j<Integer.valueOf(record[i].split(" ")[2]);j++) {
					front+=f.remove(0);
				}
				for(int j=0;j<Integer.valueOf(record[i].split(" ")[2]);j++) {
					back+=b.remove(b.size()-1);
				}
			}
		}
		System.out.println("front:"+front+" back:"+back);
        int[] answer = {front, back};
        return answer;
    }
	public void print(int [] arr) {
		for(int i: arr)System.out.print(i+" ");
		System.out.println();
	}
}
