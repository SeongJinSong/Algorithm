package programers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

public class l1836 {
	public static void main(String[] args) {
//		int m=3, n=3; String[] board= {"DBA", "C*A", "CDB"}; //ABCD
//		int m=2, n=4; String[] board= {"NRYN", "ARYA"}; //RYAN
//		int m=4, n=4; String[] board= {".ZI.", "M.**", "MZU.", ".IU."}; //MUZI
		int m=2, n=2; String[] board= {"AB", "BA"}; //IMPOSSIBLE
		
		System.out.println(new l1836().solution(m, n, board));
	}
	public String solution(int m, int n, String[] board) {
		int[][] hurdle = new int[m][n];
		HashSet<Character> chs = new HashSet<Character>();
		HashMap<Character, Boolean> chcheck = new HashMap<Character,Boolean>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				char c = board[i].charAt(j);
				if(c!='.')hurdle[i][j]=c;
				if(c!='.'&&c!='*')chs.add(c);
			}
		}
		ArrayList<Character> carr = new ArrayList<Character>();
		Iterator<Character> it = chs.iterator();
		while(it.hasNext()) {
			char a = it.next();
			chcheck.put(a, false);
			carr.add(a);
		}
		Collections.sort(carr);
		ArrayList<Character> rarr = new ArrayList<Character>();
		for(int i=0;i<carr.size();i++) {
			for(int j=0;j<carr.size();j++) {
				if(chcheck.get(carr.get(j)))continue;
				String[] loc = findLocation(carr.get(j), board);
				if(canEraseCheckXFirst(loc, hurdle)||canEraseCheckYFirst(loc, hurdle)) {
					erase(loc, hurdle);
					chcheck.put(carr.get(j), true);
					rarr.add(carr.get(j));
					break;
				}
			}
		}
		String err = "IMPOSSIBLE";
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(hurdle[i][j]=='*')continue;
				if(hurdle[i][j]!=0)return err;
			}
		}
        return rarr.stream().map(String::valueOf)
                .collect(Collectors.joining());
    }
	public void erase(String[] loc, int[][] hurdle) {
		int sY = Integer.valueOf(loc[0].split(" ")[0]);
		int sX = Integer.valueOf(loc[0].split(" ")[1]);
		int eY = Integer.valueOf(loc[1].split(" ")[0]);
		int eX = Integer.valueOf(loc[1].split(" ")[1]);
		hurdle[sY][sX]=0;
		hurdle[eY][eX]=0;
	}
	public boolean canEraseCheckXFirst(String[] loc, int[][] hurdle) {
		int sY = Integer.valueOf(loc[0].split(" ")[0]);
		int sX = Integer.valueOf(loc[0].split(" ")[1]);
		int eY = Integer.valueOf(loc[1].split(" ")[0]);
		int eX = Integer.valueOf(loc[1].split(" ")[1]);
		int tmpX = sX;
		int tmpY = sY;
		if(sX>eX) {
			while(tmpX>eX) {
				if(--tmpX==eX&&sY==eY) continue;
				else if(hurdle[sY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		else {
			while(tmpX<eX) {
				if(++tmpX==eX&&sY==eY) continue;
				else if(hurdle[sY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		if(sY>eY) {
			while(tmpY>eY) {
				if(--tmpY==eY&&tmpX==eX) continue;
				else if(hurdle[tmpY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		else {
			while(tmpY<eY) {
				if(++tmpY==eY&&tmpX==eX) continue;
				else if(hurdle[tmpY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		return true;
	}
	public boolean canEraseCheckYFirst(String[] loc, int[][] hurdle) {
		int sY = Integer.valueOf(loc[0].split(" ")[0]);
		int sX = Integer.valueOf(loc[0].split(" ")[1]);
		int eY = Integer.valueOf(loc[1].split(" ")[0]);
		int eX = Integer.valueOf(loc[1].split(" ")[1]);
		int tmpY = sY;
		int tmpX = sX;
		if(sY>eY) {
			while(tmpY>eY) {
				if(--tmpY==eY&&sX==eX) continue;
				else if(hurdle[tmpY][sX]!=0) {
					return false;
				}
				else continue;
			}
		}
		else {
			while(tmpY<eY) {
				if(++tmpY==eY&&sX==eX) continue;
				else if(hurdle[tmpY][sX]!=0) {
					return false;
				}
				else continue;
			}
		}
		if(sX>eX) {
			while(tmpX>eX) {
				if(--tmpX==eX&&tmpY==eY) continue;
				else if(hurdle[tmpY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		else {
			while(tmpX<eX) {
				if(++tmpX==eX&&tmpY==eY) continue;
				else if(hurdle[tmpY][tmpX]!=0) {
					return false;
				}
				else continue;
			}
		}
		return true;
	}
	public String[] findLocation(char c, String[] board) {
		ArrayList<String> arr =new ArrayList<String>();
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length();j++) {
				if(board[i].charAt(j)==c) {
					arr.add(i+" "+j);
				}
			}
		}
		return arr.stream().toArray(String[]::new);
	}
}
