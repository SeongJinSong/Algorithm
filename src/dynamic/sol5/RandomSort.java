package dynamic.sol5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
class RanArrayList{
	ArrayList<Integer> list = new ArrayList<Integer>();
	public boolean equals(Object o) {
		RanArrayList r = (RanArrayList)o;
		if(o instanceof RanArrayList) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i) != r.list.get(i)) {
					return false;
				}
			}
		}
		return true;
	}
	public int hashCode() {
		return (int)(Math.random()*1000000);
	}
}
public class RandomSort {
	static Map<RanArrayList, Double> d = new HashMap<RanArrayList, Double>();
	static void swap(RanArrayList a, int i, int j) {
		int tmp = a.list.get(i);
		a.list.set(i, a.list.get(j));
		a.list.set(j, tmp);
	}
	static double go(RanArrayList a) {
		if(d.containsKey(a)) return d.get(a);
		double ans = 0.0;
		int tot = 0;
		int n = a.list.size();
		for (int i=0; i<n-1; i++) {
	        for (int j=i+1; j<n; j++) {
	            if (a.list.get(i) > a.list.get(j)) {
	                swap(a, i, j);
	                ans += go(a);
	                tot += 1;
	                swap(a, i, j);
	            }
	        }
	    }
	    if (tot > 0) {
	        ans = ans / tot + 1;
	    }
	    d.put(a, ans);
	    return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		RanArrayList a = new RanArrayList();
		for(int i=0;i<n;i++) {
			a.list.add(sc.nextInt());
		}
		//System.out.println(go(a));
		System.out.println(d.containsKey(a));
	}
}
