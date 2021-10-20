package programers.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class l42888 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		print(new l42888().solution(record));
	}
	public String[] solution(String[] record) {
        HashMap<String, User> hm = new HashMap<String, User>();
        ArrayList<String> arr = new ArrayList<String>();
		for(String s : record) {
			if(!"Leave".equals(s.split(" ")[0])){
				hm.put(s.split(" ")[1], new User(s.split(" ")[2]));
			}
        }
		for(String s : record) {
			if("Enter".equals(s.split(" ")[0])){
				arr.add(hm.get(s.split(" ")[1]).getNickName()+"님이 들어왔습니다.");
			}
			else if("Leave".equals(s.split(" ")[0])) {
				arr.add(hm.get(s.split(" ")[1]).getNickName()+"님이 나갔습니다.");
			}
		}
        return arr.stream().toArray(String[]::new);
    }
	class User{
		private String nickName;
		public User(String nickName) {
			this.nickName = nickName;
		}
		public void setNickName(String nickName) {
			this.nickName=nickName;
		}
		public String getNickName() {
			return this.nickName;
		}
	}
	public static void print(String[] arr) {
		for(String s : arr)System.out.println(s);
	}
}
