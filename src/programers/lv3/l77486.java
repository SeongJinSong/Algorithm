package programers.lv3;

import java.util.HashMap;

public class l77486 {
	public static void main(String[] args) {
		String[] enroll= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral= {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"young", "john", "tod", "emily", "mary"};
		int[] amount= {12, 4, 2, 5, 10};
		new l77486().print(new l77486().solution(enroll, referral, seller, amount));
	}
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i=0;i<enroll.length;i++) {
			hm.put(enroll[i], i);
		}
        for(int i=0;i<amount.length;i++) {
        	CalcMoney(seller[i], amount[i]*100, referral, enroll, answer, hm);
        }
        return answer;
    }
	public void CalcMoney(String cur_name, int sendAmount, String[] referral, String[] enroll, int[] answer, HashMap<String, Integer> hm) {
		int idx=hm.get(cur_name);
		int reffeeral_amount = sendAmount/10;
		answer[idx] += sendAmount - reffeeral_amount;
		String refferral_name = referral[idx];
		if("-".equals(refferral_name))return;
		if(reffeeral_amount!=0)CalcMoney(refferral_name, reffeeral_amount, referral, enroll, answer, hm);
		
	}
	public void print(int[] arr) {
		for(int i:arr)System.out.print(i+" ");
		System.out.println();
	}
}
