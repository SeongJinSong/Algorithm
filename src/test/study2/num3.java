package test.study2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class num3 {
	public static void main(String[] args) {
		//String[] grades= {"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"};
		//result="DS7651 A+", "OS1808 B-", "DB0001 B-", "AI5543 C0", "CA0055 D+", "AI0001 F"
		String[] grades= {"DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"};
		//"GP0000 A0", "PL6677 B+", "DM0106 B+"
		new num3().print(new num3().solution(grades));
	}
	class Score{
		String subject;
		int grade;
		int idx;
		public Score(String subject, int grade, int idx) {
			this.subject=subject;
			this.grade=grade;
			this.idx=idx;
		}
	}
	public String[] solution(String[] grades) {
        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<Score> arr = new ArrayList<Score>();
        for(int i=0;i<grades.length;i++) {
        	arr.add(new Score(grades[i].split(" ")[0], convertInt(grades[i].split(" ")[1]), i));
        }
        Collections.sort(arr, (a,b)->{
        	if(a.grade!=b.grade) {
        		return a.grade-b.grade;
        	}
        	return a.idx-b.idx;
        });
        HashSet<String> hs = new HashSet<String>();
        for(Score sc : arr) {
        	if(hs.contains(sc.subject)) continue;
        	hs.add(sc.subject);
        	answer.add(sc.subject+" "+convertStr(sc.grade));
        }
        
        return answer.stream().toArray(String[]::new);
    }
	public int convertInt(String s) {
		switch(s) {
		case "A+":
			return 1;
		case "A0":
			return 2;
		case "A-":
			return 3;
		case "B+":
			return 4;
		case "B0":
			return 5;
		case "B-":
			return 6;
		case "C+":
			return 7;
		case "C0":
			return 8;
		case "C-":
			return 9;
		case "D+":
			return 10;
		case "D0":
			return 11;
		case "D-":
			return 12;
		case "F":
			return 13;
		}
		return -1;
	}
	public String convertStr(int i) {
		switch(i) {
		case 1:
			return "A+";
		case 2:
			return "A0";
		case 3:
			return "A-";
		case 4:
			return "B+";
		case 5:
			return "B0";
		case 6:
			return "B-";
		case 7:
			return "C+";
		case 8:
			return "C0";
		case 9:
			return "C-";
		case 10:
			return "D+";
		case 11:
			return "D0";
		case 12:
			return "D-";
		case 13:
			return "F";
		}
		return "";
	}
	public void print(String[] arr) {
		for(String s:arr)System.out.println(s+" ");
		System.out.println();
	}
}
