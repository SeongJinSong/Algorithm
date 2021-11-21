package programers.lv2;

import java.util.ArrayList;

public class l17679 {
	public static void main(String[] args) {
//		int m=4, n=5; String[] board= {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int m=6, n=6; String[] board= {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(new l17679().solution(m, n, board));
	}
	int answer = 0;
    public int solution(int m, int n, String[] board) {
        char[][] pan = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pan[i][j]=board[i].charAt(j);
            }
        }
        while(erase(pan, m, n)){
            for(int i=0;i<n;i++){
                down(pan, m, n, i);
            }
        }
        return answer;
    }
    public boolean erase(char[][] pan, int m, int n){
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(pan[i][j]!=' '
                   &&pan[i][j]==pan[i+1][j]
                   &&pan[i][j]==pan[i][j+1]
                   &&pan[i][j]==pan[i+1][j]
                   &&pan[i][j]==pan[i+1][j+1]){
                	arr.add(i+ " "+ j);
                }
            }
        }
        for(String loc : arr){
        	int y = Integer.valueOf(loc.split(" ")[0]);
        	int x = Integer.valueOf(loc.split(" ")[1]);
            if(pan[y][x]!=' ') answer++;
            if(pan[y+1][x]!=' ') answer++;
            if(pan[y][x+1]!=' ') answer++;
            if(pan[y+1][x+1]!=' ') answer++;
            pan[y][x]=' ';
            pan[y+1][x]=' ';
            pan[y][x+1]=' ';
            pan[y+1][x+1]=' ';
        }
        return arr.size()>0;
    }
    public void down(char[][] pan, int m, int n, int selectedCol){
        int start=-1;
        int gap=-1;
        for(int i=m-1;i>0;i--){
            if(pan[i][selectedCol]==' '){
                start = i;
                int r = findNotBlankRow(pan, i, selectedCol);
                if(r==-1)return;
                gap = i-r;
                break;
            }
        }
        if(start==-1||gap==-1)return;
        for(int i=start;i>=gap;i--){
            pan[i][selectedCol]=pan[i-gap][selectedCol];
        }
    }
    public int findNotBlankRow(char[][] pan, int row, int selectedCol){
        for(int i=row-1;i>=0;i--){
            if(pan[i][selectedCol]==' ')continue;
            else return i;
        }
        return -1;
    }
}
