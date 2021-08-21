package programers.hash;

import java.util.HashMap;

public class l42577 {
	public static void main(String[] args) {
		String [] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
	/* ��� �� �̰� �ؽø� ����ϴ��� ���ظ� ������..
	 * �� ������ Ǭ�� �ƴ϶� �ٽ�Ǯ����� */
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Integer> pb = new HashMap<String, Integer>();
		for(int i=0;i<phone_book.length;i++) {
			pb.put(phone_book[i],i);
		}
		
		for(int i=0;i<phone_book.length;i++)
			for(int j=1;j<phone_book[i].length();j++) {
				if(pb.containsKey(phone_book[i].substring(0,j))) {
					return false;
				}
			}
		return answer;
	}
	/* best solution �� �ִ��� */
	public boolean solutionbest(String[] phoneBook) {
	       for(int i=0; i<phoneBook.length-1; i++) {
	            for(int j=i+1; j<phoneBook.length; j++) {
	                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
	                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
	            }
	        }
	        return true;
	    }
	/*ó�� Ǯ���� Ǯ��*/
	public static boolean solution1(String[] phone_book) {
		boolean answer = true;
		for(int i=0;i<phone_book.length;i++) {
			for(int j=i+1;j<phone_book.length;j++) {
				if(phone_book[i].length()>phone_book[j].length()) {
					String tmp = phone_book[i];
					phone_book[i] = phone_book[j];
					phone_book[j] = tmp;
				}
			}
		}
		for(int i=0;i<phone_book.length;i++) {
			for(int j=i+1;j<phone_book.length;j++) {
				if(phone_book[i].length()==phone_book[j].length())continue;
				for(int k=0;k<phone_book[i].length();k++) {
					if(phone_book[i].charAt(k)!=phone_book[j].charAt(k)) {
						break;
					}
					if(k==phone_book[i].length()-1)return false;
				}
			}
		}
        return answer;
    }
	/*replace�� �̿��� �������*/
	public boolean solution2(String[] phone_book) {
        boolean answer = true;
        for(int i =0; i<phone_book.length; i++) {
            for(int j =0; j<phone_book.length; j++) {
                if((phone_book[j].replace(phone_book[i], "*")).indexOf("*") == 0
                 && phone_book[j] != phone_book[i]) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}
