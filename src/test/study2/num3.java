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
		Grade grade;
		int idx;
		public Score(String subject, Grade grade, int idx) {
			this.subject=subject;
			this.grade=grade;
			this.idx=idx;
		}
	}
	enum Grade{
		A1("A+",1), A2("A0",2), A3("A-",2),
		B1("B+",4), B2("B0",5), B3("B-",6),
		C1("C+",7), C2("C0",8), C3("C-",9),
		D1("D+",10), D2("D0",11), D3("D-",12)
		,F("F", 13), NaN("Nan", -1);
		private String grade;
		private int order;
		Grade(String grade, int order){
			this.grade=grade;
			this.order=order;
		}
		Grade(String grade){
			this.grade=grade;
			for(Grade d : Grade.values()) {
				if(grade.equals(d.grade)) {
					this.order=d.order;
				};
			}
		}
		public String getGrade() {
			return grade;
		}
		public int getOrder() {
			return order;
		}
		//Grade.of만으로 enum값을 세팅하려면 이 함수를 static으로 만들어야한다.
		public static Grade of(String grade) {
			for(Grade d : Grade.values()) {
				if(grade.equals(d.grade)) {
					return d;
				};
			}
			return null;
		}
	}
	public String[] solution(String[] grades) {
        ArrayList<String> answer = new ArrayList<String>();
        ArrayList<Score> arr = new ArrayList<Score>();
        for(int i=0;i<grades.length;i++) {
        	//Grade.NaN 이런식으로 써야 ENUM 객체가 생성된다.
        	//Grade.of로 사용하려면 static 변수로 만들어야 한다.
        	arr.add(new Score(grades[i].split(" ")[0], Grade.of(grades[i].split(" ")[1]), i));
        }
        Collections.sort(arr, (a,b)->{
        	if(a.grade.getOrder()!=b.grade.getOrder()) {
        		return a.grade.getOrder()-b.grade.getOrder();
        	}
        	return a.idx-b.idx;
        });
        HashSet<String> hs = new HashSet<String>();
        for(Score sc : arr) {
        	if(hs.contains(sc.subject)) continue;
        	hs.add(sc.subject);
        	answer.add(sc.subject+" "+sc.grade.getGrade());
        }
        return answer.stream().toArray(String[]::new);
    }
	public void print(String[] arr) {
		for(String s:arr)System.out.println(s+" ");
		System.out.println();
	}
}
