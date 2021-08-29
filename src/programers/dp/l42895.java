package programers.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.BinaryOperator;

/* 혼자서 다시 풀어보기 -- dfs 방식 과 dp 방식 둘다 */
public class l42895 {
	private int n;
	private int target;
	private int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[] N = {5, 2};
		int[] number = {12, 11};
		l42895 l4 = new l42895();
//		System.out.println(l4.solution(N[0], number[0]));
//		System.out.println(l4.solution(N[1], number[1]));
//		System.out.println(solution2(N[0], number[0]));
//		System.out.println(solution2(N[1], number[1]));
//		System.out.println(solution3(N[1], number[1]));
		System.out.println(solution4(N[1], number[1]));
	}
	public int solution(int N, int number) {
        n=N;
        target = number;
        dfs(0,0);
        return answer == Integer.MAX_VALUE ?-1:answer;
    }
	public void dfs(int count, int prev) {
		if(count > 8) {
			answer = -1;
			return;
		}
		if(prev == target) {
			answer = Math.min(answer, count);
			return;
		}
		int tempN = n;
		for(int i=0;i<8-count;i++) {
			int newCount = count + i + 1;
			dfs(newCount, prev + tempN);
			dfs(newCount, prev - tempN);
			dfs(newCount, prev / tempN);
			dfs(newCount, prev * tempN);
			tempN= tempN * 10 + n;
		}
	}
	/* DP 방식으로 푼 풀이 */
	public static int solution2(int N, int number) {
		int answer = -1;
		Set<Integer>[] setArr = new Set[9];
		int t = N;
		for(int i=1;i<9;i++) {
			setArr[i]=new HashSet<Integer>();
			setArr[i].add(t);
			t=t*10+N;
		}
		for(int i=1;i<9;i++) {
			for(int j=1; j<i; j++) {
				for(Integer a : setArr[j]) {
					for(Integer b : setArr[i-j]) {
						setArr[i].add(a+b);
						setArr[i].add(a-b);
						setArr[i].add(b-a);
						setArr[i].add(a*b);
						if(b!=0) {
							setArr[i].add(a/b);
						}
						if(a!=0) {
							setArr[i].add(b/a);
						}
					}
				}
			}
		}
		for(int i=1;i<9;i++) {
			if(setArr[i].contains(number)) {
				answer=i;
				break;
			}
		}
		return answer;
	}
	/* loop label 기능을 처음 알았다, enum을 이용한 깔끔한 calc 처리도 좋다*/
	public static int solution3(int N, int number) {
		int answer = -1;
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		HashSet<Integer> s = new HashSet<>();
		s.add(N);
		map.put(1, s);
		
		loop : for(int i=2;i<9;i++) {
			HashSet<Integer> set = new LinkedHashSet<Integer>();
			// 이게 nn, nnn, nnnn 을 처음보는 라이브러리 함수를 이용해서 구현..
			int NNN = Integer.parseInt(Integer.toBinaryString((int)Math.pow(2,i)-1))*N;
			if(NNN==number) {
				return i;
			}
			set.add(NNN);
			
			for(int j=1;j<=i/2;j++) {
				Iterator<Integer> it1 = map.get(j).iterator();
				Iterator<Integer> it2 = map.get(i-j).iterator();
				
				while(it1.hasNext()) {
					int itValue1 = it1.next();
					while(it2.hasNext()) {
						int itValue2 = it2.next();
						for(Operator o : Operator.values()) {
							int calc = o.calculate(itValue1, itValue2);
							if(calc == number) {
								answer=i;
								break loop;
							}
							set.add(calc);
						}
					}
				}
			}
			map.put(i, set);
		}
		return answer;
	}
	enum Operator{
		PLUS{
			@Override
			public int calculate(int i, int j) {
				return i+j;
			}
		},
		MINUS{
			@Override
			public int calculate(int i, int j) {
				return i-j;
			}
		},
		BMINUS{
			@Override
			public int calculate(int i, int j) {
				return j-i;
			}
		},
		MUL{
			@Override
			public int calculate(int i, int j) {
				return i*j;
			}
		},
		DIV{
			@Override
			public int calculate(int i, int j) {
				if(j==0)return 0;
				return i/j;
			}
		},
		BDIV{
			@Override
			public int calculate(int i, int j) {
				if(i==0)return 0;
				return j/i;
			}
		};
		public abstract int calculate(int i, int j);
	}
	/* enum 오페레이션이 제일 깔끔하고 apply라는 함수를 사용*/
	public static int solution4(int N, int number) {
		HashMap<Integer, Set<Integer>> valueStore = new HashMap<>();
		if(N==number) return 1;
		
		int i;
		for(i=1;i<=8;i++) {
			Set<Integer> iSet = new HashSet<>();
			int NNN=0;
			for(int j=0;j<i;j++) NNN = NNN*10+N;
			
			if(NNN==number) return i;
			else iSet.add(NNN);
			
			for(int j=1;j<=i/2;j++) {
				for(Integer a : valueStore.get(j)) {
					for(Integer b : valueStore.get(i-j)) {
						int opResult = 0;
						for(Operation o : Operation.values()) {
							opResult = o.calc(a, b);
							if(opResult == number) return i;
							else iSet.add(opResult);
						}
					}
				}
			}
			valueStore.put(i,  iSet);
		}
		return -1;
	}
	enum Operation{
		ADD((a,b) -> a+b), 
		SUB((a,b)->a-b), BSUB((a,b)->b-a),
		MIL((a,b)->a*b),
		DIV((a,b)->a/b), BDIV((a,b)->b/a)
		;
		private BinaryOperator<Integer> bo;
		private Operation(BinaryOperator<Integer> bo) {this.bo=bo;}
		public int calc(int a, int b) {
			try{
				return bo.apply(a, b);
			}catch(Exception e) {
				return 0;
			}
		}
	}
}
