package programers.lv2;

import java.util.HashMap;

public class l17677 {
	public static void main(String[] args) {
		String str1="FRANCE", str2="french";
		System.out.println(new l17677().solution(str1, str2));
	}
	public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.equals(str2))return 65536;
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
        HashMap<String, Integer> hm3 = new HashMap<String, Integer>();
        for(int i=0;i<str1.length()-1;i++){
            String tmp=str1.substring(i,i+2);
            if(!tmp.matches("[a-z]{2}"))continue;
            System.out.println("1:"+tmp);
            hm1.put(tmp, hm1.getOrDefault(tmp, 0)+1);
            hm3.put(tmp, hm3.getOrDefault(tmp, 0)+1);
        }
        for(int i=0;i<str2.length()-1;i++){
            String tmp=str2.substring(i,i+2);
            if(!tmp.matches("[a-z]{2}"))continue;
            System.out.println("2:"+tmp);
            hm2.put(tmp, hm2.getOrDefault(tmp, 0)+1);
            hm3.put(tmp, hm3.getOrDefault(tmp, 0)+1);
        }
        if(hm1.size()==0&&hm2.size()==0)return 65536;
        //교집합 hm1.size()+hm2.size()-hm3.size();
        int intersect = 0;
        for(String s : hm3.keySet()){
            if(hm1.containsKey(s)&&hm2.containsKey(s)){
                intersect+=Math.min(hm1.get(s), hm2.get(s));
            }
            System.out.println("## s:"+s+" intersect:"+intersect);
        }
        //합집합
        int total = 0;
        for(String s : hm3.keySet()){
            if(hm1.containsKey(s)&&hm2.containsKey(s)){
                total+=Math.max(hm1.get(s), hm2.get(s));
            }else if(hm1.containsKey(s)){
                total+=hm1.get(s);
            }else if(hm2.containsKey(s)){
                total+=hm2.get(s);
            }
            System.out.println("## s:"+s+" total:"+total);
        }
        System.out.println("intersect:"+intersect+" total:"+total);
        double answer = (double)intersect/total*65536;
        System.out.println("answer:"+answer);
        return (int)answer;
    }
}
