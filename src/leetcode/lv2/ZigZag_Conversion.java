package leetcode.lv2;

public class ZigZag_Conversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING"; int numRows=3;
		System.out.println(new ZigZag_Conversion().convert2(s, numRows));
	}
	public String convert(String s, int numRows) {
        int col = (s.length()<=numRows)?1
            :(1+(int)Math.ceil((double)(s.length()-numRows)/2/(numRows-1))*(numRows-1));
        if(col==1)return s;
        char[][] carr = new char[numRows][col];
        int[] dy = {1, -1};
        int[] dx = {0, 1};
        carr[0][0]=s.charAt(0);
        int cury=0;
        int curx=0;
        int dir=0;
        for(int i=0;i<s.length()-1;i++){
            int ny=cury+dy[dir%2];
            int nx=curx+dx[dir%2];
            if(cango(ny, nx, numRows, col)){
                cury=ny;
                curx=nx;
                carr[cury][curx]=s.charAt(i+1);
            }else{
                dir++;
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<col;j++){
                if(carr[i][j]!=0){
                    sb.append(carr[i][j]);
                }
            }
        }
        return sb.toString();
    }
    public boolean cango(int ny, int nx, int numRows, int col){
        if(ny<0||ny>=numRows||nx<0||nx>=col)return false;
        return true;
    }
    public String convert2(String s, int numRows) {
    	if(s.length()==numRows) return s;
    	if(numRows==1) return s;
    	String[] rowStr = new String[numRows];
    	for(int i=0;i<numRows;i++) {
    		rowStr[i]="";
    	}
    	String[] strs = s.split("");
    	int rowNum=0;
    	boolean isPlus = true;
    	// 그냥 rowString을 처리하는게 훨씬 쉽게 푸는 풀이이다.
    	for(String str : strs) {
    		rowStr[rowNum]+=str;
    		if(isPlus) {
    			rowNum++;
    		}else {
    			rowNum--;
    		}
    		if(rowNum==numRows-1) {
    			isPlus=false;
    		}
    		if(rowNum==0) {
    			isPlus = true;
    		}
    	}
    	String answer = "";
    	for(String str : rowStr) {
    		answer+=str;
    	}
    	return answer;
    }
}
