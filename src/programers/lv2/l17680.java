package programers.lv2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class l17680 {
	public static void main(String[] args) {
//		int cacheSize=3; String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		int cacheSize=3; String[] cities= {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(new l17680().solution3(cacheSize, cities));
	}
	public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0)return 5*cities.length;
        int answer = 0;
        Queue<String> q = new LinkedList<String>();
        for(int i=0;i<cities.length;i++){
            Queue<String> findResult = find(q, cities[i].toLowerCase());
            if(findResult!=null){
                q = findResult;
                answer++;
            }
            else {
                answer+=5;
            }
            if(findResult==null&&q.size()<cacheSize){
                q.add(cities[i].toLowerCase());
            }
            else if(findResult==null&&q.size()==cacheSize){
                q.poll();
                q.add(cities[i].toLowerCase());
            }
        }
        return answer;
    }
    public Queue<String> find(Queue<String> q, String s){
        Iterator it = q.iterator();
        String target = "";
        Queue<String> resq = new LinkedList<String>();
        while(it.hasNext()){
            String next = (String)it.next();
            if(next.equals(s)){
                target = next;
            }
            else resq.add(next);
        }
        if(!"".equals(target)){
            resq.add(target);
            return resq;
        }
        return null;
    }
    static class LRU<K, V> extends LinkedHashMap<K, V>{
    	private int size;
    	private LRU(int size) {
    		super(size, 0.75f, true);
    		this.size=size;
    	}
    	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    		return size() > size;
    	}
    	public static<K, V> LRU<K,V> newInstance(int size){
    		return new LRU<K, V>(size);
    	}
    }
    public int solution2(int cacheSize, String[] cities) {
    	int answer = 0;
    	LRU<String, String> clsTemp = LRU.newInstance(cacheSize);
    	for(int i=0;i<cities.length;i++) {
    		String sTemp = cities[i].toUpperCase();
    		if(clsTemp.containsKey(sTemp)) {
    			answer++;
    		}else answer+=5;
    		clsTemp.put(sTemp, sTemp);
    	}
    	return answer;
    }
    public int solution3(int cacheSize, String[] cities) {
        if(cacheSize==0)return 5*cities.length;
        int answer = 0;
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0;i<cities.length;i++){
        	String tmps = cities[i].toLowerCase();
        	boolean findResult = arr.contains(tmps);
            if(findResult) {
            	arr.remove(tmps);
            	answer++;
            }
            else {
            	if(arr.size()==cacheSize){
                	arr.remove(0);
                }
                answer+=5;
            }
            arr.add(tmps);
        }
        return answer;
    }
}
